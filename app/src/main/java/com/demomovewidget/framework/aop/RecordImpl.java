package com.demomovewidget.framework.aop;

import android.util.Log;

/**
 * Created by apple on 2/14/15.
 */
public class RecordImpl implements Record {

    @Override
    public void move() {
        Log.i(":::","插入成功");
    }
}
