package com.riveong.teaapp.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.riveong.teaapp.model.SigmasData.sigmas

@Composable
fun Detail(
    sigmaId: Long,
    sigmaData: List<Sigma> = sigmas
) {
    val sigmaId = sigmaId
    var sigmaName: String = "default"
    var sigmaDescription: String = "default"
    var sigmaPrice: String = ""
    var sigmaPhotoURL: String =""

    for (i in sigmaData) {
        if (i.id == sigmaId) {
            sigmaName = i.name
            sigmaPhotoURL = i.photoURL
            sigmaDescription = i.description
            sigmaPrice = i.price
        }
    }
    Detailed( sigmaName = sigmaName, sigmaDescription = sigmaDescription, sigmaPhotoURL = sigmaPhotoURL, sigmaPrice = sigmaPrice )
}

@Composable
fun Detailed(sigmaName:String,sigmaDescription:String,sigmaPhotoURL:String,sigmaPrice: String){
    Column(
        modifier = Modifier
    ) {
        AsyncImage(
            model = sigmaPhotoURL,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))



        Text(
            text = sigmaName,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 30.sp,

        )
        Text(
            text = sigmaPrice,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 25.sp
        )
        Text(
            text = sigmaDescription,
            modifier = Modifier.padding(20.dp)
        )

    }





}