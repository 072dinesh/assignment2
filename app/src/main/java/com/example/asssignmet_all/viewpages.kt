package com.example.asssignmet_all

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class viewpages(fragmentsupp: FragmentManager): FragmentPagerAdapter(fragmentsupp){

    var fragmentlist = ArrayList<Fragment>()
    var titlelist = ArrayList<String>()


    override fun getCount(): Int {
        return fragmentlist.size
    }

    override fun getItem(position:Int):Fragment{
        return fragmentlist[position]
    }

    fun addfragment(fragment:Fragment,title:String)
    {
        fragmentlist.add(fragment)
        titlelist.add(title)
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return titlelist[position]
    }
}