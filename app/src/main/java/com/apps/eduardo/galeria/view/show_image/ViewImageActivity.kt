package com.apps.eduardo.galeria.view.show_image

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.apps.eduardo.galeria.R
import com.apps.eduardo.galeria.entities.Directory
import kotlinx.android.synthetic.main.activity_view_image.*


class ViewImageActivity : AppCompatActivity() {

    companion object {
        val IMAGE_LIST_PATH_EXTRA = "galeria.view.activities.ViewImageActivity.IMAGE_LIST_PATH_EXTRA";
        val IMAGE_POSITION_PATH_EXTRA = "galeria.view.activities.ViewImageActivity.IMAGE_POSITION_PATH_EXTRA";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image)
        val selectedImagePosition = intent.extras.getInt(IMAGE_POSITION_PATH_EXTRA)
        val directory = intent.extras.getSerializable(IMAGE_LIST_PATH_EXTRA) as Directory
        pager.adapter = ScreenSlidePagerAdapter(directory = directory ,fragmentManager = supportFragmentManager)
        pager.currentItem = selectedImagePosition;

    }

}


