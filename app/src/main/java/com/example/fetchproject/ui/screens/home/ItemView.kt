package com.example.fetchproject.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fetchproject.R
import com.example.fetchproject.data.model.Item

/**
 * Represent UI - Item
 */
@Composable
fun ItemView(name: String) {
    Card(shape = RoundedCornerShape(5.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(5.dp)
        ) {
            // Name
            Text(text = "${stringResource(id = R.string.label_name)} $name")
        }
    }
}

@Preview
@Composable
fun ItemViewPreview() {
    val item = Item(id = 0, listID = 1, name = "Item 100")
    ItemView(name = item.name ?: "")
}