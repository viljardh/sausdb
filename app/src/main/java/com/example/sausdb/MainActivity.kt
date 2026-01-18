package com.example.sausdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sausdb.ui.home.Homescreen
import com.example.sausdb.ui.home.Sausscreen
import com.example.sausdb.ui.theme.SausDBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SausDBTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = "Homescreen"
                    ){
                        composable("Homescreen") {
                            Homescreen(navController = navController)
                        }
                        composable("Sausscreen")
                         {backStackEntry ->
                            //val id = backStackEntry.arguments?.getString("id")
                            Sausscreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}