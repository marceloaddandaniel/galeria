package com.apps.eduardo.galeria.entities

/**
 * Created by Eduardo on 08/09/2017.
 */
data class MediaFile(var name:String,var type:FILE_TYPE){

}

enum class FILE_TYPE{
    IMAGE,
    VIDEO
}