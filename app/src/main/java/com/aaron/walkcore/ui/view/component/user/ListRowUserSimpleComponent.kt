package com.aaron.walkcore.ui.view.component.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aaron.walkcore.data.dummy.UserDummy
import com.aaron.walkcore.model.user.UserSimpleModel
import com.aaron.walkcore.ui.theme.DarkGrey
import com.aaron.walkcore.ui.theme.LightGrey
import com.aaron.walkcore.ui.theme.WalkcoreTheme

@Composable
fun ListRowUserSimpleComponent(
    modifier: Modifier = Modifier,
    userSimpleModels: List<UserSimpleModel>,
    showSteps: Boolean = true,
    maxUserShown: Int
) {
    /* ==============================
    ========== UI LAYOUT ==========
    ============================== */
    // --- Vars ---
    val displayedUsers = userSimpleModels.take(maxUserShown)
    val remainingUsersCount = userSimpleModels.size - displayedUsers.size

    // --- Layout ---
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        // Show all users in displayed users
        displayedUsers.forEach { user ->
            RowUserSimpleComponent(
                userSimpleModel = user,
                showSteps = showSteps
            )
        }

        // And x others
        if (remainingUsersCount > 0) {
            Text(
                text = if (remainingUsersCount == 1) "and 1 other..." else "and $remainingUsersCount others...",
                style = MaterialTheme.typography.bodyMedium,
                color = DarkGrey,
                modifier = Modifier.padding(start = 66.dp)
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListRowUserSimplePreview() {
    WalkcoreTheme {
        ListRowUserSimpleComponent(
            userSimpleModels = UserDummy.AllSimpleUsers,
            showSteps = true,
            maxUserShown = 3
        )
    }
}