package com.suret.sleepsounds.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.suret.sleepsounds.R
import com.suret.sleepsounds.data.listmaker.ListMaker.getSongList
import com.suret.sleepsounds.data.listmaker.ListMaker.getSoundList
import com.suret.sleepsounds.databinding.FragmentProfileBinding
import com.suret.sleepsounds.util.DividerItemDecorator
import com.suret.sleepsounds.ui.profile.adapter.SongAdapter
import com.suret.sleepsounds.ui.profile.adapter.SoundAdapter

class ProfileFragment : Fragment() {
    private val binding by lazy { FragmentProfileBinding.inflate(layoutInflater) }
    private var adapter = SongAdapter()
    private var soundAdapter = SoundAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initAdapters()
        adapter.submitList(getSongList())
        binding.rvSong.addItemDecoration(
            DividerItemDecorator(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.recycler_view_divider
                )
            )
        )
        soundAdapter.submitList(getSoundList())

        return binding.root
    }

    private fun initAdapters() {
        with(binding) {
            rvSong.adapter = adapter
            rvSound.adapter = soundAdapter
        }
    }
}