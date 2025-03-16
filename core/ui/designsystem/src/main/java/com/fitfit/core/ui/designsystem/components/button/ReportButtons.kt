package com.fitfit.core.ui.designsystem.components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fitfit.core.ui.designsystem.R

@Composable
fun ReportBannerButton(
    onClick: () -> Unit
){
    MyTextButton(
        text = stringResource(R.string.report_banner),
        onClick = onClick,
        textStyle = MaterialTheme.typography.titleMedium,
        modifier = Modifier.width(220.dp).height(60.dp),
        containerColor = MaterialTheme.colorScheme.primaryContainer
    )
}

@Composable
fun SignInButton(
    onClick: () -> Unit
){
    MyTextButton(
        text = stringResource(R.string.sign_in),
        onClick = onClick,
        textStyle = MaterialTheme.typography.titleMedium,
        modifier = Modifier.width(180.dp).height(60.dp),
        containerColor = MaterialTheme.colorScheme.primaryContainer
    )
}