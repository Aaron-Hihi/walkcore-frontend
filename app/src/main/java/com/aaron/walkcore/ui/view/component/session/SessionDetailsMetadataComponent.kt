package com.aaron.walkcore.ui.view.component.session

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.walkcore.ui.theme.LightGrey
import com.aaron.walkcore.ui.theme.WalkcoreTheme

@Composable
fun SessionDetailsMetadataComponent(
    modifier: Modifier = Modifier,
    key: String,
    value: String
) {

    /* ==============================
    ========== UI LAYOUT ==========
    ============================== */
    // --- Layout ---
    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        // Text for key value metadata
        Text(
            text = "$key: $value",
            style = MaterialTheme.typography.bodySmall
        )

        // Horizontal line
        HorizontalDivider(
            modifier = Modifier.padding(top = 4.dp),
            thickness = 1.dp,
            color = LightGrey
        )
    }

}


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun SessionDetailsMetadataPreview() {
    WalkcoreTheme {
        SessionDetailsMetadataComponent(
            key = "Mode",
            value = "Solo",
        )
    }
}