package com.example.fetchproject.ui.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.fetchproject.R

/**
 * Represent UI - Error
 */
@Composable
fun ErrorView(modifier: Modifier) {
    Text(modifier = Modifier.then(modifier), text = stringResource(id = R.string.message_error))
}