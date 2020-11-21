package tech.jhavidit.miskaaassignment.room

import androidx.lifecycle.LiveData
import androidx.room.*
import tech.jhavidit.miskaaassignment.model.CountryItemLocal

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(list: CountryItemLocal)

    @Query(" SELECT * FROM country_table ORDER BY id ASC ")
    fun getCountry(): LiveData<List<CountryItemLocal>>

    @Query("DELETE FROM country_table")
    suspend fun deleteAllCountries()

}