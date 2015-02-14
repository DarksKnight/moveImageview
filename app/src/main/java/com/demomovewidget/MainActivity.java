package com.demomovewidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.demomovewidget.framework.DataDepot;
import com.demomovewidget.framework.Factory;
import com.demomovewidget.framework.ImageControlFactory;


public class MainActivity extends Activity implements View.OnClickListener {

    //工厂
    private Factory factory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout llBody=(RelativeLayout)findViewById(R.id.llBody);

        factory=new ImageControlFactory(this,llBody,new DataDepot());

        //添加
        Button btnAdd=(Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        //上一层
        Button btnMoveAbove=(Button)findViewById(R.id.btnMoveAbove);
        btnMoveAbove.setOnClickListener(this);

        //下一层
        Button btnMoveDown=(Button)findViewById(R.id.btnMoveDown);
        btnMoveDown.setOnClickListener(this);

        //放大
        Button btnEnlarge=(Button)findViewById(R.id.btnEnlarge);
        btnEnlarge.setOnClickListener(this);

        //缩小
        Button btnReduce=(Button)findViewById(R.id.btnReduce);
        btnReduce.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //添加
            case R.id.btnAdd:
                factory.doOrder(ImageControlFactory.Order.add);
                break;
            //上一层
            case R.id.btnMoveAbove:
                factory.doOrder(ImageControlFactory.Order.replace_above);
                break;
            //下一层
            case R.id.btnMoveDown:
                factory.doOrder(ImageControlFactory.Order.replace_down);
                break;
            //放大
            case R.id.btnEnlarge:
                factory.doOrder(ImageControlFactory.Order.scale_enLarge);
                break;
            //缩小
            case R.id.btnReduce:
                factory.doOrder(ImageControlFactory.Order.scale_reduce);
                break;
            default:
                break;
        }
    }
}
