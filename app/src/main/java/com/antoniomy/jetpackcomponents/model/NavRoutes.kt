package com.antoniomy.jetpackcomponents.model

sealed class NavRoutes(val id:String){
    object Screen1: NavRoutes("idScreen1")
    object Screen2: NavRoutes("idScreen2")
    object Screen3: NavRoutes("idScreen3")
    object Screen4: NavRoutes("idScreen4")
}