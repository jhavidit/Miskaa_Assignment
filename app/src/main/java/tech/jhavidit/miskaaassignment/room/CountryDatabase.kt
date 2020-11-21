package tech.jhavidit.miskaaassignment.room

//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import tech.jhavidit.miskaaassignment.model.CountryItem
//
//@Database(version = 1, entities = [CountryItem::class],exportSchema = false)
//abstract class Country : RoomDatabase() {
//
//    abstract fun countryDao(): CountryDao
//
//    companion object {
//        @Volatile
//        private var INSTANCE: Country? = null
//
//        fun getDatabase(context: Context): Country {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this)
//            {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    Country::class.java,
//                    "country_database"
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
//
//}