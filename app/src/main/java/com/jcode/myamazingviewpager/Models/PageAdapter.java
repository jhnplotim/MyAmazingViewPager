package com.jcode.myamazingviewpager.Models;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.jcode.myamazingviewpager.Controllers.Fragments.NewsPageFragment;
import com.jcode.myamazingviewpager.Controllers.Fragments.PageFragment;
import com.jcode.myamazingviewpager.Controllers.Fragments.ParamPageFragment;
import com.jcode.myamazingviewpager.Controllers.Fragments.ProfilePageFragment;

/**
 * Created by otimj on 9/6/2019.
 */
//FragmentStatePagerAdapter: This adapter will NOT keep all of the pages displayed in memory (fragments) after they are created.
// Imagine that you're developing an ebook reader app containing 1000 page:: You can't keep them all in memory!
// This adapter will therefore be tasked with creating/deleting them on the fly (it will only keep 3 in memory), thereby optimizing your app's performance.
//
//FragmentPagerAdapter: This adapter will keep in memory all of the pages displayed (fragments) after they are created.
// This will enable greater fluidity when swiping and displaying them, particularly if the user needs to keep coming and going.
// Be careful, however, with the complexity and content of these pages and how many of them there are, to avoid overloading the memory.

//public class PageAdapter extends FragmentStatePagerAdapter {
public class PageAdapter extends FragmentPagerAdapter {

	// 2 - Default Constructor
	public PageAdapter(FragmentManager mgr) {
		super(mgr);
	}

	@Override
	public int getCount() {
		return(3); // 3 - Number of page to show
	}

//	@Override
//	public Fragment getItem(int position) {
//		// 4 - Page to return
//		return(PageFragment.newInstance(position, this.colors[position]));
//	}
//
//	@Nullable
//	@Override
//	public CharSequence getPageTitle(int position) {
//		return "Page "+position;
//	}
@Override
public Fragment getItem(int position) {
	switch (position){
		case 0: //Page number 1
			return NewsPageFragment.newInstance();
		case 1: //Page number 2
			return ProfilePageFragment.newInstance();
		case 2: //Page number 3
			return ParamPageFragment.newInstance();
		default:
			return null;
	}
}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position){
			case 0: //Page number 1
				return "News";
			case 1: //Page number 2
				return "Profile";
			case 2: //Page number 3
				return "Parameter";
			default:
				return null;
		}
	}
}

