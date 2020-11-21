package tech.jhavidit.miskaaassignment.room
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import tech.jhavidit.miskaaassignment.model.CountryItem
//
//@Dao
//interface CountryDao
//{
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertCountry(list : CountryItem)
//
//    @Query(" SELECT * FROM country_table ")
//    fun getCountry(): LiveData<CountryItem>
//}