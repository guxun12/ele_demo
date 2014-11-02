package com.example.ele_me.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ele_me.R;
import com.example.ele_me.activity.CameraActivity;
import com.example.ele_me.activity.GalleryActivity;

@SuppressLint("NewApi")
public class CameraFragment extends Fragment implements OnClickListener {
	private View currentView;
	private LinearLayout openMenu;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		currentView = inflater.inflate(R.layout.slidingpane_camera_layout,
				container, false);
		openMenu = (LinearLayout) currentView
				.findViewById(R.id.linear_above_toHome);
		openMenu.setOnClickListener(this);
		currentView.findViewById(R.id.btn_camera_gallery).setOnClickListener(
				this);
		currentView.findViewById(R.id.btn_camera_camera).setOnClickListener(
				this);
		return currentView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case (R.id.linear_above_toHome):
			openMenu.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					final SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) getActivity()
							.findViewById(R.id.slidingpanellayout);
					if (slidingPaneLayout.isOpen()) {
						slidingPaneLayout.closePane();
					} else {
						slidingPaneLayout.openPane();
					}
				}
			});

			break;
		case R.id.btn_camera_gallery:
			startActivity(GalleryActivity.class);
			break;
		case R.id.btn_camera_camera:
			startActivity(CameraActivity.class);
			break;
		 default:
             break;

		}

	}
	private void startActivity(final Class<?> activityClass) {
		getActivity().startActivity(new Intent(getActivity(), activityClass));
	}
}
