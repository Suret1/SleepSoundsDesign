package com.suret.sleepsounds.ui.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import com.suret.sleepsounds.R
import com.suret.sleepsounds.data.dto.asAllList
import com.suret.sleepsounds.data.dto.asAmbientList
import com.suret.sleepsounds.data.dto.asInstrumentalList
import com.suret.sleepsounds.data.listmaker.ListMaker
import com.suret.sleepsounds.databinding.FragmentSleepBinding
import com.suret.sleepsounds.ui.sleep.adapter.MyViewPagerAdapter

class SleepFragment : Fragment() {
    private val binding by lazy { FragmentSleepBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initViewPagerAdapter()
        setTabPadding()
        return binding.root
    }

    private fun initViewPagerAdapter() {
        val list = ListMaker.getSoundList()
        val adapter = MyViewPagerAdapter(this)
        adapter.addFragment(SleepItemListFragment.newInstance(list.asAllList()))
        adapter.addFragment(SleepItemListFragment.newInstance(list.asInstrumentalList()))
        adapter.addFragment(SleepItemListFragment.newInstance(list.asAmbientList()))

        with(binding) {
            viewpagerSleep.adapter = adapter
            viewpagerSleep.getChildAt(0)?.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            TabLayoutMediator(tabLayoutSleep, viewpagerSleep) { tab, position ->
                tab.text = getTitles()[position]
                tab.icon = ContextCompat.getDrawable(requireContext(), getIcons()[position])
            }.attach()
        }
    }

    private fun setTabPadding() {
        with(binding) {
            for (i in 0 until tabLayoutSleep.childCount) {
                tabLayoutSleep.getChildAt(i).setPadding(10, 10, 10, 10)
            }
            for (i in 0..tabLayoutSleep.tabCount) {
                val params =
                    tabLayoutSleep.getTabAt(i)?.view?.getChildAt(0)?.layoutParams as LinearLayout.LayoutParams?
                params?.rightMargin = 0
                tabLayoutSleep.getTabAt(i)?.view?.getChildAt(0)?.layoutParams = params
            }
        }
    }

    private fun getTitles(): List<String> {
        val listOfTitles: ArrayList<String> = arrayListOf()
        listOfTitles.add(getString(R.string.all))
        listOfTitles.add(getString(R.string.instrumental))
        listOfTitles.add(getString(R.string.ambient))
        return listOfTitles
    }

    private fun getIcons(): List<Int> {
        val listOfIcon: ArrayList<Int> = arrayListOf()
        listOfIcon.add(R.drawable.ic_dots_menu)
        listOfIcon.add(R.drawable.ic_guitar)
        listOfIcon.add(R.drawable.ic_prenatal)
        return listOfIcon
    }
}