package com.example.cateeringapp.HomeScreen


import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
 import androidx.compose.material3.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
 import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var items = remember {
        mutableStateListOf("hotel taj", " maradian hotel","Sarad Tent House")
    }

    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    // Adjust outer padding as needed
            ) {

                SearchBar(
                    modifier = Modifier.fillMaxWidth(),
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = {items.add(text)
                        active = false
                        text=""
                               },
                    active = active,
                    onActiveChange = { isAactive -> active = isAactive },
                    placeholder = {Text("Search...")},
                    leadingIcon = {Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")},
                    trailingIcon = {if(active){
                        Icon(modifier = Modifier.clickable { if(text.isNotEmpty()){text="" }else{active=false} },imageVector = Icons.Default.Close, contentDescription = "Close Icon")
                    } },
                    ){
        items.forEach{
            Row(modifier = Modifier.padding(all=14.dp)) {
                      Icon(modifier = Modifier.padding(end=10.dp),imageVector = Icons.Default.Refresh,contentDescription = null)
                Text(text = it)
            }
        }
                }


            }


        }
    )
}
