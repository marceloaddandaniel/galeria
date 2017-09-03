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
import com.apps.eduardo.galeria.view.adapter.image.ImageListAdapterListener
import kotlinx.android.synthetic.main.activity_main.image_list as imageList

class MainActivity : AppCompatActivity(),ImageListAdapterListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = getImages();
        var adapter = ImageListAdapter(this, items);
        adapter.imageIActionListener = this
        imageList.adapter =adapter
        imageList.addItemDecoration( DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        imageList.addItemDecoration( DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL))
        imageList.layoutManager = GridLayoutManager(this, 2);
    }


    override fun onImageClick(image: String) {
        var intent = Intent(this,ViewImageActivity::class.java);
        intent.putExtra(ViewImageActivity.IMAGE_PATH_EXTRA,image);
        startActivity(intent)
    }

    override fun onImageLongClick(image: String) {

    }


    fun getImages():List<String> {
        var imagesList = mutableListOf<String>();
        for( image in Images.getImagesFromCamera(this)){
            imagesList.add(image)
            Log.d("image file",image)
        }
        return imagesList;
    }
}
