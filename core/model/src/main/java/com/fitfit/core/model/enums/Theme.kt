package com.fitfit.core.model.enums

import androidx.annotation.StringRes
import com.fitfit.core.model.R

enum class AppTheme(
    @StringRes val textId: Int
) {
    LIGHT(R.string.theme_light),
    DARK(R.string.theme_dark),
    AUTO(R.string.theme_auto);

    // int -> Theme
    companion object {
        fun get(ordinal: Int) = entries[ordinal]
    }
}