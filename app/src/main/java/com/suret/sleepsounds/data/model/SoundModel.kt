package com.suret.sleepsounds.data.model

import android.os.Parcelable
import com.suret.sleepsounds.data.enum.SoundTypeEnum
import kotlinx.parcelize.Parcelize

@Parcelize
data class SoundModel(val image: Int, val packName: String, val type: SoundTypeEnum) : Parcelable
