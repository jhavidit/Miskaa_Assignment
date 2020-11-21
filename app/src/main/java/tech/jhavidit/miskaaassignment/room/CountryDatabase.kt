package tech.jhavidit.miskaaassignment.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tech.jhavidit.miskaaassignment.model.CountryItemLocal

@Database(version = 1, entities = [CountryItemLocal::class],exportSchema = false)
abstract class CountryDatabase : RoomDatabase() {

    abstract fun countryDao(): CountryDao

    companion object {
        @Volatile
        private var INSTANCE: CountryDatabase? = null

        fun getDatabase(context: Context): CountryDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountryDatabase::class.java,
                    "country_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}