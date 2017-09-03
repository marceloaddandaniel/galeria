package com.apps.eduardo.galeria

import android.app.Application
import com.github.piasy.biv.BigImageViewer
import com.github.piasy.biv.loader.glide.GlideImageLoader

/**
 * Created by Eduardo on 03/09/2017.
 */
class SuperApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BigImageViewer.initialize(GlideImageLoader.with(this));
    }
}