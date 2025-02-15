package com.example.aprendeprogramando

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.aprendeprogramando.ui.theme.AprendeProgramandoTheme
import com.example.aprendeprogramando.vistas.HomeScreen
import com.example.aprendeprogramando.vistas.TaskListScreen
import com.example.aprendeprogramando.vistas.apiGames


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AprendeProgramandoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    aP(navController = navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable



fun apBar ( //volver atras
    currentScreen : String,
    canNavigateBack : Boolean,
    navigateUp : ()->Unit,
    modifier: Modifier = Modifier
){
   TopAppBar(
       title = { Text(currentScreen) },
       colors = TopAppBarDefaults.mediumTopAppBarColors(
           containerColor = MaterialTheme.colorScheme.secondaryContainer
       ), modifier = Modifier,
       navigationIcon = {
           if(canNavigateBack){
               IconButton(onClick = navigateUp, modifier =  Modifier.background(Color.Cyan)){
                   Icon(
                       imageVector = Icons.Filled.ArrowBack,
                       contentDescription = "Back"
                   )
               }
           }
       }
   )

}

@Composable
fun aP (navController : NavHostController = rememberNavController()){
    Scaffold (
        topBar = {
            apBar(
                currentScreen = navController.currentBackStackEntryAsState().value?.destination?.route ?:"Start",
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {navController.navigateUp()}
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "Inicio",
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable("Inicio") {
                HomeScreen(
                    navController = navController,
                    onNextButtonClicked = {
                        navController.navigate("Lista de Tareas")
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable("lista de tareas"){
                TaskListScreen()
            }
            composable("Juegos"){
                apiGames()
            }
        }
    }
}