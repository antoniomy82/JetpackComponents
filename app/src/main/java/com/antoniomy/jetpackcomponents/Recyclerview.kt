package com.antoniomy.jetpackcomponents

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antoniomy.jetpackcomponents.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun SimpleRecyclerView() {

    val myList = listOf("Pepe", "Manolo", "Juan", "Antonio")

    LazyColumn {
        item { Text(text = "Header") }

        items(myList) {
            Text(text = "hola me llamo $it")
        }

        item { Text(text = "Footer") }

        items(7) {
            Text(text = "Este es el item $it")
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current

    //LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHero()) { superHero ->
            ItemHero(superHero = superHero) {
                Toast.makeText(
                    context,
                    "SuperHero-> ${it.superHeroName}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current

    //Number of columns = GridCells.Adaptive(100.dp)
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getSuperHero()) { superHero ->
            ItemHero(superHero = superHero) {
                Toast.makeText(
                    context,
                    "SuperHero-> ${it.superHeroName}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }, contentPadding = PaddingValues(16.dp)) //Outside space
}

@Composable
fun SuperHeroWithSpecialControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHero()) { superHero ->
                ItemHero(superHero = superHero) {
                    Toast.makeText(
                        context,
                        "SuperHero-> ${it.superHeroName}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        //Show button when position is more than 0
        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        if (showButton) {
            Button(onClick = {
                coroutineScope.launch { rvState.animateScrollToItem(0) }

            }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Go to Top")
            }
        }

    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superHero: Map<String, List<SuperHero>> = getSuperHero().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        superHero.forEach { (publisher, mySuperHero) ->

            stickyHeader {
                Text(
                    text = publisher,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }

            items(mySuperHero) { superHero ->
                ItemHero(superHero = superHero) {
                    Toast.makeText(context, "SuperHero-> ${it.superHeroName}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit = {}) {

    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superHero) }
            .padding(2.dp)) //Interior Space
    {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = superHero.superHeroName + " Avatar",
                modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop
            )

            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp
            )

            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )
        }

    }

}

fun getSuperHero(): List<SuperHero> = listOf(
    SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
    SuperHero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
    SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
    SuperHero("Thor", "Thor Odison", "Marvel", R.drawable.thor),
    SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
    SuperHero("Green Lantern", "Alan Scoot", "DC", R.drawable.green_lantern),
    SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
)
