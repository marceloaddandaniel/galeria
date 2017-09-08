package com.apps.eduardo.galeria.view.show_image

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Eduardo on 08/09/2017.
 */
class ScreenSlidePagerAdapter(fragmentManager: FragmentManager, val imageList:List<String>) : FragmentStatePagerAdapter(fragmentManager){

    override fun getItem(position: Int): Fragment {
        return ShowImageFragment.newInstance(imageList[position])
    }

    override fun getCount(): Int {
        return imageList.size;
    }

}
