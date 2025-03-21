package com.fitfit.core.ui.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fitfit.core.ui.designsystem.R

//Type.kt

val pretendard = FontFamily(
//    Font(R.font.pretendard_thin, FontWeight.Thin),
//    Font(R.font.pretendard_extra_light, FontWeight.ExtraLight),
//    Font(R.font.pretendard_light, FontWeight.Light),
    Font(R.font.pretendard_regular, FontWeight.Normal),
//    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semi_bold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
//    Font(R.font.pretendard_extra_bold, FontWeight.ExtraBold),
//    Font(R.font.pretendard_black, FontWeight.Black),
)



val Typography = Typography(
    //display --------------------------------------------------------------
    displayLarge = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 23.sp * 1.4
    ),
    displayMedium = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 21.sp * 1.4
    ),
    displaySmall = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 19.sp * 1.4
    ),

    //headline / bold --------------------------------------------------------
    headlineLarge = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 23.sp,
        lineHeight = 23.sp * 1.4
    ),
    headlineMedium = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        lineHeight = 21.sp * 1.4
    ),
    headlineSmall = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 19.sp,
        lineHeight = 19.sp * 1.4
    ),

    //title / bold / app bar title  --------------------------------------------
    titleLarge = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 23.sp,
        lineHeight = 23.sp * 1.4
    ),
    titleMedium = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        lineHeight = 21.sp * 1.4
    ),
    titleSmall = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 19.sp,
        lineHeight = 19.sp * 1.4
    ),

    //body / not bold  --------------------------------------------------------
    bodyLarge = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 17.sp * 1.4
    ),
    bodyMedium = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 15.sp * 1.4
    ),
    bodySmall = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 13.sp * 1.4
    ),

    //label / not bold / button, icon text ---------------------------------
    labelLarge = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 15.sp * 1.4
    ),
    labelMedium = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp * 1.4
    ),
    labelSmall = TextStyle(
        fontFamily = pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 12.sp * 1.4
    )
)