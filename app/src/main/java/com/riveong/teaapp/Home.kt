package com.riveong.teaapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.riveong.teaapp.model.Sigma
import com.riveong.teaapp.model.SigmasData
import com.riveong.teaapp.model.components.Welcome
import com.riveong.teaapp.model.components.sigmaList



@Composable
fun Home(
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,){
    Column(modifier.padding(5.dp)) {
        Welcome()
        SigmaL(navigateToDetail=navigateToDetail,data = SigmasData)
        Other()
    }
}

@Composable
fun Other(modifier: Modifier = Modifier.padding(20.dp)) {
    Text(
        text = "Note: This whole project is just for fun and for the final dicoding submission, I'm not into the meme itself, I made this app simply because I think it's fun and hilarious at the same time also I had no other idea so yea this idea been chosen XD", modifier
    )
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun SigmaL(
    modifier: Modifier = Modifier,
    data: SigmasData,
    navigateToDetail: (Long) -> Unit,
) {
    Box(modifier = modifier) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            items(data.sigmas, key = { it.id }) { sigma ->
                sigmaList(
                    sigma.name,
                    sigma.photoURL,
                    modifier.clickable{
                        navigateToDetail(sigma.id)
                    }
                )
            }
        }
    }
}