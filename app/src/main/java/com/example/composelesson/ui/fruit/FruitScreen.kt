package com.example.composelesson.ui.fruit

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.composelesson.R
import com.example.composelesson.data.model.Fruit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitScreen(viewModel: FruitViewModel = hiltViewModel()) {
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
                FruitListItem(fruit = fruit) {
                    viewModel.removeFruit(fruit)
                }
            }
        }
    }
}

@Composable
fun FruitListItem(fruit: Fruit, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(2.dp, Color.Gray, RoundedCornerShape(10.dp))
            .padding(8.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = rememberAsyncImagePainter(
                model = fruit.imageUrl
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = fruit.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}