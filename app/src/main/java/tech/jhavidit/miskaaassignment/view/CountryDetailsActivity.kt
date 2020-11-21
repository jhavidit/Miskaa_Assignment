package tech.jhavidit.miskaaassignment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import tech.jhavidit.miskaaassignment.R
import tech.jhavidit.miskaaassignment.databinding.ActivityCountryDetailsBinding

class CountryDetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCountryDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_country_details)
    }
}