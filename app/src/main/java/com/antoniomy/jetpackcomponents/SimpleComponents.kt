package com.antoniomy.jetpackcomponents

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.antoniomy.jetpackcomponents.model.CheckInfo

//Mixed components
@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), Alignment.Center
        ) {
            Text("Ejemplo 1")
        }

        //It´s to add a simple space
        //Spacer(modifier = Modifier.width(30.dp).height(30.dp))

        MySpacer(size = 30)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Yellow), Alignment.Center
            ) {
                Text("Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green), Alignment.Center
            ) {
                Text("Ejemplo 3")
            }
        }

        MySpacer(size = 60)

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Red), Alignment.BottomCenter
        ) {

            Text("Ejemplo 4")
        }


    }
}

@Composable
fun MySpacer(size: Int) = Spacer(modifier = Modifier.height(size.dp))

//Row is like a Linear Layout horizontal
@Composable
fun MyRow() {
    /*
        Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Ejemplo 2", Modifier.weight(1f))
            Text(text = "Ejemplo 3", Modifier.weight(1f))
            Text(text = "Ejemplo 1", Modifier.weight(1f))
        }

     */
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(text = "Ejemplo 2", Modifier.width(100.dp))
        Text(text = "Ejemplo 3", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 2", Modifier.width(100.dp))
        Text(text = "Ejemplo 3", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 2", Modifier.width(100.dp))
        Text(text = "Ejemplo 3", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))

    }
}

//Column is like a Linear Layout vertical
@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        val context = LocalContext.current
        Text(
            text = "Ejemplo 1", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
                .clickable {
                    Toast
                        .makeText(context, "Ejemplo 1", Toast.LENGTH_SHORT)
                        .show()
                }
            //.weight(1f)
        )
        Text(
            text = "Ejemplo 2", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 3", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 4", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 5", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 6", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 7", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 8", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 9", modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 10", modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

//Box is like a FrameLayout
@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState()), contentAlignment = Alignment.Center
        )
        {

            Text(text = stringResource(R.string.test_strings), textAlign = TextAlign.Center)
        }
    }

}

@Composable
fun MyStateExample() {
    //val counter = rememberSaveable { mutableStateOf(0)} //We can also use remember, but it does not save when activity changes to state
    var counter by rememberSaveable { mutableStateOf(0) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}


@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )

        Text(text = "Esto es un ejemplo", fontSize = 30.sp)

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })
}

//Is like a EditText
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) it.replace("a", "A") else it
        },
        label = { Text(text = "Introduce tu nombre") })

}

//Is like a EditText with border
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Nombre") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldStateHoisting(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Composable
fun MyButtonExample() {
    val context = LocalContext.current
    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Button(
            onClick = {
                enabled = false
                Toast.makeText(context, "Hola boton", Toast.LENGTH_SHORT).show()
            },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.Black
            ),
            border = BorderStroke(5.dp, Color.Black)
        ) {
            Text("hola")
        }

        OutlinedButton(
            onClick = {
                enabled = true
                Toast.makeText(context, "Habilito hola boton", Toast.LENGTH_SHORT).show()
            },
            Modifier.padding(top = 5.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text("Adios")
        }

        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "TextButton")
        }
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape) //RoundedCornerShape(40f)
    )
}

@Composable
fun MyIcon() {
    //list of icons by google: fonts.google.com/icons
    Icon(
        imageVector = Icons.Rounded.Star, contentDescription = "Icono ejemplo",
        tint = Color.Red
    )
}

@Composable
fun MyProgress() {

    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Magenta)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Blue,
                trackColor = Color.Green
            )
        }

        Button(onClick = { showLoading = !showLoading }, Modifier.padding(top = 16.dp)) {
            if (showLoading) Text(text = "Hide Loading")
            else Text(text = "Show Loading")
        }
    }

}

@Composable
fun MyProgressAdvance() {

    var progress by rememberSaveable { mutableFloatStateOf(0f) }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = progress)

        Row(Modifier.fillMaxWidth(), Arrangement.Center) {
            Button(onClick = { if (progress != 1f) progress += 0.1f }
            ) {
                Text(text = "Incrementar")
            }

            Button(
                onClick = { if (progress != 0.1f) progress -= 0.1f },
                Modifier.padding(start = 25.dp)
            ) {
                Text(text = "Decrementar")
            }

        }
    }
}

