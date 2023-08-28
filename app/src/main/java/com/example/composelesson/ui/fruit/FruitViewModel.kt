package com.example.composelesson.ui.fruit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composelesson.Database
import com.example.composelesson.data.model.Fruit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FruitViewModel @Inject constructor() : ViewModel() {
    private val _fruitListState: MutableStateFlow<FruitListState> =
        MutableStateFlow(FruitListState.Loading)
    val fruitListState: StateFlow<FruitListState> = _fruitListState

    init {
        getFruits()
    }

    private fun getFruits() {
        viewModelScope.launch {
            delay(1000)

            _fruitListState.emit(FruitListState.Result(Database.fruits))
        }
    }

    fun removeFruit(fruit: Fruit) {
        viewModelScope.launch {
            Database.fruits.remove(fruit)

            if ((_fruitListState.value as FruitListState.Result).fruitsList.isEmpty()) {
                _fruitListState.emit(FruitListState.Empty)
            }
        }
    }

    fun addFruit() {
        viewModelScope.launch {
            Database.fruits.add(
                Fruit(
                    "Elma",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/330px-Red_Apple.jpg"
                )
            )

            _fruitListState.emit(FruitListState.Result(Database.fruits))
        }
    }
}