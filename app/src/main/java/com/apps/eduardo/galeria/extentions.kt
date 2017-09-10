package com.apps.eduardo.galeria

import android.util.Log
import com.apps.eduardo.galeria.entities.Directory
import com.apps.eduardo.galeria.entities.FileType
import com.apps.eduardo.galeria.entities.MediaFile
import java.io.File
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
    val directories = arrayOf(
            "/storage/emulated/0/WhatsApp/Media/WhatsApp Images",
            "/storage/emulated/0/Pictures/Messenger/",
            "/storage/emulated/0/Pictures/Screenshots/",
            "/storage/emulated/0/DCIM/Camera/",
            "/storage/emulated/0/DCIM/Facebook/")
    val directoryList = mutableListOf<Directory>()

    for(directoryPath in directories) {
        try {
            var imagesList = mutableListOf<MediaFile>();
            for (image in Images.getImagesFromCamera(directoryPath)) {
                imagesList.add(MediaFile(image, FileType.IMAGE));
                Log.d("cover file", image)
            }
            val directory = Directory(directoryPath, imagesList);
            directoryList.add(directory)
        }catch (exception : Exception){
            exception.printStackTrace()
        }
    }
    return directoryList;
}