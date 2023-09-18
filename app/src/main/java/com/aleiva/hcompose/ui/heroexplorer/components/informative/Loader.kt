package com.aleiva.hcompose.ui.heroexplorer.components.informative

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Loader() {
  Column (
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier
      .fillMaxSize()
  ) {
    Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier.padding(bottom = 16.dp)
    ) {
      CircularProgressIndicator()
    }
    Text(
      text = "Searching your hero",
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold
    )
  }
}