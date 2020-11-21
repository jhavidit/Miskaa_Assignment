package tech.jhavidit.miskaaassignment.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener
import kotlinx.android.synthetic.main.country_list.view.*
import tech.jhavidit.miskaaassignment.R
import tech.jhavidit.miskaaassignment.model.CountryItemLocal
import tech.jhavidit.miskaaassignment.view.CountryDetailsActivity

class CountryListAdapter(private val context: Context) :
    RecyclerView.Adapter<CountryListAdapter.ViewHolder>() {

    private var list: List<CountryItemLocal> = ArrayList()

    fun setCountryItem(list: List<CountryItemLocal>) {
        this.list = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.country_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {

        return list.size


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var item = list[position]
        holder.countryCapital.text = item.capital
        holder.countryName.text = item.name

        val uri = item.flag?.toUri()
        GlideToVectorYou
            .init()
            .with(context)
            .withListener(object : GlideToVectorYouListener {
                override fun onLoadFailed() {

                }

                override fun onResourceReady() {

                }

            })
            .load(uri, holder.countryFlag)
        holder.countryCard.setOnClickListener {
            val bundle =
                bundleOf(
                    "flag" to item.flag,
                    "country" to item.name,
                    "capital" to item.capital,
                    "region" to item.region,
                    "subregion" to item.subregion,
                    "population" to item.population,
                    "borders" to item.borders,
                    "language" to item.languages
                )
            context.startActivity(
                Intent(
                    context,
                    CountryDetailsActivity::class.java
                ).putExtra("countryData", bundle)
            )

        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countryName: TextView = view.country_name
        val countryCapital: TextView = view.country_capital
        val countryFlag: ImageView = view.flag_icon
        val countryCard: CardView = view.country_card

    }
}