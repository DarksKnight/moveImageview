package com.demomovewidget.framework.base;

import com.demomovewidget.framework.DataDepot;
import com.demomovewidget.framework.ImageControlFactory;

/**
 * Created by apple on 2/14/15.
 */
public abstract class BaseOrder {

    public ImageControlFactory.Action action;
    public DataDepot data;

    public abstract void baseOrder();

    public BaseOrder setDoAction(ImageControlFactory.Action action){
        this.action=action;
        return this;
    }

    public BaseOrder setDoData(DataDepot data){
        this.data=data;
        return this;
    }
}
