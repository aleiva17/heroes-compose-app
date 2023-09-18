package com.aleiva.hcompose.ui.heroexplorer.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aleiva.hcompose.data.model.Hero

@Composable
fun HeroDetailPowerStats(hero: Hero) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .padding(16.dp)
  ) {
    Column(
      modifier = Modifier.padding(16.dp)
    ) {
      Text(
        text = "Power Stats",
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.titleLarge,
      )
      PowerStatInfo(label = "Intelligence", power = hero.powerStats.intelligence)
      PowerStatInfo(label = "Strength", power = hero.powerStats.strength)
      PowerStatInfo(label = "Speed", power = hero.powerStats.speed)
      PowerStatInfo(label = "Durability", power = hero.powerStats.durability)
      PowerStatInfo(label = "Power", power = hero.powerStats.power)
      PowerStatInfo(label = "Combat", power = hero.powerStats.combat)
    }
  }
}

@Composable
fun PowerStatInfo(label: String, power: String) {
  power.toFloatOrNull()?.let {
    Row (
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        modifier = Modifier.width(100.dp),
        text = label
      )
      Slider(
        modifier = Modifier.width(400.dp),
        value = it,
        onValueChange = {},
        valueRange = 0f..100f
      )
    }
  }
}