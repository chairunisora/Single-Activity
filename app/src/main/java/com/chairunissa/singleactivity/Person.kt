package com.chairunissa.singleactivity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val age: String,
    val address: String,
    val job: String
) : Parcelable
