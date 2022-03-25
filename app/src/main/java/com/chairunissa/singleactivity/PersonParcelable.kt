package com.chairunissa.singleactivity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonParcelable(
    val name: String,
    val age: String? = null,
    val address: String? = null,
    val job: String? = null
) : Parcelable
