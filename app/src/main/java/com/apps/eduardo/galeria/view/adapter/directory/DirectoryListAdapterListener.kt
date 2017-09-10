package com.apps.eduardo.galeria.view.adapter.directory

import com.apps.eduardo.galeria.entities.Directory
import java.text.FieldPosition

/**
 * Created by Eduardo on 09/09/2017.
 */
interface DirectoryListAdapterListener {
    fun onDirectorySelected(directory: Directory, position: Int);
}