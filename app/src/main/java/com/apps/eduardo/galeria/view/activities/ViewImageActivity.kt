package com.apps.eduardo.galeria.view.activities

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.apps.eduardo.galeria.R
import com.bumptech.glide.Glide
import com.github.piasy.biv.BigImageViewer
import com.github.piasy.biv.loader.glide.GlideImageLoader
import kotlinx.android.synthetic.main.activity_view_image.*
import java.io.File


class ViewImageActivity : AppCompatActivity() {

    companion object {
        val IMAGE_PATH_EXTRA = "galeria.view.activities.ViewImageActivity.EXTRA_IMAGE";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image)
        val imagePath = intent.extras.getString(IMAGE_PATH_EXTRA);

        if (imagePath != null) {
            image.showImage(Uri.fromFile(File(imagePath)));
        }
    }
}
