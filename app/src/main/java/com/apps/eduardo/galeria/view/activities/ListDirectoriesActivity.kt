package com.apps.eduardo.galeria.view.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import com.apps.eduardo.galeria.R
import com.apps.eduardo.galeria.entities.Directory
import com.apps.eduardo.galeria.view.adapter.directory.DirectoryListAdapter
import com.apps.eduardo.galeria.view.adapter.directory.DirectoryListAdapterListener
import kotlinx.android.synthetic.main.activity_list_directories.directory_list_view as directoryListView

class ListDirectoriesActivity : AppCompatActivity(),DirectoryListAdapterListener {
    companion object {
        val EXTRA_DIRECTORY_LIST = "EXTRA_DIRECTORY_LIST";
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_directories)
        val directoryList = intent.extras.getSerializable(EXTRA_DIRECTORY_LIST) as Array<Directory>
        val directoryListAdapter = DirectoryListAdapter(this, directoryList);
        directoryListAdapter.directoryIActionListener = this;
        directoryListView.adapter = directoryListAdapter
        directoryListView.layoutManager = GridLayoutManager(this,2)
        directoryListView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        directoryListView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
    }

    override fun onDirectorySelected(directory: Directory, position: Int) {
        intent = Intent(this,ListImageActivity::class.java)
        intent.putExtra(ListImageActivity.EXTRA_DIRECTORY,directory)
        startActivity(intent)
    }
}
