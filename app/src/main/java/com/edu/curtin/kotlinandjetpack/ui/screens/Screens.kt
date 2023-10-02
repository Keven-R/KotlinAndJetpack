package com.edu.curtin.kotlinandjetpack.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.edu.curtin.kotlinandjetpack.Destination
import com.edu.curtin.kotlinandjetpack.ui.components.ContactItem
import com.edu.curtin.kotlinandjetpack.ui.components.EditField
import com.edu.curtin.kotlinandjetpack.ui.components.ExampleButton
import com.edu.curtin.kotlinandjetpack.viewmodel.ExampleEvent
import com.edu.curtin.kotlinandjetpack.viewmodel.ExampleViewmodel

@Composable
fun HomeScreen(navHostController: NavHostController, viewmodel: ExampleViewmodel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EditField(label = "My Favorite Author", content = { viewmodel.randomText }, onValueChange = {viewmodel.randomText = it})
            ExampleButton(label = "Enter") {
                viewmodel.onEvent(ExampleEvent.TempEvent)
                navHostController.navigate(Destination.WorksScreen.route)
            }
        }
    }
}

@Composable
fun WorksScreen(viewmodel: ExampleViewmodel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            itemsIndexed(viewmodel.books){ index, item ->
                ContactItem(pos = index, viewModel = viewmodel, book = item)
            }
        }
    }
}