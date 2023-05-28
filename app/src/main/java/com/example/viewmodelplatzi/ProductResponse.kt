package com.example.viewmodelplatzi

data class ProductResponse (
    val id: String,
    val title: String,
    val price: Double,
    val description: String,
    val creationAt: String,
    val updatedAt: String,
    val category:Category,



    )
data class Category(
    val id: String,
    val name: String,
    val image: String,
    val creationAt: String,
    val updatedAt: String,
)






