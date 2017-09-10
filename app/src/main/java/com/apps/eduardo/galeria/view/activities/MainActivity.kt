package com.apps.eduardo.galeria.view.activities

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.PermissionChecker
import android.support.v7.app.AppCompatActivity
import com.apps.eduardo.galeria.getImages
import kotlinx.android.synthetic.main.activity_list_image.image_list as imageList

class MainActivity : AppCompatActivity() {

    private val REQUEST_PERMISSION_REQUEST_CODE = 0x11;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) == PermissionChecker.PERMISSION_GRANTED) {
            startApplication()
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),REQUEST_PERMISSION_REQUEST_CODE);
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if(requestCode == REQUEST_PERMISSION_REQUEST_CODE){
            startApplication()
        }
    }

    private fun startApplication(){
        val list = getImages()
        val intent = Intent(this, ListDirectoriesActivity::class.java)
        intent.putExtra(ListDirectoriesActivity.EXTRA_DIRECTORY_LIST, list.toTypedArray())
        startActivity(intent)
    }



}
