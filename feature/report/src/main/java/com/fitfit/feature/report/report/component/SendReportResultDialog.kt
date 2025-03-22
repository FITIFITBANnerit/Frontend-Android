package com.fitfit.feature.report.report.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.fitfit.core.ui.designsystem.components.MyScaffold
import com.fitfit.core.ui.designsystem.components.button.BottomGoBackButton
import com.fitfit.core.ui.designsystem.components.button.BottomGoBackHomeButton
import com.fitfit.core.ui.designsystem.icon.MyIcons
import com.fitfit.feature.report.R

@Composable
fun SendReportResultDialog(
    success: Boolean,
    onClickGoBackHome: () -> Unit,
    onClickGoBack: () -> Unit
){
    MyScaffold(
        modifier = Modifier
            .navigationBarsPadding()
            .displayCutoutPadding()
            .imePadding()
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                //icon with text
                if (success) {
                    IconWithText(
                        icon = MyIcons.check,
                        text = stringResource(R.string.report_was_received_successfully)
                    )
                } else {
                    IconWithText(
                        icon = MyIcons.error,
                        text = stringResource(R.string.error_occurred)
                    )
                }
            }
            //buttons
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                if (success) {
                    BottomGoBackHomeButton(
                        onClick = onClickGoBackHome
                    )
                } else {
                    BottomGoBackButton(
                        onClick = onClickGoBack
                    )
                }
            }
        }
    }
}