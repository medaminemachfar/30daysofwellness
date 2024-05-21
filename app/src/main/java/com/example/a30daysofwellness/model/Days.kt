package com.example.a30daysofwellness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysofwellness.R

data class Day(
    @StringRes val daynumber: Int,
    @StringRes val title: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int,
    )
object Days {
    val dayss = listOf(
        Day(
            daynumber = R.string.d1,
            title = R.string.description1,
            imageRes = R.drawable._1390069837_f59dd29867_o,
            descriptionRes = R.string.descriptionlong1
        ),
        Day(
            daynumber = R.string.d2,
            title = R.string.description2,
            imageRes = R.drawable._1677860567_e9a6b59df5_o,
            descriptionRes = R.string.descriptionlong2
        ),
        Day(
            daynumber = R.string.d3,
            title = R.string.description3,
            imageRes = R.drawable._5692370885_768e148e93_o,
            descriptionRes = R.string.descriptionlong3
        ))

}