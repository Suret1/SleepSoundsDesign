package com.suret.sleepsounds.data.dto

import com.suret.sleepsounds.data.enum.SoundTypeEnum.*
import com.suret.sleepsounds.data.model.SoundModel

fun List<SoundModel>.asAllList() =
    filter { it.type == All }

fun List<SoundModel>.asInstrumentalList() =
    filter { it.type == Instrumental }

fun List<SoundModel>.asAmbientList() =
    filter { it.type == Ambient }