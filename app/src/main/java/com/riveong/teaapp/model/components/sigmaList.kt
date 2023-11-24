package com.riveong.teaapp.model.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.riveong.teaapp.R

@Composable
    fun sigmaList(sigma:String = "Ryan Gosling",photoURL: String,modifier: Modifier = Modifier){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(color = Color.LightGray,
                shape = RoundedCornerShape(4.dp)


            )
        ) {
            AsyncImage(
                model = photoURL,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(150.dp)
            )

            Text(text = sigma,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
    }
