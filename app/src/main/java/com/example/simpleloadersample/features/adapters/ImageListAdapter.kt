package com.example.simpleloadersample.features.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleloadersample.R
import com.example.simpleloadersample.model.ImageModel
import com.example.simpleloader.SimpleLoader
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_image.*

class ImageListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<ImageModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_image,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageViewHolder).onBind(list[position])
    }

    fun updateData(list: List<ImageModel>) {
        this.list.clear()
        this.list.addAll(list)

        notifyDataSetChanged()
    }

    inner class ImageViewHolder(override val containerView: View?) :
        RecyclerView.ViewHolder(containerView!!), LayoutContainer {
        fun onBind(imageModel: ImageModel) {
            tvTitle.text = imageModel.getId()
            SimpleLoader.with(context).get(imageModel.getUrl()).into(ivImage)
        }
    }

}
