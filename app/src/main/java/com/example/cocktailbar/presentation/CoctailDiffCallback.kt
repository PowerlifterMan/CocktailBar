package com.example.cocktailbar.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.cocktailbar.domain.Coctail

class CoctailDiffCallback: DiffUtil.ItemCallback<Coctail>() {
    override fun areItemsTheSame(oldItem: Coctail, newItem: Coctail): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Coctail, newItem: Coctail): Boolean {
        return newItem == oldItem
    }
}