package tech.jhavidit.miskaaassignment.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize

data class CountryItem(

    val name: String = "",
    val capital: String = "",
    val region: String = "",
    val subregion: String = "",
    val population: Long = 0L,
    val borders: List<String>,
    val flag: String? = null
) : Parcelable

