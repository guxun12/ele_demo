package com.example.ele_me.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import com.example.ele_me.R;
import com.example.ele_me.fragment.HomeFragment;
import com.example.ele_me.fragment.MenuFragment;
import com.example.ele_me.util.InjectView;
import com.example.ele_me.util.Injector;

public class HomePageActivity extends Activity {
	@InjectView(R.id.slidingpanellayout)
	private SlidingPaneLayout slidingPaneLayout;
	private MenuFragment menuFragment;
	private HomeFragment contentFragment;
	private DisplayMetrics displayMetrics = new DisplayMetrics();
	private int maxMargin = 0;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		setContentView(R.layout.slidingpane_main_layout);
		Injector.get(this).inject();//init views
		menuFragment = new MenuFragment();
		contentFragment = new HomeFragment();
		FragmentTransaction transaction = getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.slidingpane_menu, menuFragment);
		transaction.replace(R.id.slidingpane_content, contentFragment);
		transaction.commit();
		maxMargin = displayMetrics.heightPixels / 10;
		slidingPaneLayout.setPanelSlideListener(new PanelSlideListener() {
			@Override
			public void onPanelSlide(View panel, float slideOffset) {
				// TODO Auto-generated method stub
//				int contentMargin = (int) (slideOffset * maxMargin);
//				FrameLayout.LayoutParams contentParams = contentFragment
//						.getCurrentViewParams();
//				contentParams.setMargins(0, contentMargin, 0, contentMargin);
//				contentFragment.setCurrentViewPararms(contentParams);
//
//				float scale = 1 - ((1 - slideOffset) * maxMargin * 2)
//						/ (float) displayMetrics.heightPixels;
//				Log.e("scale", scale + "sss" + slideOffset + "");
//				menuFragment.getCurrentView().setScaleX(scale);// 设置缩放的基准点
//				menuFragment.getCurrentView().setScaleY(scale);// 设置缩放的基准点
//				menuFragment.getCurrentView().setPivotX(0);// 设置缩放和选择的点
//				menuFragment.getCurrentView().setPivotY(
//						displayMetrics.heightPixels / 2);
//				menuFragment.getCurrentView().setAlpha(slideOffset);
			}

			@Override
			public void onPanelOpened(View panel) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPanelClosed(View panel) {
				// TODO Auto-generated method stub

			}
		});

	}

	/**
	 * @return the slidingPaneLayout
	 */
	public SlidingPaneLayout getSlidingPaneLayout() {
		return slidingPaneLayout;
	}

}
