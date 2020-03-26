package com.ephemeraldreams.androidbootstrap.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ephemeraldreams.androidbootstrap.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment

class HomeFragment : DaggerFragment() {

    private val homeViewModel: HomeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            viewBinding.homeTextView.text = it
        })
        viewBinding.homeFab.setOnClickListener {
            Snackbar.make(it, "Snacking!", Snackbar.LENGTH_SHORT).show()
        }
        return viewBinding.root
    }
}
