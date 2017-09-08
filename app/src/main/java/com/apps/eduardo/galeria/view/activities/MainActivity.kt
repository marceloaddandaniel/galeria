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
import com.apps.eduardo.galeria.view.show_image.ViewImageActivity
import java.util.*
import kotlinx.android.synthetic.main.activity_main.image_list as imageList

class MainActivity : AppCompatActivity(),ImageListAdapterListener {

    var items :List<String> = emptyList();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        items = getImages();
        var adapter = ImageListAdapter(this, items);
        adapter.imageIActionListener = this
        imageList.adapter =adapter
        imageList.addItemDecoration( DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        imageList.addItemDecoration( DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL))
        imageList.layoutManager = GridLayoutManager(this, 2);
    }


    override fun onImageClick(image: String,index: Int) {
        var intent = Intent(this, ViewImageActivity::class.java)
//        intent.putExtra(ViewImageActivity.IMAGE_LIST_PATH_EXTRA,)
        intent.putExtra(ViewImageActivity.IMAGE_POSITION_PATH_EXTRA,index)
        startActivity(intent)
    }

    override fun onImageLongClick(image: String,index: Int) {

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
