package com.apps.eduardo.galeria

import android.content.Context
import android.util.Log
import com.apps.eduardo.galeria.entities.Directory
import com.apps.eduardo.galeria.entities.FileType
import com.apps.eduardo.galeria.entities.MediaFile
import java.io.File
import java.security.AccessControlContext
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Eduardo on 02/09/2017.
 */

fun File.isImage(): Boolean{
    var validName = !this.name.startsWith(".") && this.isFile();

    return validName;
}

fun File.lastModifiedDate(): String{
    val lastModified = this.lastModified()
    return SimpleDateFormat("dd/MM/yyyy").format(Date(lastModified));
}


fun getImages():List<Directory> {
    var imagesList = mutableListOf<MediaFile>();
    for( image in Images.getImagesFromCamera()){
        imagesList.add(MediaFile(image, FileType.IMAGE));
        Log.d("image file",image)
    }
    return listOf(Directory("Whatapp Images",imagesList));
}