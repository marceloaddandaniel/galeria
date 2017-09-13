package com.apps.eduardo.core.utils

import android.webkit.MimeTypeMap
import java.io.File

/**
 * Created by Eduardo on 12/09/2017.
 */
fun File.isMediaFile(): Boolean{
    var type: String? = null
    val extension = MimeTypeMap.getFileExtensionFromUrl(this.absolutePath)
    if (extension != null) {
        type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
    }
    return type?.startsWith("image")?:false
}