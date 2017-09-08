package com.apps.eduardo.galeria.view.adapter.image

/**
 * Created by Eduardo on 02/09/2017.
 */
interface ImageListAdapterListener {

    fun onImageClick(image : String,index: Int)

    fun onImageLongClick(image: String,index: Int)
}