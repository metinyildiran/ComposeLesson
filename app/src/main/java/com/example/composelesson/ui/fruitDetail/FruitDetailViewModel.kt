package com.example.composelesson.ui.fruitDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.composelesson.Database
import com.example.composelesson.data.model.Fruit
import com.example.composelesson.navigation.fruitIdArg
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FruitDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val fruitId = checkNotNull(savedStateHandle[fruitIdArg]) as String
    var fruit: Fruit? = null

    init {
        fruit = Database.fruits.first { it.id == fruitId }
    }
}