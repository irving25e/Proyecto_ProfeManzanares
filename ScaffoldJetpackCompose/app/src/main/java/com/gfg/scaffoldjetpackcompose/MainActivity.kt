package com.gfg.scaffoldjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import com.gfg.scaffoldjetpackcompose.Destinos.*
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.gfg.scaffoldjetpackcompose.Rutas.Pantalladatos
import com.gfg.scaffoldjetpackcompose.Rutas.Pantallaresultados


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color.White) {
                //Scaffold we created
                ScaffoldExample()
            }
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Rutas.Pantalladatos, builder={
                composable(Rutas.Pantalladatos,){
                    Pantalladatos(navController = NavController)
                }
                composable(Rutas.Pantallaresultados,){
                    Pantallaresultados(navController = NavController)
                }
            })
        }
    }
}

private operator fun String.invoke(navController: NavController.Companion) {
    TODO("Not yet implemented")
}

@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navigationItems = listOf(
        Pantalla1,
        Pantalla2,
        Pantalla3
    )
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope, scaffoldState)},
        drawerContent = { Drawer(menu_items = navigationItems)},
        //Pass the body in content parameter
        content = {
            Body(navController = NavController)
        },
    )
}


//A function which will receive a callback to trigger to opening the drawer
@Composable
fun TopBar(
    scope : CoroutineScope,
    scaffoldState: ScaffoldState
) {
    TopAppBar(
        title = { Text(text = "Oferta Productos", fontSize = 30.sp, color = Color.White) },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = "Icono de Menú" )
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body(navController: NavController.Companion) {

    var SalesOrderID by remember{
        mutableStateOf("")
    }

    var SalesOrderDetailID by remember{
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(text = "SalesOrderDetail", fontSize=30.sp, fontWeight = FontWeight.Bold, color = Color(0xFF000000))
        
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = SalesOrderID, onValueChange = {
            SalesOrderID = it
        },label ={
            Text(text = "SalesOrderID")
        })

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = SalesOrderDetailID, onValueChange = {
            SalesOrderDetailID = it
        }, label = {
            Text(text = "SalesOrderDetailID")
        })

        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            if(SalesOrderID.isNotEmpty() && SalesOrderDetailID.isNotEmpty()) {
                navController.navigate(Pantalladatos)
                Log.i("Consulta", "salesorderid: $SalesOrderID salesorderdetailid: $SalesOrderDetailID")
            }
            },
            enabled = SalesOrderID.isNotEmpty() && SalesOrderDetailID.isNotEmpty()
            ) {
            Text(text = "Consulta")
        }
    }
}

private fun NavController.Companion.navigate(pantalladatos: String) {

}


@Composable
fun Drawer(menu_items: List<Destinos>) {
    /*val menu_items = listOf(
        "Product",
        "SalesOrderHeader",
        "SpecialOffer"
    )
    */

    Column {
        Image(
            painterResource(id = R.drawable.bg_drawer ),
            contentDescription = "Menu de opciones",
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(15.dp)
        )
        menu_items.forEach {item->
            DrawerItem(item = item)
        }
    }
}

@Composable
fun DrawerItem(item:Destinos){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(12))
            .padding(8.dp)
    ) {
        Image(painterResource(id = item.icon),
            contentDescription = item.title)
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = item.title,
        style = MaterialTheme.typography.body1
            )
    }
}

@Composable
@Preview
fun MyComposablePreview(){
    ScaffoldExample()
}
