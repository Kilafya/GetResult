package com.android.getresult.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.android.getresult.databinding.FragmentImagesListBinding

private const val MIMETYPE_IMAGE = "image/*"

class ImagesListFragment : Fragment() {

    private var _binding: FragmentImagesListBinding? = null
    private val binding: FragmentImagesListBinding get() = _binding!!

    private val adapter = ImagesListAdapter()

    private val getContentLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let { adapter.updateList(Photo(it)) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImagesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListener()
        setupRecyclerView()
    }

    private fun setupClickListener() {
        binding.fabAddPhoto.setOnClickListener {
            getContentLauncher.launch(MIMETYPE_IMAGE)
        }
    }

    private fun setupRecyclerView() {
        binding.rvListOfPhoto.adapter = adapter
    }

}