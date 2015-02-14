package com.demomovewidget.framework.aop;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by apple on 2/14/15.
 */
public class RecordInfoForImageView implements InvocationHandler {

    private Object targetObject;
    public Object createProxyFactory(Object target){
        this.targetObject = target;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.i(":::","execute:"+method.getName());
        return method.invoke(targetObject,args);
    }
}
