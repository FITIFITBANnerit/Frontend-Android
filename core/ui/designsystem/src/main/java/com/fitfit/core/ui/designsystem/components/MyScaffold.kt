package com.fitfit.core.ui.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyScaffold(
    modifier: Modifier = Modifier,

    bottomSaveCancelBarVisible: Boolean = false,
    onClickCancel: () -> Unit = {},
    onClickSave: () -> Unit = {},
    saveEnabled: Boolean = true,

    use2PanesAndSpotScreen: Boolean = false,
    useBottomNavBar: Boolean = false,

    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: androidx.compose.material3.FabPosition = androidx.compose.material3.FabPosition.End,
    containerColor: Color = androidx.compose.material3.MaterialTheme.colorScheme.surface,
    contentColor: Color = androidx.compose.material3.contentColorFor(containerColor),
    contentWindowInsets: WindowInsets = WindowInsets(bottom = 0),
    content: @Composable (PaddingValues) -> Unit
) {

    val buttonsModifier = if (useBottomNavBar) Modifier
                            .navigationBarsPadding()    //system nav bar padding
                            .padding(bottom = 80.dp)    //app bottom nav bar padding
                        else Modifier.navigationBarsPadding().imePadding()

    Scaffold(
        modifier, topBar, bottomBar, snackbarHost, floatingActionButton,
        floatingActionButtonPosition, containerColor, contentColor, contentWindowInsets,

    ) { paddingValues ->
        Box(contentAlignment = Alignment.BottomCenter) {

            content(paddingValues)

            //bottom save cancel bar
//            AnimatedBottomSaveCancelButtons(
//                visible = bottomSaveCancelBarVisible,
//                onClickCancel = onClickCancel,
//                onClickSave = onClickSave,
//                saveEnabled = saveEnabled,
//                use2PanesAndSpotScreen = use2PanesAndSpotScreen,
//                modifier = buttonsModifier
//            )
        }
    }
}