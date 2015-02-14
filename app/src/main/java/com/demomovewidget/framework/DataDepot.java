package com.demomovewidget.framework;

import android.content.Context;
import android.widget.RelativeLayout;

import com.demomovewidget.widget.MoveImageView;

import java.util.LinkedList;

/**
 * Created by apple on 2/14/15.
 */
public class DataDepot {

    private MoveImageView mCurrentImg;
    private RelativeLayout llBody;
    private LinkedList<MoveImageView> list;
    private Context context;

    public MoveImageView getmCurrentImg() {
        return mCurrentImg;
    }

    public void setmCurrentImg(MoveImageView mCurrentImg) {
        this.mCurrentImg = mCurrentImg;
    }

    public RelativeLayout getLlBody() {
        return llBody;
    }

    public void setLlBody(RelativeLayout llBody) {
        this.llBody = llBody;
    }

    public LinkedList<MoveImageView> getList() {
        return list;
    }

    public void setList(LinkedList<MoveImageView> list) {
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
