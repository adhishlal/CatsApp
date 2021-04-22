package com.adhish.catsapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhish.catsapp.R
import com.adhish.catsapp.data.model.CatsResponse
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val catsResponse: ArrayList<CatsResponse>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(catsResponse: CatsResponse) {
            Glide.with(itemView.imageViewAvatar.context)
                .load(catsResponse.url)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = catsResponse.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(catsResponse[position])

    fun addData(list: List<CatsResponse>) {
        catsResponse.addAll(list)
    }

}