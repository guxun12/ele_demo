package com.example.ele_me.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ele_me.R;
import com.example.ele_me.adapter.RestaurantDetailAdapter;
import com.example.ele_me.util.InjectView;
import com.example.ele_me.util.Injector;
import com.example.ele_me.widget.stickylistheaders.StickyListHeadersListView;

/**
 * @author Emil Sjölander
 */
public class RestaurantDetailActivity extends Activity implements
		AdapterView.OnItemClickListener,
		StickyListHeadersListView.OnHeaderClickListener,
		StickyListHeadersListView.OnStickyHeaderOffsetChangedListener,
		StickyListHeadersListView.OnStickyHeaderChangedListener {

	private RestaurantDetailAdapter mAdapter;
	private boolean fadeHeader = true;
	@InjectView(R.id.linear_above_toHome)
	private LinearLayout above_toHome;
	@InjectView(R.id.tv_common_above_head)
	private TextView above_tittle;
	@InjectView(R.id.iv_head_left)
	private ImageView head_left;
	@InjectView(R.id.tv_common_above_head)
	private TextView head_tittle;
	@InjectView(R.id.food_list_shipping_fee)
	private TextView order_cart;
	
	private String restaurant_name;
	

	
	

	private StickyListHeadersListView stickyList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.restaurant_detail_main);
		Injector.get(this).inject();//init views
		Intent intent = getIntent();
		restaurant_name = intent.getStringExtra("name");
		initView();
		setListener();
		
	}

	private void initView() {
		above_tittle.setText(restaurant_name);
		head_left.setImageResource(R.drawable.abc_ic_ab_back_holo_dark);
		
	}
	
	private void setListener() {
		// TODO Auto-generated method stub
		above_toHome.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				finish();
				
			}
		});
		
		mAdapter = new RestaurantDetailAdapter(this,order_cart);

		stickyList = (StickyListHeadersListView) findViewById(R.id.list_restaurant_detail);
		stickyList.setOnItemClickListener(this);
		stickyList.setOnHeaderClickListener(this);
		stickyList.setOnStickyHeaderChangedListener(this);
		stickyList.setOnStickyHeaderOffsetChangedListener(this);
		stickyList.addHeaderView(getLayoutInflater().inflate(
				R.layout.restaurant_list_header, null));
//		stickyList.addFooterView(getLayoutInflater().inflate(
//				R.layout.restaurant_list_footer, null));
		stickyList.setDrawingListUnderStickyHeader(true);
		stickyList.setAreHeadersSticky(true);
		stickyList.setAdapter(mAdapter);

//		stickyList.setStickyHeaderTopOffset(-20);
		
	}

	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(this, "Item " + position + " clicked!",
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onHeaderClick(StickyListHeadersListView l, View header,
			int itemPosition, long headerId, boolean currentlySticky) {
		Toast.makeText(this,
				"Header " + headerId + " currentlySticky ? " + currentlySticky,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void onStickyHeaderOffsetChanged(StickyListHeadersListView l,
			View header, int offset) {
		if (fadeHeader
				&& Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			header.setAlpha(1 - (offset / (float) header.getMeasuredHeight()));
		}
	}

	@Override
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void onStickyHeaderChanged(StickyListHeadersListView l, View header,
			int itemPosition, long headerId) {
		header.setAlpha(1);
	}

}