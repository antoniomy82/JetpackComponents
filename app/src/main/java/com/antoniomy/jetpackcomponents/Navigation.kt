package com.antoniomy.jetpackcomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.antoniomy.jetpackcomponents.model.NavRoutes
import com.antoniomy.jetpackcomponents.model.SuperHero

@Composable
fun Screen1(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(text = "Screen 1", modifier = Modifier.align(Alignment.Center))
        Button(
            onClick = { navController.navigate(NavRoutes.Screen2.id) },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 100.dp)
        ) {
            Text(text = "GoToScreen2")
        }
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Screen 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(NavRoutes.Screen3.id) })

    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(text = "Screen 3", modifier = Modifier.align(Alignment.Center))
        Button(onClick = { navController.navigate("idScreen4/GoToScreen5") },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 100.dp)) {
            Text(text = "GoToScreen4")
        }
    }
}

@Composable
fun Screen4(navController: NavHostController, name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("idScreen5/55555") })
    }
}

@Composable
fun Screen5(navController: NavHostController, number: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = number.toString(),
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(NavRoutes.Screen1.id) })
    }
}
