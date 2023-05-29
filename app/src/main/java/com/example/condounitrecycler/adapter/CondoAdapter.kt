package com.example.condounitrecycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.condounitrecycler.R
import com.example.condounitrecycler.data.models.CondoUnit

class CondoAdapter(private val onCardClicked: (String) -> Unit) :
    RecyclerView.Adapter<CondoAdapter.CondoViewHolder>() {

    private var itemList: List<CondoUnit> = listOf()

    fun setUnities(itemList: List<CondoUnit>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CondoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.condo_unit_card_view, parent, false)
        return CondoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CondoViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = itemList.size

    inner class CondoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var viewRoot: CardView = itemView.findViewById(R.id.condoCardView)
        private val imgCondo = itemView.findViewById<ImageView>(R.id.imgCondo)
        private val titleCondo = itemView.findViewById<TextView>(R.id.tvNameCondo)
        private val descriptionCondo = itemView.findViewById<TextView>(R.id.tvDescriptionCondo)

        fun bind(unit: CondoUnit) {
            titleCondo.text = unit.unitName
            descriptionCondo?.text = unit.unitDescription
            imgCondo?.load(unit.unitPicture)
            viewRoot.setOnClickListener {
                onCardClicked(unit.id)
            }
        }

    }
}