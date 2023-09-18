package com.aleiva.hcompose.repository

import com.aleiva.hcompose.data.local.HeroDao
import com.aleiva.hcompose.data.model.Hero
import com.aleiva.hcompose.data.model.HeroEntity
import com.aleiva.hcompose.data.remote.ApiClient
import com.aleiva.hcompose.data.remote.HeroResponse
import com.aleiva.hcompose.data.remote.HeroService
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import com.aleiva.hcompose.utils.Result

class HeroRepository (
  private val heroService: HeroService = ApiClient.getHeroService(),
  private val heroDao: HeroDao
) {

  fun searchByName(name: String, callback: (Result<List<Hero>>) -> Unit) {
    val searchByName = heroService.searchByName(textQuery = name)

    searchByName.enqueue(object : Callback<HeroResponse> {
      override fun onResponse(call: Call<HeroResponse>, response: Response<HeroResponse>) {
        if (response.isSuccessful) {
          try {
            val heroes = response.body()!!.heroes
            heroes.forEach { hero ->
              //hero.isFavorite = heroDao.getById(hero.id) != null
              hero.isFavorite = false
            }
            callback(Result.Success(response.body()!!.heroes))
          } catch (e: Exception) {
            callback(Result.Success(listOf<Hero>()))
          }
        }
      }

      override fun onFailure(call: Call<HeroResponse>, t: Throwable) {
        callback(Result.Error(t.localizedMessage as String))
      }

    })
  }

  fun searchById(id: String, callback: (Result<Hero>) -> Unit) {
    val searchById = heroService.searchById(id = id)

    searchById.enqueue(object : Callback<Hero> {
      override fun onResponse(call: Call<Hero>, response: Response<Hero>) {
        if (response.isSuccessful) {
          callback(Result.Success(response.body()!!))
        }
      }

      override fun onFailure(call: Call<Hero>, t: Throwable) {
        callback(Result.Error(t.localizedMessage as String))
      }
    })
  }

  fun save(hero: Hero) {
    heroDao.save(HeroEntity(hero.id))
  }

  fun delete(hero: Hero) {
    heroDao.delete(HeroEntity(hero.id))
  }

  fun existsById(hero: Hero): Boolean {
    return heroDao.getById(hero.id) != null;
  }
}