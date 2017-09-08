package com.apps.eduardo.galeria.view.show_image

import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.apps.eduardo.galeria.Images
import com.apps.eduardo.galeria.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_view_image.*

/**
 * Created by Eduardo on 08/09/2017.
 */
class ShowImageFragment : Fragment() {

    companion object {
        val IMAGE_PATH_KEY = "IMAGE_PATH"
        fun newInstance(imagePath:String): ShowImageFragment{
            val fragment = ShowImageFragment()
            fragment.arguments = Bundle();
            fragment.arguments .putString("IMAGE_PATH",imagePath);
            return fragment;
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
       return inflater!!.inflate(R.layout.fragment_view_image,null,false);
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imagePath = arguments.getString(IMAGE_PATH_KEY)
        if (imagePath != null) {
            Glide.with(this)
                    .load(imagePath)
                    .error(R.mipmap.ic_launcher_rounded)
                    .fitCenter()
                    .into(image)
        }
    }
}