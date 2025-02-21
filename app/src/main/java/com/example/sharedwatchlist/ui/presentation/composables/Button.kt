package com.example.sharedwatchlist.ui.presentation.composables

import android.content.res.Resources.Theme
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandCircleDown
import androidx.compose.material.icons.outlined.PostAdd
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sharedwatchlist.util.someCustomOutline
import com.maxkeppeker.sheets.core.models.base.IconSource
import com.maxkeppeker.sheets.core.views.IconComponent

@Composable
fun Button(
    icon: IconSource,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = Modifier
            .padding(start = 25.dp, top = 15.dp, end = 30.dp, bottom = 15.dp)
            .someCustomOutline(
                outlineColor = Color.Black,
                surfaceColor = MaterialTheme.colorScheme.surface,
                bottomOutlineWidth = 3.dp,
                otherOutlineWidth = 1.dp,
                radius = 10.dp
            )
            .then(modifier),
          shape = RoundedCornerShape(10.dp),
        colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Gray
        ),
        enabled = enabled
    ) {
        IconComponent(modifier = Modifier.requiredSize(AssistChipDefaults.IconSize), iconSource = icon)
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text)
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ButtonPreview() {
    Button(
        icon = IconSource(Icons.Outlined.PostAdd),
        text = "new watchlist",
        onClick = { },
    )
}