package com.riveong.teaapp.model.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


    @Composable
    fun Welcome(modifier: Modifier = Modifier){
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Welcome,",
                fontSize = 40.sp
            )
            Text(
                text = "to the wiki of sigmas, which one defines you?"
            )
            Spacer(modifier = Modifier.height(20.dp))

        }
    }


