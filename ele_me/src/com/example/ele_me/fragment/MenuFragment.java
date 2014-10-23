/**   
 * Copyright © 2014 All rights reserved.
 * 
 * @Title: SlidingPaneMenuFragment.java 
 * @Prject: SlidingPane
 * @Package: com.example.slidingpane 
 * @Description: TODO
 * @author: raot  719055805@qq.com
 * @date: 2014年9月5日 上午10:42:07 
 * @version: V1.0   
 */
package com.example.ele_me.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ele_me.R;
import com.example.ele_me.activity.HomePageActivity;
import com.example.ele_me.activity.LoginActivity;

@SuppressLint("NewApi")
public class MenuFragment extends Fragment implements View.OnClickListener {

	private View currentView;
	private ImageView iv_login;
	private Button bt_abouts, bt_gift, bt_home, bt_invitation, bt_orders, bt6;

	public View getCurrentView() {
		return currentView;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		currentView = inflater.inflate(R.layout.slidingpane_menu_layout,
				container, false);
		bt_abouts = (Button) currentView.findViewById(R.id.btn_abouts);
		bt_gift = (Button) currentView.findViewById(R.id.btn_gift);
		bt_home = (Button) currentView.findViewById(R.id.btn_home);
		bt_invitation = (Button) currentView.findViewById(R.id.btn_invitation);
		iv_login = (ImageView) currentView.findViewById(R.id.iv_login);
		bt_orders = (Button) currentView.findViewById(R.id.btn_order);
		bt_abouts.setOnClickListener(this);
		bt_gift.setOnClickListener(this);
		bt_home.setOnClickListener(this);
		bt_invitation.setOnClickListener(this);
		bt_orders.setOnClickListener(this);
		iv_login.setOnClickListener(this);
		return currentView;
	}

	@SuppressLint("CommitTransaction")
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		FragmentTransaction ft = getFragmentManager().beginTransaction();// 开始一个事物
		switch (v.getId()) {
		case R.id.btn_home:
			Fragment homeFragment = new HomeFragment();
			ft.replace(R.id.slidingpane_content, homeFragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			break;
		case R.id.btn_order:
			Fragment orderFragment = new OrderFragment();
			ft.replace(R.id.slidingpane_content, orderFragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			break;
		case R.id.btn_gift:
			Fragment giftFragment = new GiftsFragment();
			ft.replace(R.id.slidingpane_content, giftFragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			break;
		case R.id.btn_invitation:
			Fragment invitationFragment = new InvitationsFragment();
			ft.replace(R.id.slidingpane_content, invitationFragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			break;
		case R.id.btn_abouts:
			Fragment aboutsFragment = new AboutsFragment();
			ft.replace(R.id.slidingpane_content, aboutsFragment);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			break;
		case R.id.iv_login:
			Intent intent = new Intent(getActivity(),
					LoginActivity.class);
			startActivity(intent);
			break;
		}
		((HomePageActivity) getActivity()).getSlidingPaneLayout().closePane();
	}
}
