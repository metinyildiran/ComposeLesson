package com.example.composelesson.ui.fruit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composelesson.R
import com.example.composelesson.navigation.navigateToFruitDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitScreen(navController: NavController, viewModel: FruitViewModel = hiltViewModel()) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            viewModel.addFruit()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = null
            )
        }
    }) {
        LazyColumn(modifier = Modifier.padding(it)) {// RecyclerView
            if (viewModel.fruits.isEmpty()) {
                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                        text = "No Fruit Left :(",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            items(viewModel.fruits) { fruit ->// Adapter
                FruitListItem(fruit = fruit, onClickItem = {
                    navController.navigateToFruitDetail(fruit.id)
                }) {
                    viewModel.removeFruit(fruit)
                }
            }
        }
    }
}
