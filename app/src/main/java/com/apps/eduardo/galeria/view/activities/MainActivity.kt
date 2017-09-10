package com.apps.eduardo.galeria.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.apps.eduardo.galeria.entities.Directory
import com.apps.eduardo.galeria.getImages
import java.util.*
import kotlinx.android.synthetic.main.activity_list_image.image_list as imageList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = getImages()
        val intent = Intent(this,ListDirectoriesActivity::class.java)
        intent.putExtra(ListDirectoriesActivity.EXTRA_DIRECTORY_LIST, list.toTypedArray())
        startActivity(intent)
    }

}
