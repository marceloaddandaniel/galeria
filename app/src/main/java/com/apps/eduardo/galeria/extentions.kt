package com.apps.eduardo.galeria

import android.util.Log
import com.apps.eduardo.core.services.FilesService
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


//TODO busca temporária, depois organizar isso de acordo com uma arquitetura minimanente aceitável
fun getImages():List<Directory> {

    val directoriesAndFiles = FilesService().getAllDirectoriesWithMedia("/storage/emulated/0/")
    val directoryList = mutableListOf<Directory>()
    for(directory in directoriesAndFiles){
        val directoryFile = directory.key;
        val mediaFiles = directory.value;
        var presentableImageList = mutableListOf<MediaFile>();
        for (image in mediaFiles) {
            presentableImageList.add(MediaFile(image.absolutePath, FileType.IMAGE));
        }
        presentableImageList.sortByDescending { it.asFile().lastModified() }

        val presentableDirectory = Directory(directoryFile.absolutePath, presentableImageList);
        directoryList.add(presentableDirectory)
    }

    directoryList.sortBy { it.name }
    return directoryList;
}