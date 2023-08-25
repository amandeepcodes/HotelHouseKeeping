package com.gigamage.hotelproject.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TasksListUI(){
    LazyColumn(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(8.dp),
contentPadding = PaddingValues(16.dp)
        ){
        items(30){
            TaskUI()
        }
    }
}

@Composable
fun TaskUI(){
    Surface (shape = MaterialTheme.shapes.small){
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically){
            Spacer(Modifier.height(16.dp))
            Text(text = "Task", modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineSmall)
        }

    }
}

@Preview
@Composable
fun previewTasks(){
    TasksListUI()
}