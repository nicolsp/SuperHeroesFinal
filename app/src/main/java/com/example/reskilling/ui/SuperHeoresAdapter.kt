package com.example.reskilling.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reskilling.R
import com.example.reskilling.model.local.SuperHeroesEntity
import com.example.reskilling.model.pojos.SuperHeroe
import kotlinx.android.synthetic.main.super_heroe_item_list.view.*

class SuperHeoresAdapter(val mpassTheData : passTheData ) : RecyclerView.Adapter<SuperHeoresAdapter.SuperHeroesViewHolder{

    private var superHeroesList = emptyList<SuperHeroesEntity>()

    fun updateAdapter(mList : List<SuperHeroesEntity>) {
        superHeroesList= mList
        notifyDataSetChanged()
    }


    inner class SuperHeroesViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
val image = itemView.imageHeroes
        val name = itemView.nameHeroes
        val clickListener = itemView.setOnClickListener {
mpassTheData.pa
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.super_heroe_item_list,parent,false)
    return  SuperHeroesViewHolder(view)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SuperHeroesViewHolder, position: Int) {
        val superHeroes = superHeroesList[position]
        Glide.with(holder.itemView.context).load(superHeroes.imageXs).into(holder.image)
        holder.name.text = superHeroes.name
    }
    Interface
}