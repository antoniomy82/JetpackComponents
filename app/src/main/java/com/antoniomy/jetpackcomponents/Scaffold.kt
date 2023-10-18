package com.antoniomy.jetpackcomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldFabDocked() {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    //Top bar + Snack Bar + Floating Action Button
    Scaffold(
        topBar = { MyTopAppBar { coroutineScope.launch { snackBarHostState.showSnackbar(message = "You have pressed $it") } } },
        snackbarHost = { SnackbarHost(snackBarHostState) },
        bottomBar = { MyBottomNavigation() },
        contentColor = Color.White,
        floatingActionButton = { MyFloatingActionButtonDocked() },
        floatingActionButtonPosition = FabPosition.Center,

        ) { paddingValues ->
        Modifier.padding(paddingValues)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    //Top bar + Snack Bar + Floating Action Button
    Scaffold(
        topBar = { MyTopAppBar { coroutineScope.launch { snackBarHostState.showSnackbar(message = "You have pressed $it") } } },
        snackbarHost = { SnackbarHost(snackBarHostState) },
        bottomBar = { MyBottomNavigation() },
        contentColor = Color.White,
        floatingActionButton = { MyFloatingActionButton() },
        floatingActionButtonPosition = FabPosition.Center,
        ) { paddingValues ->
        Modifier.padding(paddingValues)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleHamburger() {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val items = listOf(Icons.Default.Close, Icons.Default.Clear, Icons.Default.Call)
    val selectedItem = remember { mutableStateOf(items[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

            ModalDrawerSheet(drawerContainerColor = Color.Red) {
                items.forEach { item ->
                    Spacer(Modifier.height(8.dp))
                    NavigationDrawerItem(
                        icon = { Icon(item, contentDescription = null) },
                        label = { Text(item.name) },
                        selected = item == selectedItem.value,
                        onClick = {
                            scope.launch { drawerState.close() }
                            selectedItem.value = item
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }


        },
        content = {

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                "Simple TopAppBar",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Localized description"
                                )
                            }
                        }
                    )
                },
                content = { innerPadding ->
                    LazyColumn(
                        contentPadding = innerPadding,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {

                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "My first toolbar") },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),

        navigationIcon = {
            IconButton(onClick = { onClickIcon("Back") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },

        actions = {
            IconButton(onClick = { onClickIcon("Search") }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }

            IconButton(onClick = { onClickIcon("Danger") }) {
                Icon(
                    imageVector = Icons.Filled.Dangerous,
                    contentDescription = "Danger"
                )
            }
        }
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarHamburger(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "My Hamburger toolbar") },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        ),

        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
    )

}


@Composable
fun MyBottomNavigation() {
    var index by remember { mutableIntStateOf(0) }

    BottomNavigation(backgroundColor = Color.Red, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = if (index == 0) Color.Black else Color.White
            )
        }, label = { Text(text = "Home") })

        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favourite",
                tint = if (index == 1) Color.Black else Color.White
            )
        }, label = { Text(text = "Favourite") })

        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person",
                tint = if (index == 2) Color.Black else Color.White
            )
        }, label = { Text(text = "Person") })

    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = { }, backgroundColor = Color.Blue,
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }

}

@Composable
fun MyFloatingActionButtonDocked() {

    Box {
        FloatingActionButton(
            onClick = {},
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.Center)
                .size(60.dp)
                .offset(y = 40.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )
        }
    }
}

//Hamburger menu
@Composable
fun MyDrawer() {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "First Option",
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Second Option",
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Third Option",
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Quarter Option",
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
    }
}