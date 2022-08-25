package com.rchyn.travelokaclone.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Hotel(
    @DrawableRes
    val image: Int,
    @StringRes
    val urbanVillage: Int,
    @StringRes
    val title: Int,
    @StringRes
    val sale: Int,
    @StringRes
    val priceOriginal: Int,
    @StringRes
    val priceResult: Int,
    val cities: Cities
)
