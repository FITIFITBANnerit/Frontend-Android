package com.fitfit.core.ui.designsystem.components.button

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.fitfit.core.ui.designsystem.R
import com.fitfit.core.ui.designsystem.theme.BannerItTheme

@Composable
fun AnimatedBottomSaveCancelButtons(
    visible: Boolean,
    onClickCancel: () -> Unit,
    onClickSave: () -> Unit,
    modifier: Modifier = Modifier,
    saveEnabled: Boolean = true,
    use2PanesAndSpotScreen: Boolean = false
){
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            animationSpec = tween(400),
            initialOffsetY = { (it * 2).toInt() }),
        exit = slideOutVertically(
            animationSpec = tween(800),
            targetOffsetY = { (it * 2).toInt() })
    ) {

        Row {
            if (use2PanesAndSpotScreen)
                Spacer(modifier = Modifier.weight(1f))

            Column(modifier = Modifier.weight(1f)) {
                //gradation
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(34.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(Color.Transparent, MaterialTheme.colorScheme.background)
                            )
                        )
                )


                //no gradation
                NegativePositiveButtons(
                    negativeButtonText = stringResource(id = R.string.cancel),
                    positiveButtonText = stringResource(id = R.string.save),
                    onClickCancel = onClickCancel,
                    onClickPositive = onClickSave,
                    modifier = modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(10.dp, 2.dp, 10.dp, 10.dp),
                    positiveEnabled = saveEnabled,
                )
            }
        }
    }
}

@Composable
fun NegativePositiveButtons(
    positiveButtonText: String,
    onClickCancel: () -> Unit,
    onClickPositive: () -> Unit,
    modifier: Modifier = Modifier,
    negativeButtonText: String = stringResource(id = R.string.cancel),
    positiveEnabled: Boolean = true
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.widthIn(max = 330.dp)
        ) {
            BigNegativeButton(
                text = negativeButtonText,
                onClick = onClickCancel,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            BigPositiveButton(
                text = positiveButtonText,
                onClick = onClickPositive,
                enabled = positiveEnabled,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun BigNegativeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
){
    Button(
        modifier = modifier.height(48.dp), //max width: 150.dp
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surfaceTint,
            contentColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceDim,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        shape = MaterialTheme.shapes.medium,
        enabled = enabled,
        onClick = onClick
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun BigPositiveButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
){
    Button(
        modifier = modifier.height(48.dp), //max width: 150.dp
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = MaterialTheme.colorScheme.surfaceDim,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        enabled = enabled,
        onClick = onClick
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold
        )
    }
}





















@Composable
@PreviewLightDark
private fun SaveCancelButtonPreview(){
    BannerItTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ){
            NegativePositiveButtons(
                negativeButtonText = "Cancel",
                positiveButtonText = "Save",
                onClickCancel = {},
                onClickPositive = {}
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun SaveCancelButtonPreview1(){
    BannerItTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ){
            NegativePositiveButtons(
                negativeButtonText = "Cancel",
                positiveButtonText = "Save",
                onClickCancel = {},
                onClickPositive = {},
                positiveEnabled = false
            )
        }
    }
}