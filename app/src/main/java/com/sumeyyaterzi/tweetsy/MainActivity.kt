package com.sumeyyaterzi.tweetsy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sumeyyaterzi.tweetsy.api.TweetsyAPI
import com.sumeyyaterzi.tweetsy.screens.CategoryScreen
import com.sumeyyaterzi.tweetsy.screens.DetailScreen
import com.sumeyyaterzi.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TweetsyTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Tweetsy",
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF00688F)
                                )
                            },

                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        App()
                    }
                }
            }



        }
    }
}

@Composable
fun App(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination ="category") {
        composable(route="category"){
            CategoryScreen {

                navController.navigate("detail/${it}")

            }

        }

        composable(route="detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type= NavType.StringType
                }
            )

            ){
            DetailScreen()
        }
    }
}


