package com.apps.eduardo.galeria.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import com.apps.eduardo.galeria.R
import com.apps.eduardo.galeria.entities.Directory
import com.apps.eduardo.galeria.entities.MediaFile
import com.apps.eduardo.galeria.view.adapter.image.ImageListAdapter
import com.apps.eduardo.galeria.view.adapter.image.ImageListAdapterListener
import com.apps.eduardo.galeria.view.adapter.show_image.ViewImageActivity
import kotlinx.android.synthetic.main.activity_list_image.image_list as imageList

class ListImageActivity : AppCompatActivity(), ImageListAdapterListener {

    var directory: Directory? =null

    companion object {
        val EXTRA_DIRECTORY = "EXTRA_DIRECTORY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_image)
        directory = intent.extras.getSerializable(EXTRA_DIRECTORY) as Directory
        if(directory != null) {
            var adapter = ImageListAdapter(this, directory!!);
            adapter.imageIActionListener = this
            imageList.adapter = adapter
            imageList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            imageList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
            imageList.layoutManager = GridLayoutManager(this, 2);
        }
    }


    override fun onImageClick(image: MediaFile, index: Int) {
        var intent = Intent(this, ViewImageActivity::class.java)
        intent.putExtra(ViewImageActivity.IMAGE_LIST_PATH_EXTRA,directory)
        intent.putExtra(ViewImageActivity.IMAGE_POSITION_PATH_EXTRA,index)
        startActivity(intent)
    }

    override fun onImageLongClick(image: MediaFile,index: Int) {

    }
}
