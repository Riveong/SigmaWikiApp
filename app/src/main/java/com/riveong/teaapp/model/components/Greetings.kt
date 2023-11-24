package com.riveong.teaapp.model.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.riveong.teaapp.R
import com.riveong.teaapp.ui.theme.TeaAppTheme

@Composable
fun Greetings(modifier: Modifier = Modifier){
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hi there!",
            fontSize = 50.sp)
        Image(painter = painterResource(id = R.drawable.saya), contentDescription = null, Modifier.size(200.dp))
        Text(text = "Ong Gabriel",
            fontSize = 30.sp)
        Text(text = "setsubi9@gmail.com",
            fontSize = 20.sp)
    }

}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun GreetingPreview() {
    TeaAppTheme {
        Greetings()
    }
}