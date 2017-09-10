package com.apps.eduardo.galeria.view.adapter.directory

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.apps.eduardo.galeria.R
import com.apps.eduardo.galeria.entities.Directory
import com.apps.eduardo.galeria.lastModifiedDate
import com.bumptech.glide.Glide

/**
 * Created by Eduardo on 09/09/2017.
 */
class DirectoryListAdapter (private val context: Context, private var directoryList : Array<Directory>) : RecyclerView.Adapter<DirectoryListAdapter.ViewHolder>() {

    var i = 0;
    var directoryIActionListener: DirectoryListAdapterListener? = null

    class ViewHolder : RecyclerView.ViewHolder {
        var view: View
        var cover: ImageView
        var directoryName: TextView
        var directoryItemCount: TextView

        constructor(view: View) : super(view) {
            this.view = view;
            this.cover = view.findViewById(R.id.cover) as ImageView
            this.directoryName = view.findViewById(R.id.directory_name) as TextView
            this.directoryItemCount = view.findViewById(R.id.directory_item_count) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val imageItemView = LayoutInflater.from(context).inflate(R.layout.directory_list_view, null, false);
        return ViewHolder(imageItemView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val directory = directoryList[position];
        val coverImage = directory.getFile(0);
        val coverFile = coverImage.asFile();

        Glide.with(context)
                .load(coverFile)
                .error(R.mipmap.ic_launcher_rounded)
                .centerCrop()
                .into(holder?.cover)

        holder?.directoryName?.text = directory.name;
        holder?.directoryItemCount?.text = directory.getDirectoryFilesCount().toString();

        holder?.cover?.setOnClickListener {
            directoryIActionListener?.onDirectorySelected(directory,position)
        }
    }

    override fun getItemCount(): Int {
        return directoryList.size
    }
}