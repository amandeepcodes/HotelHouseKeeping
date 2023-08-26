package com.gigamage.hotelproject.ui.tasks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksListUI(onClickAddNewTask: () -> Unit){
    Scaffold(floatingActionButton = { AddTaskButton(onClickAddNewTask) }, floatingActionButtonPosition = FabPosition.Center , content = {
        Surface(modifier = Modifier.padding(paddingValues = it)) {
            LazyColumn(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(16.dp)
            ){
                items(30){
                    TaskUI(it)
                }
            }
        }
    })
}

@Composable
fun TaskUI(i: Int) {
    Surface (shape = MaterialTheme.shapes.small){
        Row (modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
            verticalAlignment = Alignment.CenterVertically){
            Spacer(Modifier.height(16.dp))
            Text(text = "Task  $i", modifier = Modifier
                .padding(8.dp)
                .weight(1f, true),
                style = MaterialTheme.typography.headlineSmall)

            IconButton(onClick = { /*TODO*/ },) {
                Icon(Icons.Filled.Close,"")
            }
        }

    }
}


@Composable
fun AddTaskButton(onClickAddNewTask: () -> Unit) {
    ExtendedFloatingActionButton(onClick = onClickAddNewTask) {
        Icon(Icons.Filled.Add, "")
        Text(text = "Add Task")
    }
}

@Preview
@Composable
fun previewTasks(){
    TasksListUI {}
}