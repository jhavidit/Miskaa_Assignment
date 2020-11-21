package tech.jhavidit.miskaaassignment.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener
import tech.jhavidit.miskaaassignment.R
import tech.jhavidit.miskaaassignment.databinding.ActivityCountryDetailsBinding

class CountryDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_country_details)
        val countryData = intent.extras?.getBundle("countryData")
        binding.countryLanguage.text = countryData?.getString("language")
        binding.countryCapital.text = countryData?.getString("capital")
        binding.countryPopulation.text = countryData?.getLong("population").toString()
        binding.countryRegion.text = countryData?.getString("region")
        binding.flagName.text = countryData?.getString("country")
        var boundaries = countryData?.getString("borders")
        boundaries = boundaries?.substring(1, boundaries.length - 1)
        if (boundaries!!.isEmpty()) {
            boundaries = "Not available"
        }
        binding.countrySubregion.text = countryData?.getString("subregion")
        binding.countryBoundary.text = boundaries
        val flag = countryData?.getString("flag")
        GlideToVectorYou
            .init()
            .with(this)
            .withListener(object : GlideToVectorYouListener {
                override fun onLoadFailed() {

                }

                override fun onResourceReady() {

                }

            })
            .load(flag?.toUri(), binding.countryFlag)

    }
}