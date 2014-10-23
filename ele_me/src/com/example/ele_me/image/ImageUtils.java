package com.example.ele_me.image;

import android.graphics.Bitmap;
import android.graphics.Matrix;


public class ImageUtils {
	public static Bitmap resizeImageByWidth(Bitmap defaultBitmap,
			int targetWidth) {
		int rawWidth = defaultBitmap.getWidth();
		int rawHeight = defaultBitmap.getHeight();
		float targetHeight = targetWidth * (float) rawHeight / (float) rawWidth;
		float scaleWidth = targetWidth / (float) rawWidth;
		float scaleHeight = targetHeight / (float) rawHeight;
		Matrix localMatrix = new Matrix();
		localMatrix.postScale(scaleHeight, scaleWidth);
		return Bitmap.createBitmap(defaultBitmap, 0, 0, rawWidth, rawHeight,
				localMatrix, true);
	}
}
