package com.aleiva.hcompose.ui.heroexplorer.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.aleiva.hcompose.data.model.Hero

@Composable
fun HeroDetailBiography(hero: Hero) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
  ) {
    Column (
      modifier = Modifier.padding(16.dp)
    ) {
      Text(
        text = "Biography",
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.titleLarge,
      )
      Text(
        "Full name: ${hero.biography.fullName}",
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Bold,
      )
    }
  }
}