package com.katrinrudisch.gymbuddy.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.katrinrudisch.gymbuddy.compose.GymBuddyTheme

@Composable
fun Cell(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier
            .padding(GymBuddyTheme.dimens.paddingDefault)
            .fillMaxWidth()
    ) {
        Text(text = title)
        Text(text = subtitle)
    }
}

@Composable
@Preview(device = Devices.PIXEL_4)
fun CellPreview(){
    GymBuddyTheme {
        Column {
            Cell("title", "subtitle")
        }
    }
}
