package com.katrinrudisch.gymbuddy.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.katrinrudisch.gymbuddy.models.NetworkState

@Composable
fun <T> StatefulLayout(
    state: NetworkState<T>,
    content: @Composable (ColumnScope.(v: T) -> Unit)
) {
    when (state) {
        is NetworkState.Empty -> StateLayout("Empty", Icons.Rounded.Menu)
        is NetworkState.Loading -> StateLayout("Loading", Icons.Rounded.Menu)
        is NetworkState.Error -> StateLayout("Error", Icons.Rounded.Menu)
        is NetworkState.Success -> Column { content(state.data) }
    }
}

@Composable
fun StateLayout(text: String, icon: ImageVector) {
    Column {
        Icon(
            imageVector = icon,
            contentDescription = "Localized description",
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Text(
            text = text,
            style = TextStyle(
                fontSize = 18.sp
            )
        )
    }
}