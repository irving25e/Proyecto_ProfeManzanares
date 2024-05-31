package com.gfg.scaffoldjetpackcompose

data class SalesOrderDetail(
    val SalesOrderID: String,
    val SalesOrderDetailID: String,
    val CarrierTrackingNumber: String,
    val OrderQty: String,
    val ProductID: String,
    val SpecialOfferID: String,
    val UnitPrice: String,
    val UnitPriceDiscount: String,
    val LineTotal: String,
    val rowguid: String,
    val ModifierdDate: String
)