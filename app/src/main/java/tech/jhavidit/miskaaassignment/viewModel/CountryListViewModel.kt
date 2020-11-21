package tech.jhavidit.miskaaassignment.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.jhavidit.miskaaassignment.model.CountryItem
import tech.jhavidit.miskaaassignment.repository.CountryListRepository


class CountryListViewModel(application: Application) : AndroidViewModel(application) {
    val showCountryDetails: LiveData<List<CountryItem>>
    val showProgress: LiveData<Boolean>
  //  val readAllData: LiveData<List<CountryItem>>
    private val repository = CountryListRepository(application)

    init {

      //  val countryDao = Country.getDatabase(application).countryDao()

        this.showProgress = repository.showProgress
        this.showCountryDetails = repository.showCountryList

    }

//    fun addCountryData(countryItem: List<CountryItem>)
//    {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.addCountry(countryItem)
//        }
//    }

    fun getCountryList() {
        repository.getCountryList()
    }
}