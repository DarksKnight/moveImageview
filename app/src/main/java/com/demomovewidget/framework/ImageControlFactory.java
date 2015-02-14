package com.demomovewidget.framework;

import android.content.Context;
import android.widget.RelativeLayout;

import com.demomovewidget.framework.base.BaseOrder;
import com.demomovewidget.widget.MoveImageView;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by apple on 2/14/15.
 */
public class ImageControlFactory extends Factory {

    //数据仓库
    private DataDepot mData;
    private ArrayList<BaseOrder> orderList=new ArrayList<>();

    //命令
    public enum Order{
        //添加
        add,
        //上一层
        replace_above,
        //下一层
        replace_down,
        //放大
        scale_enLarge,
        //缩小
        scale_reduce;
    }

    public enum Action {
        //上一层
        above,
        //下一层
        down,
        //放大
        enlarge,
        //缩小
        reduce;
    }

    //构造函数
    public ImageControlFactory(Context context, RelativeLayout llBody,DataDepot data){
        mData=data;
        mData.setLlBody(llBody);
        mData.setContext(context);
        mData.setList(new LinkedList<MoveImageView>());

        orderList.add(new ImageControlAddView(new ImageViewObserve() {
            @Override
            public void currentImgListener(MoveImageView currentImg) {
                mData.setmCurrentImg(currentImg);
            }
        }));
        orderList.add(new ImageControlReplaceView());
        orderList.add(new ImageControlScale());
    }

    @Override
    public void doOrder(Order order){
        switch (order){
            case add:
                orderList.get(0).setDoData(mData).baseOrder();
                break;
            case replace_above:
                orderList.get(1).setDoData(mData).setDoAction(Action.above).baseOrder();
                break;
            case replace_down:
                orderList.get(1).setDoData(mData).setDoAction(Action.down).baseOrder();
                break;
            case scale_enLarge:
                orderList.get(2).setDoData(mData).setDoAction(Action.enlarge).baseOrder();
                break;
            case scale_reduce:
                orderList.get(2).setDoData(mData).setDoAction(Action.reduce).baseOrder();
                break;
            default:
                break;
        }
    }

    public interface ImageViewObserve{
        void currentImgListener(MoveImageView currentImg);
    }
}
