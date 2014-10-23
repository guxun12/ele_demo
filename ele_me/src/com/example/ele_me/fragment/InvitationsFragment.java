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

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ele_me.R;
import com.example.ele_me.activity.LoginActivity;

@SuppressLint("NewApi")
public class InvitationsFragment extends Fragment implements OnClickListener {
	private View currentView;
	private LinearLayout openMenu;
	private WebView mWebView;
	private LinearLayout above_toHome;
	private ProgressDialog pd;
	private TextView above_tittle;

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
		currentView = inflater.inflate(R.layout.slidingpane_invitation_layout,
				container, false);
		mWebView = (WebView) currentView.findViewById(R.id.webview_common);
		above_tittle = (TextView) currentView
				.findViewById(R.id.tv_common_above_head);
		openMenu = (LinearLayout) currentView
				.findViewById(R.id.linear_above_toHome);
		pd = new ProgressDialog(getActivity());// 进度条
		openMenu.setOnClickListener(this);
		initView();
		return currentView;
	}

	@SuppressLint("JavascriptInterface")
	private void initView() {
		above_tittle.setText("邀请好友");
		mWebView.loadUrl("http://m2.ele.me/app/invitation");
		mWebView.requestFocus();
		mWebView.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				pd.setMessage("正在加载" + progress + "%");
			}
		});
		mWebView.setWebViewClient(new MyWebViewClient());
		

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
		}
	}

	public class MyWebViewClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// 设置点击网页里面的链接还是在当前的webview里跳转
			view.loadUrl(url);
			return true;
		}

		// 设置页面加载前的事件
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			super.onPageStarted(view, url, favicon);
			pd.show();
		}

		// 设置页面加载后的事件
		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onPageFinished(view, url);
			// pd.cancel();
			pd.dismiss();
		}

		public void onReceivedError(WebView view, int errorCode,
				String description, String failingUrl) {
			// 加载页面报错时的处理
			Toast.makeText(getActivity(), "Oh no! " + description,
					Toast.LENGTH_SHORT).show();
		}

	}
}
