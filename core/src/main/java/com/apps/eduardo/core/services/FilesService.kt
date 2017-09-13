package com.apps.eduardo.core.services

import android.webkit.MimeTypeMap
import com.apps.eduardo.core.utils.isMediaFile
import java.io.File
import java.lang.Exception
import java.util.*

/**
 * Created by Eduardo on 12/09/2017.
 */
class FilesService {

    fun getAllMediaFiles(directoryPath: String):List<File>{
        val directory = File(directoryPath);
        val directoriesWithMedia = mutableListOf<File>()
        try{
            for(file in directory.listFiles()){
                if( !file.isHidden) {
                    if (file.isDirectory) {
                        directoriesWithMedia.addAll(getAllMediaFiles(file.absolutePath));
                    } else {
                        if (file.isMediaFile()) {
                            directoriesWithMedia.add(file);
                        }
                    }
                }
            }
        }catch (exception : Exception){
            exception.printStackTrace();
        }
        return directoriesWithMedia
    }

    fun getAllDirectoriesWithMedia(directoryPath: String):Map<File,List<File>>{
        val directoriesAndFiles = mutableMapOf<File,List<File>>()
        val allMediaFiles = getAllMediaFiles(directoryPath);

        for(mediaFile in allMediaFiles){
            var fileList = directoriesAndFiles.get(mediaFile.parentFile) as MutableList<File> ?
            if(fileList == null){
                fileList = mutableListOf<File>();
                directoriesAndFiles.put(mediaFile.parentFile,fileList)
            }
            fileList.add(mediaFile);
        }
        return directoriesAndFiles;
    }

}