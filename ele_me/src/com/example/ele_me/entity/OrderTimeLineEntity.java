package com.example.ele_me.entity;

import java.io.Serializable;

public class OrderTimeLineEntity implements Serializable{
	/**
	 * 订单时间轴实体
	 */
	private static final long serialVersionUID = -663262261358773854L;
	private String logo="";//头像
	private String msg="";//订单信息
	private String time="";//订单时间
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	

}
