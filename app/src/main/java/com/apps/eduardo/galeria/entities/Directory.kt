package com.apps.eduardo.galeria.entities

import java.io.File
import java.io.Serializable
import java.text.FieldPosition

/**
 * Created by Eduardo on 08/09/2017.
 */
data class Directory(private var path: String,private var files:List<MediaFile>) : Serializable {

    fun getDirectoryFilesCount():Int{
        return  files.size;
    }

    fun getFile(position: Int):MediaFile{
        return files[position];
    }
}