package com.sssoyalan.ogoochallenge.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
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
import com.sssoyalan.ogoochallenge.models.BadgeModel
import com.sssoyalan.ogoochallenge.models.Value


class RcyBadgeAdapter(private val mList: List<Value> , private val badgesList: List<BadgeModel>, private val  context: Context) : RecyclerView.Adapter<RcyBadgeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val valueModel = mList[position]
        holder.badgeTitle.text= valueModel.Title

        /*
           Burada image ler png olarak elimizde olduğu için bu şekilde drawable üzerinden kullanıldı.Normal şartlarda
           apiden gelen image url si Glide kütühanesi ile ait olduğu modelden id sine göre ImageView'ına setlenebilir.
        */
        for(i in 0 until badgesList.size-1){
            if (badgesList.get(i).id==valueModel.ID){
                val imageName = "img_"+valueModel.ID
                val imageResource = context.resources.getIdentifier(imageName, "drawable", context.packageName)
                holder.badgeImg.setBackgroundResource(imageResource)
                holder.badgeCount.text= badgesList.get(i).count.toString()+" Adet"
                holder.badgeRating.rating= badgesList.get(i).avarage
                break
            }
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
