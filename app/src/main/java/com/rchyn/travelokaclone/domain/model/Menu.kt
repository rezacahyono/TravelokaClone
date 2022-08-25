package com.rchyn.travelokaclone.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Menu(
    @StringRes
    val title: Int = 0,
    @DrawableRes
    val icon: Int = 0
)
