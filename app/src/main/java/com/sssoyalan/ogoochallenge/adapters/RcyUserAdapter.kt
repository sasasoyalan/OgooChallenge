package com.sssoyalan.ogoochallenge.adapters

import Row
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sssoyalan.ogoochallenge.R

class RcyUserAdapter(private val mList: List<Row>) : RecyclerView.Adapter<RcyUserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]
        holder.username.text= itemsViewModel.RelatedPerson[0].title
        holder.userDate.text = itemsViewModel.Created
        holder.userRating.rating= itemsViewModel.PraiseRating.toFloat()
        holder.userTitle.text = itemsViewModel.Badge[0].lookupValue
        holder.userDesc.text=itemsViewModel.Message

        when (itemsViewModel.Badge[0].lookupId) {
            3 -> holder.userImg.setBackgroundResource(R.drawable.uc)
            4 -> holder.userImg.setBackgroundResource(R.drawable.dort)
            5 -> holder.userImg.setBackgroundResource(R.drawable.bes)
            6 -> holder.userImg.setBackgroundResource(R.drawable.alti)
            7 -> holder.userImg.setBackgroundResource(R.drawable.yedi)
            8 -> holder.userImg.setBackgroundResource(R.drawable.sekiz)
            9 -> holder.userImg.setBackgroundResource(R.drawable.dokuz)
            10 -> holder.userImg.setBackgroundResource(R.drawable.on)
            11 -> holder.userImg.setBackgroundResource(R.drawable.onbir)
            else -> {
                holder.userImg.setBackgroundResource(R.drawable.uc)
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val username: TextView = itemView.findViewById(R.id.userName)
        val userDate: TextView = itemView.findViewById(R.id.userDate)
        val userImg: ImageView = itemView.findViewById(R.id.userImg)
        val userTitle: TextView = itemView.findViewById(R.id.userTitle)
        val userRating: RatingBar = itemView.findViewById(R.id.userRating)
        val userDesc: TextView = itemView.findViewById(R.id.userDesc)
    }
}
