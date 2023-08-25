package com.gigamage.hotelproject.ui.rooms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gigamage.hotelproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomsList() {
Scaffold(floatingActionButton = { AddRoomButton() }, content = {
    Surface(modifier = Modifier.padding(paddingValues = it)) {
        ListOfRommsUI()
    }
    } )

}


@Composable
fun ListOfRommsUI(){
    LazyColumn(
        modifier = Modifier, verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(30) {
            Room()
        }
    }
}
@Composable
fun Room() {
    Surface(shape = MaterialTheme.shapes.small) {
        Card {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.king), contentDescription = "image",
                modifier = Modifier
                    .size(40.dp)
                    .padding(4.dp)
            )

            Column(modifier = Modifier.weight(1f, true)) {
                Text(text = "501", style = MaterialTheme.typography.headlineSmall)
                Text(text = "Room Status", style = MaterialTheme.typography.labelSmall)
            }
            Box(
                modifier = Modifier
                    .widthIn(16.dp)
                    .fillMaxHeight()
                    .clip(RectangleShape)
                    .background(Color.Red)
            )
        }
        }
    }
}


@Composable
fun AddRoomButton(){
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.Add,"")
    }
}
@Composable
@Preview
fun previewRooms() {
    RoomsList()
}