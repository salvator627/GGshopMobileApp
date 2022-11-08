package com.example.ggshop

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Game (
    val tittle : String,
    val price : String,
    val image : Int

    ):Parcelable