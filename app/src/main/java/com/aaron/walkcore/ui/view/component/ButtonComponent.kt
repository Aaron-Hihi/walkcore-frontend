package com.aaron.walkcore.ui.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.walkcore.ui.theme.Blue
import com.aaron.walkcore.ui.theme.Green
import com.aaron.walkcore.ui.theme.WalkcoreTheme
import com.aaron.walkcore.ui.theme.White

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: String,
    brush: Brush
) {
    /* ==============================
    ========== UI LAYOUT ==========
    ============================== */
    // --- Layout ---
    // Button and background
    Button (
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = White
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),

        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(10.dp)
    ) {

        // Color of button
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = brush),
            contentAlignment = Alignment.Center
        ) {

            // Label Text
            Text(
                text = label,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = White,
            )
        }
    }
}

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: String,
    color: Color
) {
    ButtonComponent(modifier, onClick, label, SolidColor(color))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonPreview() {
    WalkcoreTheme {
        ButtonComponent(
            onClick = {},
            label = "Join Now",
            brush = Brush.linearGradient(
                colors = listOf(
                    Blue,
                    Green
                )
            )
        )
    }
}