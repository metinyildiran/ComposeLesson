package com.example.composelesson.data.model

import java.util.UUID

data class Fruit(val name: String, val imageUrl: String, val id: String = UUID.randomUUID().toString())
