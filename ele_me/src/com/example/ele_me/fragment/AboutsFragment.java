/**   
 * Copyright © 2014 All rights reserved.
 * 
 * @Title: SlidingPaneContentFragment.java 
 * @Prject: SlidingPane
 * @Package: com.example.slidingpane 
 * @Description: TODO
 * @author: raot  719055805@qq.com
 * @date: 2014年9月5日 上午10:44:01 
 * @version: V1.0   
 */
package com.example.ele_me.fragment;

import com.example.ele_me.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.FrameLayout.LayoutParams;

@SuppressLint("NewApi")
public class AboutsFragment extends Fragment implements OnClickListener{
	private View currentView;
	private LinearLayout openMenu;

	public void setCurrentViewPararms(FrameLayout.LayoutParams layoutParams) {
		currentView.setLayoutParams(layoutParams);
	}

	public FrameLayout.LayoutParams getCurrentViewParams() {
		return (LayoutParams) currentView.getLayoutParams();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		currentView = inflater.inflate(R.layout.slidingpane_abouts_layout,
				container, false);
		openMenu = (LinearLayout)currentView.findViewById(R.id.linear_above_toHome);
		openMenu.setOnClickListener(this);
		return currentView;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case (R.id.linear_above_toHome):
			openMenu.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					final SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) getActivity().findViewById(R.id.slidingpanellayout);
				    if(slidingPaneLayout.isOpen())
				    {
				    	slidingPaneLayout.closePane();
				    }
				    else
				    {
				    	slidingPaneLayout.openPane();
				    }
				}
			});
			
			break;
		}
	}

}
