package com.rchyn.travelokaclone.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Promo(
    @DrawableRes
    val image: Int,
    @StringRes
    val title: Int,
    @StringRes
    val period: Int
)
