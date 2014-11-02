
package com.example.ele_me.fragment;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.ele_me.R;
import com.example.ele_me.adapter.OrderTimeLineAdapter;
import com.example.ele_me.entity.OrderTimeLineEntity;
import com.example.ele_me.util.SharedPreferencesUtil;

@SuppressLint("NewApi")
public class OrderFragment extends Fragment implements OnClickListener{
	private View currentView;
	private ListView timeLineListView;
	private LinearLayout openMenu;
	private LinearLayout errorNoOrder;//无订单
	private LinearLayout orderTimeLine;//时间轴
	private SharedPreferencesUtil SPUtil;
	private OrderTimeLineAdapter timeLineAdapter;
	private List<OrderTimeLineEntity> timeLineList;

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
		currentView = inflater.inflate(R.layout.slidingpane_order_layout,
				container, false);
		openMenu = (LinearLayout)currentView.findViewById(R.id.linear_above_toHome);
		SPUtil = new SharedPreferencesUtil(getActivity(), "SharedPreferences");
		getDate();
		initView();
		openMenu.setOnClickListener(this);
		return currentView;
	}

	private void getDate() {
		// TODO Auto-generated method stub
		timeLineList = new ArrayList<OrderTimeLineEntity>();
		OrderTimeLineEntity orderEntity1= new OrderTimeLineEntity();
		orderEntity1.setMsg("下单成功");
		orderEntity1.setTime("10:20");
		orderEntity1.setLogo("drawable://" + R.drawable.ali_head);
		timeLineList.add(orderEntity1);
		orderEntity1=null;
		
		OrderTimeLineEntity orderEntity2= new OrderTimeLineEntity();
		orderEntity2.setMsg("餐厅已确认");
		orderEntity2.setTime("10:30");
		orderEntity2.setLogo("drawable://" + R.drawable.pic_jigongbao);
		timeLineList.add(orderEntity2);
		orderEntity1=null;
		
		OrderTimeLineEntity orderEntity3= new OrderTimeLineEntity();
		orderEntity3.setMsg("确认送达");
		orderEntity3.setTime("10:40");
		orderEntity3.setLogo("drawable://" + R.drawable.ali_head);
		timeLineList.add(orderEntity3);
		orderEntity1=null;
		
		
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		errorNoOrder = (LinearLayout)currentView.findViewById(R.id.order_error_no_history_order);
		orderTimeLine = (LinearLayout)currentView.findViewById(R.id.timeline);
		timeLineListView = (ListView)currentView.findViewById(R.id.timeline_list);
		
		timeLineAdapter = new OrderTimeLineAdapter(getActivity(), timeLineList);
		timeLineListView.setAdapter(timeLineAdapter);
		
		if(SPUtil.getValue("loginFLag", false)){
			orderTimeLine.setVisibility(View.VISIBLE);
			errorNoOrder.setVisibility(View.GONE);
		}else{
			orderTimeLine.setVisibility(View.VISIBLE);
		}
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case (R.id.linear_above_toHome):
			openMenu.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					final SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) getActivity().findViewById(R.id.slidingpanellayout);
					if (slidingPaneLayout.isOpen())
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
