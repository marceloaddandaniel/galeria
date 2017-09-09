package com.apps.eduardo.galeria.view.adapter.image

import com.apps.eduardo.galeria.entities.MediaFile

/**
 * Created by Eduardo on 02/09/2017.
 */
interface ImageListAdapterListener {

    fun onImageClick(file : MediaFile,index: Int)

    fun onImageLongClick(file : MediaFile,index: Int)
}