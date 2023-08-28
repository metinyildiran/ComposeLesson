package com.example.composelesson.ui.fruit

import com.example.composelesson.data.model.Fruit

sealed interface FruitListState {
    object Loading : FruitListState
    object Empty : FruitListState
    class Result(val fruitsList: List<Fruit>) : FruitListState
    class Error(val throwable: Throwable?) : FruitListState
}
