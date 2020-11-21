package tech.jhavidit.miskaaassignment.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.jhavidit.miskaaassignment.model.CountryItem
import tech.jhavidit.miskaaassignment.network.APIClient


class CountryListRepository(val application: Application) {
    val showCountryList = MutableLiveData<List<CountryItem>>()
    val showProgress = MutableLiveData<Boolean>()
    //val readAllData :LiveData<List<CountryItem>> = countryDao.getCountry()
//    suspend fun addCountry(countryItem: List<CountryItem>)
//    {
//        countryDao.insertCountry(countryItem)
//    }
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