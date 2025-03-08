package com.example.fetchproject.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fetchproject.R
import com.example.fetchproject.data.model.Item

/**
 * Represent UI - Loaded state of HomeScreen
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenLoaded(itemsMap: Map<Int, List<Item>>, isRefreshing: Boolean, onRefresh: () -> Unit) {
    val scrollState = rememberLazyListState()
    PullToRefreshBox(modifier = Modifier.fillMaxSize(), isRefreshing = isRefreshing, onRefresh = {
        onRefresh()
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            state = scrollState,
            contentPadding = PaddingValues(10.dp)
        ) {
            itemsMap.forEach { (listID, items) ->
                item {
                    Text(text = "${stringResource(id = R.string.label_list_id)} $listID")
                    Spacer(Modifier.height(5.dp))
                }

                items(items.count()) { item ->
                    val item = items[item]
                    ItemView(name = "${item.name}")
                    Spacer(Modifier.height(5.dp))
                }
            }
        }
    }
}


