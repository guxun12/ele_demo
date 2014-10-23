package com.example.ele_me.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

import com.example.ele_me.R;

public class DashedLineView extends View
{
  private Paint a;
  private Path path;
  private PathEffect c;

  public DashedLineView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public DashedLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public DashedLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.a = new Paint();
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(1.0F * getResources().getDisplayMetrics().density);
    this.a.setColor(getResources().getColor(R.color.color_d2));
    this.a.setAntiAlias(true);
    this.path = new Path();
    float f = 1.0F * getResources().getDisplayMetrics().density;
    this.c = new DashPathEffect(new float[] { f, f, f, f }, 0.0F);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.a.setPathEffect(this.c);
    int i = getMeasuredHeight();
    int j = getMeasuredWidth();
    this.path.moveTo(0.0F, 0.0F);
    if (i <= j)
      this.path.lineTo(j, 0.0F);
    while (true)
    {
      paramCanvas.drawPath(this.path, this.a);
      path.lineTo(0.0F, i);
      return;
    }
  }
}