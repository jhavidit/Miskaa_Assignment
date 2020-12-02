package tech.jhavidit.miskaaassignment.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.jhavidit.miskaaassignment.model.CountryItem
import tech.jhavidit.miskaaassignment.model.CountryItemLocal
import tech.jhavidit.miskaaassignment.network.APIClient
import tech.jhavidit.miskaaassignment.room.CountryDao


class CountryListRepository(private val application: Application, val countryDao: CountryDao) {
    val showCountryList = MutableLiveData<List<CountryItem>>()
    val showProgress = MutableLiveData<Boolean>()

    val readAllData: LiveData<List<CountryItemLocal>> = countryDao.getCountry()

    suspend fun addCountry(countryItemLocal: CountryItemLocal) {
        countryDao.insertCountry(countryItemLocal)
    }

    suspend fun deleteAllCountry() {
        countryDao.deleteAllCountries()
    }

    fun getCountryList() {
        val retrofitService = APIClient.getClient(application)
        showProgress.value = true
        retrofitService.getCountryList().enqueue(object : Callback<List<CountryItem>> {
            override fun onFailure(call: Call<List<CountryItem>>, t: Throwable) {
                showProgress.value = false
                Log.d("response", t.message.toString())

            }

            override fun onResponse(
                call: Call<List<CountryItem>>,
                response: Response<List<CountryItem>>
            ) {
                showProgress.value = false
                showCountryList.value = response.body()

                if (response.body() != null)

                    Log.d("response", response.body().toString())
            }

        })
    }


}