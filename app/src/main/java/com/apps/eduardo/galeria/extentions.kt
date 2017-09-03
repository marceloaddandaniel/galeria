package com.apps.eduardo.galeria

import java.io.File
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Eduardo on 02/09/2017.
 */

fun File.isImage(): Boolean{
    var validName = !this?.name.startsWith(".") && this.isFile();

    return validName;
}

fun File.lastModifiedDate(): String{
    val lastModified = this.lastModified()
    return SimpleDateFormat("dd/MM/yyyy").format(Date(lastModified));
}