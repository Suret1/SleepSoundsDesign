package com.suret.sleepsounds.ui.composer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.suret.sleepsounds.data.listmaker.ListMaker.getCategoryList
import com.suret.sleepsounds.databinding.FragmentComposerBinding
import com.suret.sleepsounds.ui.composer.adapter.MainRecyclerAdapter


class ComposerFragment : Fragment() {
    private val binding by lazy { FragmentComposerBinding.inflate(layoutInflater) }
    private var adapter = MainRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initAdapter()

        adapter.submitList(getCategoryList())
        return binding.root
    }

    private fun initAdapter() {
        binding.rvMain.adapter = adapter
    }
}