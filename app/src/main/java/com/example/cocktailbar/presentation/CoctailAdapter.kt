package com.example.cocktailbar.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailbar.R
import com.example.cocktailbar.domain.Coctail

class CoctailAdapter :
    ListAdapter<Coctail, CoctailAdapter.CoctailViewHolder>(CoctailDiffCallback()) {
    var coctailItemClickListener: OnCoctailItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoctailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return CoctailViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoctailViewHolder, position: Int) {
        val item = getItem(position)
        holder.tvText.text = item.name
        holder.view.setBackgroundResource(item.pictureId)
        holder.view.setOnClickListener {
            coctailItemClickListener?.itemClick(item)
        }
    }

    class CoctailViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvText = view.findViewById<TextView>(R.id.tvName)

    }

    interface OnCoctailItemClickListener {
        fun itemClick(coctail: Coctail) {}
    }
}