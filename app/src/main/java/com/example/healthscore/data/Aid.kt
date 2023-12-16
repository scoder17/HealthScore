package com.example.healthscore.data

import androidx.annotation.StringRes
import com.example.healthscore.R

data class Aid (
    @StringRes val heading:Int,
    @StringRes val body:Int
)
val aids = listOf(
    Aid(R.string.h1,R.string.b1),
    Aid(R.string.h2,R.string.b2),
    Aid(R.string.h3,R.string.b3),
    Aid(R.string.h4,R.string.b4),
    Aid(R.string.h5,R.string.b5),
    Aid(R.string.h6,R.string.b6),
    Aid(R.string.h7,R.string.b7)
)