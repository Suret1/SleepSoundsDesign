package com.suret.sleepsounds.data.listmaker

import com.suret.sleepsounds.R
import com.suret.sleepsounds.data.enum.SoundTypeEnum.*
import com.suret.sleepsounds.data.model.CategoryItem
import com.suret.sleepsounds.data.model.ComposerCategory
import com.suret.sleepsounds.data.model.SongModel
import com.suret.sleepsounds.data.model.SoundModel

object ListMaker {

    fun getSoundList(): List<SoundModel> {
        val list: ArrayList<SoundModel> = arrayListOf()
        list.add(SoundModel(R.drawable.joker, "Joker", All))
        list.add(SoundModel(R.drawable.road, "Road", Ambient))
        list.add(SoundModel(R.drawable.anonymous, "V for Vendetta", Instrumental))
        list.add(SoundModel(R.drawable.cyberpunk, "Cyberpunk 2077", All))
        list.add(SoundModel(R.drawable.pubg, "Pubg", Ambient))
        list.add(SoundModel(R.drawable.csgo, "CS:GO", Instrumental))
        list.add(SoundModel(R.drawable.bmw, "BMW", All))
        list.add(SoundModel(R.drawable.glass, "Glass", Ambient))
        return list
    }

    fun getSongList(): List<SongModel> {
        val list: ArrayList<SongModel> = arrayListOf()
        list.add(SongModel(1, "Name of Song"))
        list.add(SongModel(2, "Name of Song"))
        list.add(SongModel(3, "Name of Song"))
        list.add(SongModel(4, "Name of Song"))
        list.add(SongModel(5, "Name of Song"))
        return list
    }

    fun getCategoryList(): List<ComposerCategory> {
        val list: ArrayList<ComposerCategory> = arrayListOf()
        list.add(
            ComposerCategory(
                "Child",
                "Quickly stabilize your baby’s emotions",
                getCategoryItemList()
            )
        )
        list.add(
            ComposerCategory(
                "Nature",
                "It will allow you to merge with nature",
                getCategoryItemList()
            )
        )
        list.add(
            ComposerCategory(
                "Animals",
                "These sounds will help you forget about the silence",
                getCategoryItemList()
            )
        )

        return list
    }

    fun getCategoryItemList(): List<CategoryItem> {
        val list: ArrayList<CategoryItem> = arrayListOf()
        list.add(CategoryItem(R.drawable.ic_girl, "Female voice"))
        list.add(CategoryItem(R.drawable.ic_noise, "White noise"))
        list.add(CategoryItem(R.drawable.ic_lullaby, "Lullaby"))
        list.add(CategoryItem(R.drawable.ic_girl, "Female voice"))
        list.add(CategoryItem(R.drawable.ic_noise, "White noise"))
        list.add(CategoryItem(R.drawable.ic_lullaby, "Lullaby"))
        return list
    }

}