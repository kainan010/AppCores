package com.naniak.appcores.adapter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RgbModel(
    val resultado: Int,
    val rgb: Triple<Int?, Int?, Int?>?,
    val hex: String?
): Parcelable




