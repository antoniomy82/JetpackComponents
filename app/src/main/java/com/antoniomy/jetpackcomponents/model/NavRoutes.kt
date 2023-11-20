package com.antoniomy.jetpackcomponents.model

sealed class NavRoutes(val id:String){
    object Screen1: NavRoutes("idScreen1")
    object Screen2: NavRoutes("idScreen2")
    object Screen3: NavRoutes("idScreen3")
    object Screen4: NavRoutes("idScreen4/{name}")
    object Screen5: NavRoutes("idScreen5/{number}")

    object Screen6: NavRoutes("idScreen6?name={name}"){
        fun createRoute(name:String) = "idScreen6?name=$name"
    }
}