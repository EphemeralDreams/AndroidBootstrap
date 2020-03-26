package com.ephemeraldreams.androidbootstrap.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ephemeraldreams.androidbootstrap.databinding.FragmentDashboardBinding
import dagger.android.support.DaggerFragment

class DashboardFragment : DaggerFragment() {

    private val dashboardViewModel: DashboardViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            viewBinding.dashboardTextView.text = it
        })
        return viewBinding.root
    }
}
