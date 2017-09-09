package com.apps.eduardo.galeria.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.apps.eduardo.galeria.view.adapter.image.ImageListAdapter
import com.apps.eduardo.galeria.Images
import com.apps.eduardo.galeria.R
import com.apps.eduardo.galeria.entities.Directory
import com.apps.eduardo.galeria.entities.FileType
import com.apps.eduardo.galeria.entities.MediaFile
import com.apps.eduardo.galeria.getImages
import com.apps.eduardo.galeria.view.adapter.image.ImageListAdapterListener
import com.apps.eduardo.galeria.view.show_image.ViewImageActivity
import java.util.*
import kotlinx.android.synthetic.main.activity_main.image_list as imageList

class MainActivity : AppCompatActivity(),ImageListAdapterListener {

    var items :List<Directory> = emptyList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        items = getImages();
        var adapter = ImageListAdapter(this, items[0]);
        adapter.imageIActionListener = this
        imageList.adapter =adapter
        imageList.addItemDecoration( DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        imageList.addItemDecoration( DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL))
        imageList.layoutManager = GridLayoutManager(this, 2);
    }


    override fun onImageClick(image: MediaFile,index: Int) {
        var intent = Intent(this, ViewImageActivity::class.java)
        intent.putExtra(ViewImageActivity.IMAGE_LIST_PATH_EXTRA,items[0])
        intent.putExtra(ViewImageActivity.IMAGE_POSITION_PATH_EXTRA,index)
        startActivity(intent)
    }

    override fun onImageLongClick(image: MediaFile,index: Int) {

    }



}
