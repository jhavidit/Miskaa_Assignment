package tech.jhavidit.miskaaassignment.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.jhavidit.miskaaassignment.model.CountryItem
import tech.jhavidit.miskaaassignment.model.CountryItemLocal
import tech.jhavidit.miskaaassignment.repository.CountryListRepository
import tech.jhavidit.miskaaassignment.room.CountryDatabase


class CountryListViewModel(application: Application) : AndroidViewModel(application) {
    val showCountryDetails: LiveData<List<CountryItem>>
    val showProgress: LiveData<Boolean>
    val readAllData: LiveData<List<CountryItemLocal>>
    private val repository : CountryListRepository

    init {

        val countryDao = CountryDatabase.getDatabase(application).countryDao()
        repository = CountryListRepository(application, countryDao)
        this.showProgress = repository.showProgress
        this.showCountryDetails = repository.showCountryList
        readAllData = repository.readAllData

    }

    fun addCountryData(countryItemLocal: CountryItemLocal)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCountry(countryItemLocal)
        }
    }
    fun deleteAllCountry(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCountry()
        }
    }

    fun getCountryList() {
        repository.getCountryList()
    }
}