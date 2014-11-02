package com.example.ele_me.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SharedPreferencesUtil {
	private Context context;
	private SharedPreferences sp = null;
	private Editor edit = null;

	/**
	 * 创建默认的SharedPreferences
	 * 
	 * @param context
	 */
	public SharedPreferencesUtil(Context context) {
		this(context, PreferenceManager.getDefaultSharedPreferences(context));
	}

	/**
	 * 通过文件名创建SharedPreferences
	 * 
	 * @param context
	 * @param filename
	 */
	public SharedPreferencesUtil(Context context, String filename) {
		this(context, context.getSharedPreferences(filename,
				Context.MODE_PRIVATE));
	}

	/**
	 * 通过SharedPreferences创建SharedPreferences
	 * 
	 * @param context
	 * @param sp
	 */
	public SharedPreferencesUtil(Context context, SharedPreferences sp) {
		this.context = context;
		this.sp = sp;
		edit = sp.edit();
	}

	// Set

	// Boolean
	public void setValue(String key, boolean value) {
		edit.putBoolean(key, value);
		edit.commit();
	}

	public void setValue(int resKey, boolean value) {
		setValue(this.context.getString(resKey), value);
	}

	// Float
	public void setValue(String key, float value) {
		edit.putFloat(key, value);
		edit.commit();
	}

	public void setValue(int resKey, float value) {
		setValue(this.context.getString(resKey), value);
	}

	// Integer
	public void setValue(String key, int value) {
		edit.putInt(key, value);
		edit.commit();
	}

	public void setValue(int resKey, int value) {
		setValue(this.context.getString(resKey), value);
	}

	// Long
	public void setValue(String key, long value) {
		edit.putLong(key, value);
		edit.commit();
	}

	public void setValue(int resKey, long value) {
		setValue(this.context.getString(resKey), value);
	}

	// String
	public void setValue(String key, String value) {
		edit.putString(key, value);
		edit.commit();
	}

	public void setValue(int resKey, String value) {
		setValue(this.context.getString(resKey), value);
	}

	// Get

	// Boolean
	public boolean getValue(String key, boolean defaultValue) {
		return sp.getBoolean(key, defaultValue);
	}

	public boolean getValue(int resKey, boolean defaultValue) {
		return getValue(this.context.getString(resKey), defaultValue);
	}

	// Float
	public float getValue(String key, float defaultValue) {
		return sp.getFloat(key, defaultValue);
	}

	public float getValue(int resKey, float defaultValue) {
		return getValue(this.context.getString(resKey), defaultValue);
	}

	// Integer
	public int getValue(String key, int defaultValue) {
		return sp.getInt(key, defaultValue);
	}

	public int getValue(int resKey, int defaultValue) {
		return getValue(this.context.getString(resKey), defaultValue);
	}

	// Long
	public long getValue(String key, long defaultValue) {
		return sp.getLong(key, defaultValue);
	}

	public long getValue(int resKey, long defaultValue) {
		return getValue(this.context.getString(resKey), defaultValue);
	}

	// String
	public String getValue(String key, String defaultValue) {
		return sp.getString(key, defaultValue);
	}

	public String getValue(int resKey, String defaultValue) {
		return getValue(this.context.getString(resKey), defaultValue);
	}

	// Delete
	public void remove(String key) {
		edit.remove(key);
		edit.commit();
	}

	public void clear() {
		edit.clear();
		edit.commit();
	}

}
