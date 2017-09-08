package com.apps.eduardo.galeria.view.show_image

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.apps.eduardo.galeria.Images
import com.apps.eduardo.galeria.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_view_image.*
import kotlinx.android.synthetic.main.fragment_view_image.*


class ViewImageActivity : AppCompatActivity() {

    companion object {
        val IMAGE_LIST_PATH_EXTRA = "galeria.view.activities.ViewImageActivity.IMAGE_LIST_PATH_EXTRA";
        val IMAGE_POSITION_PATH_EXTRA = "galeria.view.activities.ViewImageActivity.IMAGE_POSITION_PATH_EXTRA";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image)
        val selectedImagePosition = intent.extras.getInt(IMAGE_POSITION_PATH_EXTRA)
        val imagesList = getImages();
        pager.adapter = ScreenSlidePagerAdapter(imageList = imagesList,fragmentManager = supportFragmentManager)
        pager.currentItem = selectedImagePosition;

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


