package com.fitfit.core.ui.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.fitfit.core.ui.designsystem.icon.DisplayIcon
import com.fitfit.core.ui.designsystem.icon.MyIcon
import com.fitfit.core.ui.designsystem.icon.NavigationBarIcon
import com.fitfit.core.ui.designsystem.theme.BannerItTheme

val NAVIGATION_BOTTOM_BAR_WIDTH = 0.dp
val NAVIGATION_RAIL_BAR_WIDTH = 80.dp
val NAVIGATION_DRAWER_BAR_WIDTH = 180.dp

//compact
@Composable
fun MyNavigationBottomBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceDim,
        content = content
    )
}

@Composable
fun RowScope.MyNavigationBottomBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    selectedIcon: MyIcon,
    unSelectedIcon: MyIcon,
    labelText: String
){
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            if (selected)   DisplayIcon(icon = selectedIcon)
            else            DisplayIcon(icon = unSelectedIcon)
        },
        label = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
            )
        },
        colors = NavigationBarItemColors(
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
            unselectedIconColor = MaterialTheme.colorScheme.inverseSurface,
            unselectedTextColor = MaterialTheme.colorScheme.inverseSurface,
            disabledIconColor = Color.Unspecified,
            disabledTextColor = Color.Unspecified
        )
    )
}


//medium
@Composable
fun MyNavigationRailBar(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
){
    NavigationRail(
//        modifier = modifier.width(NAVIGATION_RAIL_BAR_WIDTH),
        header = {
            //FAB
        },
        containerColor = MaterialTheme.colorScheme.surfaceDim
    ) {
        Column(
            modifier = modifier.width(NAVIGATION_RAIL_BAR_WIDTH)
        ) {
            Spacer(modifier = Modifier.weight(1f))

            content()

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun MyNavigationRailBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    selectedIcon: MyIcon,
    unSelectedIcon: MyIcon,
    labelText: String
){
    NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = {
            if (selected)   DisplayIcon(icon = selectedIcon)
            else            DisplayIcon(icon = unSelectedIcon)
        },
        label = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
            )
        },
        colors = NavigationRailItemColors(
            selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedIndicatorColor = MaterialTheme.colorScheme.primaryContainer,
            unselectedIconColor = MaterialTheme.colorScheme.inverseSurface,
            unselectedTextColor = MaterialTheme.colorScheme.inverseSurface,
            disabledIconColor = Color.Unspecified,
            disabledTextColor = Color.Unspecified
        )
    )
}

//expanded
@Composable
fun MyNavigationDrawer(
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = NavigationRailDefaults.windowInsets,
    content: @Composable ColumnScope.() -> Unit,
){
    Box(
        modifier = modifier
            .width(NAVIGATION_DRAWER_BAR_WIDTH)
            .background(MaterialTheme.colorScheme.surfaceDim)
    ) {
        PermanentNavigationDrawer(
            drawerContent = {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 10.dp)
                        .windowInsetsPadding(windowInsets)
                ) {
                    content()
                }
            }
        ) {

        }
    }
}

@Composable
fun MyNavigationDrawerItem(
    selected: Boolean,
    onClick: () -> Unit,
    selectedIcon: MyIcon,
    unSelectedIcon: MyIcon,
    labelText: String
){
    NavigationDrawerItem(
        selected = selected,
        onClick = onClick,
        icon = {
            if (selected)   DisplayIcon(icon = selectedIcon)
            else            DisplayIcon(icon = unSelectedIcon)
        },
        label = {
            Text(
                text = labelText,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
            )
        },
        colors = NavigationDrawerItemDefaults.colors(
            unselectedContainerColor = Color.Transparent,
            unselectedIconColor = MaterialTheme.colorScheme.inverseSurface,
            unselectedTextColor = MaterialTheme.colorScheme.inverseSurface,
        ),
    )
}




























@Composable
@PreviewLightDark
private fun NavigationBottomBarPreview(){
    val labelTexts = listOf("Trips", "Profile", "More")
    val selectedIcons = listOf(
        NavigationBarIcon.reportFilled,
        NavigationBarIcon.logsFilled,
        NavigationBarIcon.moreFilled
    )
    val unSelectedIcons = listOf(
        NavigationBarIcon.reportOutlined,
        NavigationBarIcon.logsOutlined,
        NavigationBarIcon.moreOutlined
    )

    BannerItTheme {
        MyNavigationBottomBar {
            labelTexts.forEachIndexed { index, labelText ->
                MyNavigationBottomBarItem(
                    selected = index == 0,
                    onClick = { },
                    selectedIcon = selectedIcons[index],
                    unSelectedIcon = unSelectedIcons[index],
                    labelText = labelText
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
private fun NavigationRailBarPreview(){
    val labelTexts = listOf("Trips", "Profile", "More")
    val selectedIcons = listOf(
        NavigationBarIcon.reportFilled,
        NavigationBarIcon.logsFilled,
        NavigationBarIcon.moreFilled
    )
    val unSelectedIcons = listOf(
        NavigationBarIcon.reportOutlined,
        NavigationBarIcon.logsOutlined,
        NavigationBarIcon.moreOutlined
    )

    BannerItTheme {
        MyNavigationRailBar {
            labelTexts.forEachIndexed { index, labelText ->
                MyNavigationRailBarItem(
                    selected = index == 0,
                    onClick = { },
                    selectedIcon = selectedIcons[index],
                    unSelectedIcon = unSelectedIcons[index],
                    labelText = labelText
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
private fun NavigationDrawerPreview(){
    val labelTexts = listOf("Trips", "Profile", "More")
    val selectedIcons = listOf(
        NavigationBarIcon.reportFilled,
        NavigationBarIcon.logsFilled,
        NavigationBarIcon.moreFilled
    )
    val unSelectedIcons = listOf(
        NavigationBarIcon.reportOutlined,
        NavigationBarIcon.logsOutlined,
        NavigationBarIcon.moreOutlined
    )

    BannerItTheme {
        MyNavigationDrawer {
            labelTexts.forEachIndexed { index, labelText ->
                MyNavigationDrawerItem(
                    selected = index == 0,
                    onClick = { },
                    selectedIcon = selectedIcons[index],
                    unSelectedIcon = unSelectedIcons[index],
                    labelText = labelText
                )
            }
        }
    }
}