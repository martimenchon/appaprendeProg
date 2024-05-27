package com.example.aprendeprogramando.vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aprendeprogramando.R

@Composable

fun apiGames(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {   //vista de la pantalla, modifier son los estilos
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.torta), contentDescription = "torta")
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        Text(text = "cupcake")
    }
}