@Composable
fun MySwitch() {
    var switchState by rememberSaveable { mutableStateOf(false) }

    Switch(
        checked = switchState,
        onCheckedChange = { switchState = !switchState },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Magenta,
            checkedTrackColor = Color.Cyan
        )
    )
}

/**
 * CHECK BOXES
 */
@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(false) }

    Checkbox(
        checked = state, onCheckedChange = { state = !state }, enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )

}

@Composable
fun MyCheckBoxWithText() {

    var state by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.padding(8.dp)) {
        Checkbox(checked = state, onCheckedChange = { state = !state })
        Text("Ejemplo 1", Modifier.padding(top = 12.dp))
    }
}

@Composable
fun MyCheckBoxWithTextCompleted(checkInfo: CheckInfo) {
    Row(Modifier.padding(8.dp)) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(checkInfo.title, Modifier.padding(top = 12.dp))
    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var state by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = state,
            onCheckedChange = { newState -> state = newState }
        )
    }

}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }

    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyRadioButton() {

    Row(Modifier.fillMaxWidth()) {
        RadioButton(
            selected = false, onClick = {}, enabled = false, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledUnselectedColor = Color.Green
            )
        )
        Text(text = "Ejemplo 1", Modifier.padding(top = 12.dp))
    }

}

@Composable
fun MyRadioButtonList() {
    var selected by rememberSaveable { mutableStateOf("Option 1") }

    Column(Modifier.fillMaxWidth()) {
        Row() {
            RadioButton(selected = selected == "Option 1", onClick = { selected = "Option 1" })
            Text(text = "Option 1", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = selected == "Option 2", onClick = { selected = "Option 2" })
            Text(text = "Option 2", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = selected == "Option 3", onClick = { selected = "Option 3" })
            Text(text = "Option 3", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = selected == "Option 4", onClick = { selected = "Option 4" })
            Text(text = "Option 4", Modifier.padding(top = 12.dp))
        }
    }
}

@Composable
fun MyRadioButtonListByParameter(name: String, onItemSelected: (String) -> Unit) {


    Column(Modifier.fillMaxWidth()) {
        Row() {
            RadioButton(selected = name == "Option 1", onClick = { onItemSelected("Option 1") })
            Text(text = "Option 1", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = name == "Option 2", onClick = { onItemSelected("Option 2") })
            Text(text = "Option 2", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = name == "Option 3", onClick = { onItemSelected("Option 3") })
            Text(text = "Option 3", Modifier.padding(top = 12.dp))
        }
        Row() {
            RadioButton(selected = name == "Option 4", onClick = { onItemSelected("Option 4") })
            Text(text = "Option 4", Modifier.padding(top = 12.dp))
        }
    }
}

@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(12.dp),
        shape = MaterialTheme.shapes.extraSmall,
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray, //Background
            contentColor = Color.White  //Font Color
        ),
        border = BorderStroke(2.dp, Color.Red)
    ) {
        Column(Modifier.padding(start = 16.dp)) {
            Text(text = "Ejemplo 1", fontWeight = FontWeight.Bold)
            Text(text = "Ejemplo 2", fontWeight = FontWeight.Bold)
            Text(text = "Ejemplo 3", fontWeight = FontWeight.Bold)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {

    Column(Modifier.padding(16.dp)) {
        BadgedBox(
            badge = {
                Badge(contentColor = Color.Green, containerColor = Color.Blue) {
                    Text("99", fontWeight = FontWeight.Bold)
                }
            },
            modifier = Modifier.padding(16.dp),

            ) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favourite")
        }
    }
}

@Composable
fun MyDivider() {
    Column(Modifier.padding(top = 16.dp)) {
        Divider(color = Color.Blue, thickness = 5.dp)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {

    var selectedText by rememberSaveable {
        mutableStateOf("")
    }

    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    val desserts = listOf("Helado", "Chocolate", "Cafe", "Natillas")

    Column(
        Modifier
            .padding(20.dp)
            .wrapContentSize(align = Alignment.TopCenter)) {

        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.align(Alignment.End)
        ) {

            desserts.forEach { dessert ->
                DropdownMenuItem(text = { Text(text = dessert, textAlign = TextAlign.Center,  modifier = Modifier.fillMaxWidth() ) }, onClick = {
                    expanded = false
                    selectedText = dessert
                })
            }
        }
    }

}