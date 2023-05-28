package com.example.viewmodelplatzi

fun ProductResponse.mapToProduct()=Product(
    id,title,price,description,Categorie(id,category.name,category.image)
)

