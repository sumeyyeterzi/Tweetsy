package com.sumeyyaterzi.tweetsy.screens


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sumeyyaterzi.tweetsy.R
import com.sumeyyaterzi.tweetsy.viewmodels.CategoryViewModel


@Composable
fun CategoryScreen(onClick:(category:String)->Unit){
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val categories: State<List<String>> = categoryViewModel.categories.collectAsState()

    if (categories.value.isEmpty()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Loading...",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 20.sp,
                    color = Color(0xFF00688F)

                )
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator()
            }
        }
    }

else{
    LazyVerticalGrid(columns =GridCells.Fixed(2) ,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround,
    ){

        items(categories.value.distinct()){

            CategoryItem(category = it, onClick )
        }

    }
}

}




@Composable
fun CategoryItem(category : String, onClick:(category:String)->Unit){

Box(modifier = Modifier
    .padding(4.dp)
    .clickable {
        onClick(category)
    }
    .size(160.dp)
    .clip(RoundedCornerShape(8.dp))
    .paint(
        painter = painterResource(id = R.drawable.bg),
        contentScale = ContentScale.Crop
    )
    .border(1.dp, Color(0xFFEEEEEE)),
    contentAlignment = Alignment.BottomCenter

){

    Text(text = category,
        fontSize = 18.sp,
        color = Color.Black,
        modifier = Modifier.padding(0.dp, 20.dp),
        style = MaterialTheme.typography.bodyMedium,






        )





}

}