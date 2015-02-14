package com.demomovewidget.framework;

import android.widget.RelativeLayout;

import com.demomovewidget.framework.base.BaseOrder;

/**
 * Created by apple on 2/14/15.
 */
public class ImageControlScale extends BaseOrder {

    @Override
    public void baseOrder() {
        if(data.getmCurrentImg()!=null){
            RelativeLayout.LayoutParams l=(RelativeLayout.LayoutParams)data.getmCurrentImg().getLayoutParams();
            if(action==ImageControlFactory.Action.enlarge){
                l.width+=10;
                l.height+=10;
                l.topMargin-=5;
                l.leftMargin-=5;
            }else if(action==ImageControlFactory.Action.reduce){
                l.width-=10;
                l.height-=10;
                l.topMargin+=5;
                l.leftMargin+=5;
            }
            data.getmCurrentImg().setLayoutParams(l);
            //刷新页面，invalidate是无效的，必须调用此方法
            data.getLlBody().postInvalidate();
        }
    }
}
