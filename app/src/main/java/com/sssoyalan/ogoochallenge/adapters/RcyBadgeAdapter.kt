package com.sssoyalan.ogoochallenge.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sssoyalan.ogoochallenge.R
import com.sssoyalan.ogoochallenge.models.BadgesAndValues
import com.sssoyalan.ogoochallenge.models.BadgesCount
import com.sssoyalan.ogoochallenge.models.Value

class RcyBadgeAdapter(private val mList: List<Value> , private val badgesCount: BadgesCount) : RecyclerView.Adapter<RcyBadgeAdapter.ViewHolder>() {

    private val x = 0
    private val differCallBack = object : DiffUtil.ItemCallback<Value>() {
        override fun areItemsTheSame(oldItem: Value, newItem: Value): Boolean {
            return oldItem.ID == newItem.ID
        }
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Value, newItem: Value): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val valueModel = mList[position]

        holder.badgeTitle.text= valueModel.Title

        when (valueModel.ID) {
            3 -> {holder.badgeImg.setBackgroundResource(R.drawable.uc)
                holder.badgeCount.text= badgesCount.badge3.count.toString()+" Adet"
                holder.badgeRating.rating= badgesCount.badge3.avarage }
            4 -> {holder.badgeImg.setBackgroundResource(R.drawable.dort)
                holder.badgeCount.text= badgesCount.badge4.count.toString()+" Adet"
                holder.badgeRating.rating= badgesCount.badge4.avarage }
            5 -> {holder.badgeImg.setBackgroundResource(R.drawable.bes)
                holder.badgeCount.text=badgesCount.badge5.count.toString()+" Adet"
                holder.badgeRating.rating= badgesCount.badge5.avarage}
            6 -> {holder.badgeImg.setBackgroundResource(R.drawable.alti)
                holder.badgeCount.text=badgesCount.badge6.count.toString()+" Adet"
                holder.badgeRating.rating= badgesCount.badge6.avarage}
            7 -> {holder.badgeImg.setBackgroundResource(R.drawable.yedi)
                holder.badgeCount.text=badgesCount.badge7.count.toString()+" Adet"
                holder.badgeRating.rating= badgesCount.badge7.avarage}
            8 -> {holder.badgeImg.setBackgroundResource(R.drawable.sekiz)
                holder.badgeCount.text=badgesCount.badge8.count.toString()+" Adet"
                holder.badgeRating.rating= badgesCount.badge8.avarage}
            9 -> {holder.badgeImg.setBackgroundResource(R.drawable.dokuz)
                holder.badgeCount.text=badgesCount.badge9.count.toString()+" Adet"
                holder.badgeRating.rating= badgesCount.badge9.avarage}
            10 -> {holder.badgeImg.setBackgroundResource(R.drawable.on)
                holder.badgeCount.text=badgesCount.badge10.count.toString()+" Adet"
                holder.badgeRating.rating= badgesCount.badge10.avarage}
            11 -> {holder.badgeImg.setBackgroundResource(R.drawable.onbir)
                holder.badgeCount.text=badgesCount.badge11.count.toString()+" Adet"
                holder.badgeRating.rating= badgesCount.badge11.avarage}
        }





    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val badgeImg: ImageView = itemView.findViewById(R.id.img_recyc)
        val badgeTitle: TextView = itemView.findViewById(R.id.cardv_title_item1)
        val badgeRating : RatingBar = itemView.findViewById(R.id.cv_rtbar)
        val badgeCount : TextView = itemView.findViewById(R.id.cardv_adet_item1)
    }
}
