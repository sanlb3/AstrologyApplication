package com.example.astrologyapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HoroscopeAdapter (private val horoscopeList : ArrayList<Horoscope>) : RecyclerView.Adapter<HoroscopeAdapter.HoroscopeViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener)
    {
        mListener = listener
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType: Int) : HoroscopeViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_sign, parent, false)

        return HoroscopeViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int)
    {
        val currentItem = horoscopeList[position]
        holder.signImage.setImageResource(currentItem.signImg)
        holder.signName.text = currentItem.signName
    }

    override fun getItemCount(): Int
    {
        return horoscopeList.size
    }

    class HoroscopeViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView)
    {
        val signImage : ImageView = itemView.findViewById(R.id.sign_img)
        val signName : TextView = itemView.findViewById(R.id.sign_name)


        init{

            itemView.setOnClickListener {

                listener.onItemClick(absoluteAdapterPosition)
            }

        }
    }
}