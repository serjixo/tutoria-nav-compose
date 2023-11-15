package com.example.navtutoria

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navtutoria.ui.theme.NavTutoriaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavTutoriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaNavegacion()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaNavegacion() {
    val navController = rememberNavController()
    var tamanoFuente by remember { mutableStateOf(12) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Países Latinoamericanos")
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { tamanoFuente++ }) {
                        Icon(Icons.Default.Add, contentDescription = null)
                    }
                    IconButton(onClick = { tamanoFuente = 12 }) {
                        Icon(Icons.Filled.Home, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar() {
                var argentina by remember { mutableStateOf(true) }
                var colombia by remember { mutableStateOf(false) }
                var brasil by remember { mutableStateOf(false) }
                NavigationBarItem(
                    selected = argentina,
                    onClick = {
                        argentina = true;
                        colombia = false;
                        brasil = false;
                        navController.navigate("pantallaargentina")
                    },
                    icon = { Icon(Icons.Default.Info, contentDescription = null) },
                    label = {
                        Text(text = "Argentina")
                    }
                )
                NavigationBarItem(
                    selected = brasil,
                    onClick = {
                        brasil = true;
                        argentina = false;
                        colombia = false;
                        navController.navigate("pantallabrasil")
                    },
                    icon = { Icon(Icons.Default.Info, contentDescription = null) },
                    label = {
                        Text(text = "Brasil")
                    }
                )
                NavigationBarItem(
                    selected = colombia,
                    onClick = {
                        colombia = true;
                        argentina = false;
                        brasil = false;
                        navController.navigate("pantallacolombia")
                    },
                    icon = { Icon(Icons.Default.Info, contentDescription = null) },
                    label = {
                        Text(text = "Colombia")
                    }
                )
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = "pantallaargentina"
        ) {

            composable("pantallaargentina") {
                PantallaArgentina(tamanoFuente)
            }
            composable("pantallabrasil") {
                PantallaBrasil(tamanoFuente)
            }
            composable("pantallacolombia") {
                PantallaColombia(tamanoFuente)
            }
        }
    }

}

@Composable
fun PantallaArgentina(tamanoFuente: Int) {
    val scroll = rememberScrollState(0)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontSize = tamanoFuente.sp,
            text = "Argentina, oficialmente República Argentina",
            modifier = Modifier
                .verticalScroll(scroll)
        )
    }
}

@Composable
fun PantallaBrasil(tamanoFuente: Int) {
    val scroll = rememberScrollState(0)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontSize = tamanoFuente.sp,
            text = "Brasil, oficialmente República Federativa de Brasil",
            modifier = Modifier.verticalScroll(scroll)
        )
    }

}

@Composable
fun PantallaColombia(tamanoFuente: Int) {
    val scroll = rememberScrollState(0)
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontSize = tamanoFuente.sp,
            text = "Colombia, oficialmente República de Colombia",
            modifier = Modifier.verticalScroll(scroll)
        )
    }
}