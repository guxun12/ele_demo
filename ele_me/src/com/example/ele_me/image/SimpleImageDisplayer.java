package com.example.ele_me.image;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;


public class SimpleImageDisplayer implements BitmapDisplayer {

	private int targetWidth;

	public SimpleImageDisplayer(int targetWidth) {
		this.targetWidth = targetWidth;
	}

	@Override
	public Bitmap display(Bitmap bitmap, ImageView imageView,
			LoadedFrom loadedFrom) {
		// TODO Auto-generated method stub
		if (bitmap != null) {
			bitmap = ImageUtils.resizeImageByWidth(bitmap, targetWidth);
		}
		imageView.setImageBitmap(bitmap);
		return bitmap;
	}

}
