package com.apps.eduardo.galeria.view.adapter.image

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.apps.eduardo.galeria.R
import com.apps.eduardo.galeria.lastModifiedDate
import com.bumptech.glide.Glide
import java.io.File

/**
 * Created by Eduardo on 02/09/2017.
 */
class ImageListAdapter(val context: Context, var items: List<String>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    var i = 0;
    var imageIActionListener: ImageListAdapterListener? = null

    class ViewHolder : RecyclerView.ViewHolder {
        var view: View
        var image: ImageView
        var imageDate: TextView

        constructor(view: View) : super(view) {
            this.view = view;
            this.image = view.findViewById(R.id.image) as ImageView
            this.imageDate = view.findViewById(R.id.image_date) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val imageItemView = LayoutInflater.from(context).inflate(R.layout.image_list_view, null, false);
        return ViewHolder(imageItemView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val imagePath = items.get(position);
        val imageFile = File(imagePath);

        Glide.with(context)
                .load(imageFile)
                .error(R.mipmap.ic_launcher_rounded)
                .centerCrop()
                .into(holder?.image)

        holder?.imageDate?.text = imageFile.lastModifiedDate();

        holder?.image?.setOnClickListener {
            imageIActionListener?.onImageClick(imagePath,position)
        }
        holder?.image?.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                imageIActionListener?.onImageLongClick(imagePath,position)
                return true;
            }
        })


    }

    override fun getItemCount(): Int {
        return items.size;
    }

}