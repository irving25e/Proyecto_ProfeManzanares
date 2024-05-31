package com.gfg.scaffoldjetpackcompose

sealed class Destinos (
    val icon: Int,
    val title: String,
    val ruta: String
){
    object Pantalla1: Destinos(R.drawable.ic_product, title = "Product", ruta = "Pantalla1")
    object Pantalla2: Destinos(R.drawable.ic_specialoffer, title = "SpecialOffer", ruta = "Pantalla2")
    object Pantalla3: Destinos(R.drawable.ic_salesorderheader, title = "SalesOrderHeader", ruta = "Pantalla3")

}