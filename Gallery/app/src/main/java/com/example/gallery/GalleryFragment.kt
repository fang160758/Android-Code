package com.example.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

    lateinit var galleryViewModel: GalleryViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) {
//            R.id.swipeRefreshLayout -> {
//                swipeRefreshLayout.isRefreshing = false
//                Handler().postDelayed(Runnable {
//                    galleryViewModel.fetchData()
//                },1000)
//            }
//        }
//
//        return super.onOptionsItemSelected(item)
//    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.menu,menu)
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        var galleryAdapter: GalleryAdapter = GalleryAdapter()
        recyclerView?.apply {
            adapter = galleryAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

        galleryViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        ).get(GalleryViewModel::class.java)
        galleryViewModel.photoListLive.observe(viewLifecycleOwner, Observer {
            galleryAdapter.submitList(it)
            swipeRefreshLayout.isRefreshing = false
        })

        galleryViewModel.photoListLive.value ?: galleryViewModel.fetchData()
        swipeRefreshLayout.setOnRefreshListener {
            galleryViewModel.fetchData()
        }

    }

}