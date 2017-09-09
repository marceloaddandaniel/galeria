package com.apps.eduardo.galeria.entities

import java.io.File
import java.io.Serializable

/**
 * Created by Eduardo on 08/09/2017.
 */
data class MediaFile(var path:String,var type:FileType) : Serializable{

    fun asFile():File{
        return File(path);
    }
}

