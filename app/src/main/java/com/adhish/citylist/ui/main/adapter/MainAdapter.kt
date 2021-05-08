package com.adhish.citylist.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhish.citylist.R
import com.adhish.citylist.data.model.GeoNames
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val geoNames: ArrayList<GeoNames>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(geoNames: GeoNames) {
            // TODO show data here
            itemView.name.text = geoNames.name
            itemView.adminName.text = geoNames.adminName1
            itemView.countryName.text = geoNames.countryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = geoNames.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(geoNames[position])

    fun addData(list: List<GeoNames>) {
        geoNames.addAll(list)
    }

}