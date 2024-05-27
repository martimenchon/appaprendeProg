package com.example.aprendeprogramando.vistas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aprendeprogramando.R




@Composable  //llamar desde otro archivo
fun HomeScreen(navController: NavController,
               onNextButtonClicked: () -> Unit,
               modifier: Modifier = Modifier){                           // padding es el relleno mas o menos
    Surface(modifier = Modifier.fillMaxSize().padding(16.dp)){   //vista de la pantalla, modifier son los estilos
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Image(painter = painterResource(id = R.drawable.galleta), contentDescription = "logo de la marca")
            Text("Cooki&")
            Button(onClick = { onNextButtonClicked() } ){
                Text("Lista de tareas")
            }
            Button(onClick =  { navController.navigate("Juegos")}){
                Text("Juegos")

            }
        }
    }
}
