package com.suret.sleepsounds.ui.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.suret.sleepsounds.data.model.SoundModel
import com.suret.sleepsounds.databinding.FragmentSleepItemListBinding
import com.suret.sleepsounds.ui.profile.adapter.SoundAdapter
import com.suret.sleepsounds.util.EqualSpacingItemDecoration
import com.suret.sleepsounds.util.Util.dpToPx

class SleepItemListFragment : Fragment() {
    private val binding by lazy { FragmentSleepItemListBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val list = arguments?.getParcelableArrayList<SoundModel>(SOUND_LIST)

        binding.apply {
            val adapter = SoundAdapter()

            adapter.submitList(list)

            recycler.adapter = adapter

            recycler.addItemDecoration(
                EqualSpacingItemDecoration(
                    dpToPx(4),
                    LinearLayoutManager.VERTICAL
                )
            )
        }

    }

    companion object {
        private const val SOUND_LIST = "sound_list"

        fun newInstance(list: List<SoundModel>?) =
            SleepItemListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(SOUND_LIST, ArrayList(list))
                }
            }
    }
}