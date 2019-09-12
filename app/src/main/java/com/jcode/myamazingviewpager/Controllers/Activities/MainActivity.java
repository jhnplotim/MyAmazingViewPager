package com.jcode.myamazingviewpager.Controllers.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jcode.myamazingviewpager.Controllers.Fragments.PageFragment.OnFragmentInteractionListener;
import com.jcode.myamazingviewpager.Models.PageAdapter;
import com.jcode.myamazingviewpager.R;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//3 - Configure ViewPager & Tabs
		this.configureViewPagerAndTabs();
	}

	private void configureViewPagerAndTabs(){
		// 1 - Get ViewPager from layout
		ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
		// 2 - Set Adapter PageAdapter and glue it together
		pager.setAdapter(new PageAdapter(getSupportFragmentManager()) {
		});

		// 1 - Get TabLayout from layout
		TabLayout tabs= (TabLayout)findViewById(R.id.activity_main_tabs);
		// 2 - Glue TabLayout and ViewPager together
		tabs.setupWithViewPager(pager);
		// 3 - Design purpose. Tabs have the same width
		tabs.setTabMode(TabLayout.MODE_FIXED);
	}

	@Override
	public void onFragmentInteraction(Uri uri) {
		//TODO Add something here
	}
}
