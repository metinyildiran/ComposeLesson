package com.example.composelesson.ui.fruit

import androidx.lifecycle.ViewModel
import com.example.composelesson.Database
import com.example.composelesson.data.model.Fruit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FruitViewModel @Inject constructor() : ViewModel() {
    val fruits = Database.fruits

    fun removeFruit(fruit: Fruit) {
        fruits.remove(fruit)
    }

    fun addFruit() {
        fruits.add(Fruit("Elma", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/330px-Red_Apple.jpg"))
    }
}