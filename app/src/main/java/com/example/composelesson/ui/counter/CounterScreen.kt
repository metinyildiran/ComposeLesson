package com.example.composelesson.ui.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CounterScreen(viewModel: CounterViewModel = hiltViewModel()) {
//    val counter = rememberSaveable { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Clicked ${viewModel.counter.value} times")

        Button(onClick = {
            viewModel.counter.value += 1  // Side-effect
        }) {
            Text(text = "Click")
        }
    }
}