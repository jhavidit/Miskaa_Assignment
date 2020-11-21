package tech.jhavidit.miskaaassignment.view

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import tech.jhavidit.miskaaassignment.R
import tech.jhavidit.miskaaassignment.adapter.CountryListAdapter
import tech.jhavidit.miskaaassignment.databinding.ActivityMainBinding
import tech.jhavidit.miskaaassignment.model.CountryItemLocal
import tech.jhavidit.miskaaassignment.viewModel.CountryListViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:  ActivityMainBinding
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
            if (it) {
                binding.progressCircular.visibility = VISIBLE
                binding.recyclerView.visibility = GONE
            } else {
                binding.progressCircular.visibility = GONE
                binding.recyclerView.visibility = VISIBLE
            }
        })

        viewModel.getCountryList()

        viewModel.readAllData.observe(this, Observer {
            Log.d("data", it.toString())

            adapter.setCountryItem(it)
        })
        viewModel.showCountryDetails.observe(this, Observer {

            for (i in it) {
                var language: String = ""
                for (a in i.languages) {
                    language += a.name + "(" + a.nativeName + ")\n"
                }
                val countryItemLocal = CountryItemLocal(
                    0,
                    i.name,
                    i.capital,
                    i.region,
                    i.subregion,
                    i.population,
                    i.borders.toString(),
                    i.flag, language
                )
                viewModel.addCountryData(countryItemLocal)
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator: MenuInflater = menuInflater
        inflator.inflate(R.menu.delete_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_delete -> deleteAllUSers()

        }
        return super.onOptionsItemSelected(item)
    }

    fun deleteAllUSers() {
        val builder = AlertDialog.Builder(this)
        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteAllCountry()
            Toast.makeText(
                this,
                "Successfully deleted everything from the local database",
                Toast.LENGTH_SHORT
            ).show()

        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }


}