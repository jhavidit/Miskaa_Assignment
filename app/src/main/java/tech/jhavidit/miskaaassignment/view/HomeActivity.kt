package tech.jhavidit.miskaaassignment.view

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tech.jhavidit.miskaaassignment.R
import tech.jhavidit.miskaaassignment.adapter.CountryListAdapter
import tech.jhavidit.miskaaassignment.databinding.ActivityMainBinding
import tech.jhavidit.miskaaassignment.viewModel.CountryListViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CountryListViewModel
    private lateinit var adapter: CountryListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        viewModel = ViewModelProvider(this).get(CountryListViewModel::class.java)
        adapter = CountryListAdapter(this)
        binding.recyclerView.adapter = adapter
        viewModel.showProgress.observe(this, Observer {
            if (it)
                binding.progressCircular.visibility = VISIBLE
            else
                binding.progressCircular.visibility = GONE
        })

//        viewModel.readAllData.observe(this, Observer {
//            adapter.setCountryItem(it)
//        })
        viewModel.getCountryList()
        viewModel.showCountryDetails.observe(this, Observer {

            adapter.setCountryItem(it)
        })

    }
}