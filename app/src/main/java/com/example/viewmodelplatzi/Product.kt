package com.example.viewmodelplatzi

data class Product (
    val ID: String,
    val title: String,
    val price: Double,
    val description: String,
    val category:Categorie,



    )
data class Categorie(
    val id: String,
    val name: String,
    val image: String
)


