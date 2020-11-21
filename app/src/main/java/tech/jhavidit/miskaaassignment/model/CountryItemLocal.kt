package tech.jhavidit.miskaaassignment.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "country_table")
@Parcelize
data class CountryItemLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    val capital: String = "",
    val region: String = "",
    val subregion: String = "",
    val population: Long = 0L,
    val borders: String = "",
    val flag: String? = null,
    val languages:String =""
) : Parcelable