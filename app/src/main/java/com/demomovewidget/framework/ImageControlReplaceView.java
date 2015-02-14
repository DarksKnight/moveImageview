package com.demomovewidget.framework;

import com.demomovewidget.framework.base.BaseOrder;
import com.demomovewidget.widget.MoveImageView;

/**
 * Created by apple on 2/14/15.
 */
public class ImageControlReplaceView extends BaseOrder {

    @Override
    public void baseOrder() {
        if(data.getmCurrentImg()!=null){
            int currentIndex=data.getmCurrentImg().getOrder();
            int nextIndex=0;
            if(action==ImageControlFactory.Action.above){
                nextIndex=currentIndex+1;
            }else if(action==ImageControlFactory.Action.down){
                nextIndex=currentIndex-1;
            }

            if(nextIndex<data.getList().size()&& nextIndex>=0){

                MoveImageView nextImg=data.getList().get(nextIndex);

                data.getLlBody().removeView(data.getmCurrentImg());
                data.getLlBody().removeView(nextImg);

                if(action==ImageControlFactory.Action.above){
                    data.getLlBody().addView(nextImg, currentIndex);
                    data.getLlBody().addView(data.getmCurrentImg(), nextIndex);
                }else if(action==ImageControlFactory.Action.down){
                    data.getLlBody().addView(data.getmCurrentImg(), nextIndex);
                    data.getLlBody().addView(nextImg, currentIndex);
                }

                data.getmCurrentImg().setOrder(nextIndex);
                nextImg.setOrder(currentIndex);

                data.getList().remove(data.getmCurrentImg());
                data.getList().remove(nextImg);

                if(action==ImageControlFactory.Action.above){
                    data.getList().add(currentIndex, nextImg);
                    data.getList().add(nextIndex, data.getmCurrentImg());
                }else if(action==ImageControlFactory.Action.down){
                    data.getList().add(nextIndex, data.getmCurrentImg());
                    data.getList().add(currentIndex, nextImg);
                }
            }
        }
    }
}
