package tech.jhavidit.miskaaassignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class CountryItem(
    val name: String = "",
    val capital: String = "",
    val region: String = "",
    val subregion: String = "",
    val population: Long = 0L,
    val borders: List<String>,
    val flag: String? = null,
    val languages: List<Languages>
) : Parcelable

@Parcelize
data class Languages(
    val name: String = "",
    val nativeName: String = ""

) : Parcelable

