package com.gfg.scaffoldjetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pantallaresultados(navController: NavController){
    
    var carriertrackingnumber by remember {
        mutableStateOf("")
    }

    var orderqty by remember {
        mutableStateOf("")
    }

    var productid by remember {
        mutableStateOf("")
    }

    var specialofferid by remember {
        mutableStateOf("")
    }

    var unitprice by remember {
        mutableStateOf("")
    }

    var unitpricediscount by remember {
        mutableStateOf("")
    }

    var linetotal by remember {
        mutableStateOf("")
    }
    
    Text(text = "CarrierTrackingNumber", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    Spacer(modifier = Modifier.height(15.dp))

    OutlinedTextField(value = carriertrackingnumber, onValueChange = {
        carriertrackingnumber = it
    }, label = {
        Text(text = "carriertrackingnumber")
    })

    Spacer(modifier = Modifier.height(15.dp))

    Text(text = "orderqty", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    OutlinedTextField(value = orderqty, onValueChange = {
        orderqty = it
    }, label = {
        Text(text = "orderqty")
    })

    Spacer(modifier = Modifier.height(15.dp))

    Text(text = "ProductID", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    OutlinedTextField(value = productid, onValueChange = {
        productid = it
    }, label = {
        Text(text = "productid")
    })

    Spacer(modifier = Modifier.height(15.dp))

    Text(text = "specialofferid", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    OutlinedTextField(value = specialofferid, onValueChange = {
        specialofferid = it
    }, label = {
        Text(text = "specialofferid")
    })

    Spacer(modifier = Modifier.height(15.dp))

    Text(text = "unitprice", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    OutlinedTextField(value = unitprice, onValueChange = {
        unitprice = it
    }, label = {
        Text(text = "unitprice")
    })

    Spacer(modifier = Modifier.height(15.dp))

    Text(text = "unitpricediscount", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    OutlinedTextField(value = unitpricediscount, onValueChange = {
        unitpricediscount = it
    }, label = {
        Text(text = "unitpricediscount")
    })

    Spacer(modifier = Modifier.height(15.dp))

    Text(text = "linetotal", fontSize = 30.sp, fontWeight = FontWeight.Bold)

    OutlinedTextField(value = linetotal, onValueChange = {
        linetotal = it
    }, label = {
        Text(text = "linetotal")
    })

    Button(onClick = {
        if(carriertrackingnumber.isNotEmpty() && orderqty.isNotEmpty() && productid.isNotEmpty() && specialofferid.isNotEmpty() && unitprice.isNotEmpty() && unitpricediscount.isNotEmpty() && linetotal.isNotEmpty()) {
            navController.navigate(Rutas.Pantallaresultados)
            Log.i("Regresar", "carriertrackingnumber: $carriertrackingnumber orderqty: $orderqty productid: $productid specialofferid: $specialofferid unitprice: $unitprice unitpricediscount: $unitpricediscount linetotal: $linetotal")
        }
    },
        enabled = carriertrackingnumber.isNotEmpty() && orderqty.isNotEmpty() && productid.isNotEmpty() && specialofferid.isNotEmpty() && unitprice.isNotEmpty() && unitpricediscount.isNotEmpty() && linetotal.isNotEmpty()
    ) {
        Text(text = "Regresar")
    }
}

