package com.aleiva.hcompose.data.remote

import com.aleiva.hcompose.data.model.Hero
import com.google.gson.annotations.SerializedName

data class HeroResponse(
  @SerializedName("results")
  val heroes: List<Hero>
)
