package com.example.composelesson.ui.fruit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composelesson.R
import com.example.composelesson.data.model.Fruit
import com.example.composelesson.navigation.navigateToFruitDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitScreen(navController: NavController, viewModel: FruitViewModel = hiltViewModel()) {
    val fruitListState = viewModel.fruitListState.collectAsState().value
    val snackbarHostState = remember { SnackbarHostState() }

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
        when (fruitListState) {
            is FruitListState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is FruitListState.Empty -> {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                    text = "No Fruit Left :(",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            is FruitListState.Result -> {
                FruitList(it, fruitListState.fruitsList, onClickItem = { fruit ->
                    navController.navigateToFruitDetail(fruit.id)
                }, onRemove = { fruit ->
                    viewModel.removeFruit(fruit)
                })
            }

            is FruitListState.Error -> {
                LaunchedEffect(fruitListState.throwable) {
                    snackbarHostState.showSnackbar("An error occured")
                }
            }
        }
    }
}

@Composable
private fun FruitList(
    it: PaddingValues,
    fruitList: List<Fruit>,
    onClickItem: (fruit: Fruit) -> Unit,
    onRemove: (fruit: Fruit) -> Unit
) {
    LazyColumn(modifier = Modifier.padding(it)) {// RecyclerView
        items(fruitList) { fruit ->// Adapter
            FruitListItem(fruit = fruit, onClickItem = {
                onClickItem.invoke(fruit)
            }) {
                onRemove.invoke(fruit)
            }
        }
    }
}
