package com.demomovewidget.framework;

import android.view.View;
import android.view.ViewGroup;

import com.demomovewidget.R;
import com.demomovewidget.framework.base.BaseOrder;
import com.demomovewidget.widget.MoveImageView;

/**
 * Created by apple on 2/14/15.
 */
public class ImageControlAddView extends BaseOrder {

    static int index=0;
    private ImageControlFactory.ImageViewObserve observe;

    public ImageControlAddView(ImageControlFactory.ImageViewObserve observe){
        this.observe=observe;
    }

    @Override
    public void baseOrder() {
        MoveImageView img=new MoveImageView(data.getContext());
        img.setLayoutParams(new ViewGroup.LayoutParams(100,100));
        switch(index){
            case 0:
                img.setBackgroundColor(data.getContext().getResources().getColor(R.color.yellow));
                break;
            case 1:
                img.setBackgroundColor(data.getContext().getResources().getColor(R.color.red));
                break;
            case 2:
                img.setBackgroundColor(data.getContext().getResources().getColor(R.color.blue));
                break;
            default:
                break;
        }
        img.setOrder(index);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observe.currentImgListener((MoveImageView)v);
            }
        });
        data.getLlBody().addView(img, index++);
        data.getList().add(img);
    }
}
