package com.example.sharedwatchlist.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Modifier.someCustomOutline(
    outlineColor: Color,
    surfaceColor: Color,
    bottomOutlineWidth: Dp,
    otherOutlineWidth: Dp,
    radius: Dp = 1.dp
) = drawBehind {
    val bottomOutlineWidthPx = bottomOutlineWidth.toPx()
    val otherOutlineWidthPx = otherOutlineWidth.toPx()
    val radiusPx = radius.toPx()

    drawRoundRect(
        color = outlineColor,
        topLeft = Offset(0f, 0f),
        size = size,
        cornerRadius = CornerRadius(radiusPx, radiusPx),
        style = Fill
    )

    drawRoundRect(
        color = surfaceColor,
        topLeft = Offset(otherOutlineWidthPx, otherOutlineWidthPx),
        size = Size(
            size.width - otherOutlineWidthPx * 2,
            size.height - bottomOutlineWidthPx - otherOutlineWidthPx
        ),
        cornerRadius = CornerRadius(radiusPx - otherOutlineWidthPx, radiusPx - otherOutlineWidthPx),
        style = Fill
    )
}