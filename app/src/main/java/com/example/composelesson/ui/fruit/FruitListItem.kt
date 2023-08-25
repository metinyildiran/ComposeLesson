package com.example.composelesson.ui.fruit

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composelesson.R
import com.example.composelesson.data.model.Fruit

@Composable
fun FruitListItem(fruit: Fruit, onClickItem:() -> Unit, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(2.dp, Color.Gray, RoundedCornerShape(10.dp))
            .padding(8.dp).clickable {
                  onClickItem()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                modifier = Modifier.size(100.dp), painter = rememberAsyncImagePainter(
                    model = fruit.imageUrl
                ), contentDescription = null, contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier.padding(8.dp),
                text = fruit.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Image(
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    onClick()
                },
            painter = painterResource(id = R.drawable.baseline_delete_24),
            contentDescription = null
        )
    }
}