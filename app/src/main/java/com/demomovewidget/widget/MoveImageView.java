package com.demomovewidget.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.demomovewidget.R;
import com.demomovewidget.framework.aop.RecordInfoForImageView;
import com.demomovewidget.framework.aop.Record;
import com.demomovewidget.framework.aop.RecordImpl;

/**
 * Created by sh-sun on 15-2-13.
 */
public class MoveImageView extends ImageView implements View.OnTouchListener {

    int lastX, lastY;
    int order;
    int screenWidth;
    int screenHeight;

    public MoveImageView(Context context) {
        super(context);
        setClickable(true);
        setOnTouchListener(this);

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
    }

    public MoveImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //为控件添加蓝色边框
        Rect rect=canvas.getClipBounds();
        Paint paint=new Paint();
        paint.setColor(getResources().getColor(R.color.blue));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        canvas.drawRect(rect, paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int ea=event.getAction();

        switch(ea){
            case MotionEvent.ACTION_DOWN:
                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int dx =(int)event.getRawX() - lastX;
                int dy =(int)event.getRawY() - lastY;

                int left = v.getLeft() + dx;
                int top = v.getTop() + dy;
                int right = v.getRight() + dx;
                int bottom = v.getBottom() + dy;

                if(left < 0){
                    left = 0;
                    right = left + v.getWidth();
                }

                if(right > screenWidth){
                    right = screenWidth;
                    left = right - v.getWidth();
                }

                if(top < 0){
                    top = 0;
                    bottom = top + v.getHeight();
                }

                if(bottom > screenHeight){
                    bottom = screenHeight;
                    top = bottom - v.getHeight();
                }

                RelativeLayout.LayoutParams l=(RelativeLayout.LayoutParams)v.getLayoutParams();
                l.topMargin=top;
                l.leftMargin=left;
                v.setLayoutParams(l);

                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                RecordInfoForImageView record = new RecordInfoForImageView();
                Record r = (Record) record.createProxyFactory(new RecordImpl());
                r.move();
                break;
        }
        return false;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
