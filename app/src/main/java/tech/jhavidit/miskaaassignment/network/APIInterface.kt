package tech.jhavidit.miskaaassignment.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import tech.jhavidit.miskaaassignment.model.CountryItem


interface APIInterface {
    @GET("region/asia")
    fun getCountryList(
    ):Call<List<CountryItem>>
}