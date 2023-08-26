package com.gigamage.hotelproject.ui.rooms

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRoomScreen() {

    var text by remember { mutableStateOf("") }

    var hasSofa by remember { mutableStateOf(true) }

    val radioGroupOptions = listOf("King", "Queen")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioGroupOptions[0]) }

    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            OutlinedTextField(
                value = text,
                label = { Text(text = "Add Room Number") },
                onValueChange = { newText -> text = newText })

            RoomType(radioGroupOptions, selectedOption, onOptionSelected)

            if (selectedOption == radioGroupOptions[0]) {
                Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = hasSofa, onCheckedChange = { hasSofa = it })
                    Text(text = "Has Sofa? ")
                }
            }


            Button(
                onClick = {
                    if (text.isNotEmpty()) {
                        Log.e("Data", "$text , $selectedOption , $hasSofa")
                    }

                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Add Room")
            }
        }
    }
}


@Composable
fun RoomType(
    radioGroupOptions: List<String>,
    selected: String,
    onOptionSelected: (String) -> Unit
) {

    Row {
        radioGroupOptions.forEach { text ->
            Row(Modifier
                .selectable(
                    selected = (text == selected),
                    onClick = { onOptionSelected(text) }
                )
                .padding(vertical = 16.dp), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(0.dp)) {
                RadioButton(
                    selected = (text == selected),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewAddRoomScreen() {
    AddRoomScreen()
}