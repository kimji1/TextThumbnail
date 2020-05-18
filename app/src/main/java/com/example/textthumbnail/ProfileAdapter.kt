package com.example.textthumbnail

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_profile.view.*

class ProfileAdapter(val items: List<String>) : RecyclerView.Adapter<ProfileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder =
        ProfileViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        )

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}

class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(data: String) {
        itemView.title.text = data
        itemView.thumbnail.run {
            setIcon(R.drawable.ic_launcher_foreground)
            setText(data)
            setTextColor(Color.GRAY)
            setCircleColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
        }
    }
}