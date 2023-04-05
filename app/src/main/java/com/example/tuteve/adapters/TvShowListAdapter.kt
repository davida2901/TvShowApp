package com.example.tuteve.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tuteve.R
import com.example.tuteve.models.TVShowSummary
import com.squareup.picasso.Picasso

class TvShowListAdapter(val items : List<TVShowSummary>): RecyclerView.Adapter<TvShowListAdapter.ViewHolder>() {


    public class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvShowName = view.findViewById<TextView>(R.id.tvshow_name)
        val tvshowStartDate = view.findViewById<TextView>(R.id.tvshow_start_date)
        val tvShowNetwork = view.findViewById<TextView>(R.id.tvshow_network)
        val tvShowImage = view.findViewById<ImageView>(R.id.tvShow_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tv_show_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvShow = items.get(position)
        holder.tvShowName.text = tvShow.name
        holder.tvshowStartDate.text = tvShow.startDate
        holder.tvShowNetwork.text = tvShow.network

        Picasso.get()
            .load(tvShow.imageURL)
            .resize(270,400)
            .centerCrop()
            .into(holder.tvShowImage)

        holder.tvShowImage
    }
}