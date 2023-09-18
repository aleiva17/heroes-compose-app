package com.aleiva.hcompose.ui.heroexplorer.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aleiva.hcompose.data.local.AppDatabase
import com.aleiva.hcompose.data.model.Hero
import com.aleiva.hcompose.repository.HeroRepository
import com.aleiva.hcompose.ui.navigation.Routes
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HeroCard(hero: Hero, navController: NavController) {
  val context = LocalContext.current
  val (isFavorite, setIsFavorite) = remember { mutableStateOf(hero.isFavorite)}
  val heroDao = AppDatabase.getInstance(context).heroDao()
  val heroRepository = HeroRepository(heroDao = heroDao)

  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp)
      .clickable {
        navController.navigate(Routes.HeroDetails.passId(hero.id))
      }
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(16.dp)
    ) {
      GlideImage(
        imageModel = { hero.image.url },
        imageOptions = ImageOptions(contentScale = ContentScale.Fit),
        modifier = Modifier.size(112.dp)
      )
      Column(modifier = Modifier.weight(5f)) {
        Text(text = hero.name, fontWeight = FontWeight.Bold)
        Text(text = hero.biography.fullName)
      }
      IconButton(modifier = Modifier.weight(1f), onClick = {
        if (isFavorite) {
          hero.isFavorite = false
          heroRepository.delete(hero)
        } else {
          hero.isFavorite = true
          heroRepository.save(hero)
        }
        setIsFavorite(!isFavorite)
      }) {
        Icon(
          Icons.Default.Favorite,
          "Favorite Icon",
          tint =
            if (isFavorite) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurface
        )
      }
    }
  }

}