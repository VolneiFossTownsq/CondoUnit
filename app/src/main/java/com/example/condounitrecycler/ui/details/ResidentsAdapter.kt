package com.example.condounitrecycler.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.condounitrecycler.R
import com.example.condounitrecycler.data.models.Resident

class ResidentsAdapter:RecyclerView.Adapter<ResidentsAdapter.ViewHolder>() {

    private var residents:List<Resident> = listOf()

    fun setResidents(residents: List<Resident>){
        this.residents = residents
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_resident_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = residents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = residents[position]
        holder.bind(item)
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        private val profilePicture:ImageView = view.findViewById(R.id.profilePicture)
        private val residentName:TextView = view.findViewById(R.id.residentName)

        fun bind(resident: Resident){
            residentName.text = resident.name
            profilePicture.load(resident.profilePicture)
        }
    }


}