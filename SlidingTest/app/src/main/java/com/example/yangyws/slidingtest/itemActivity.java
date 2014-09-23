package com.example.yangyws.slidingtest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by yangyws on 2014/9/17.
 */
public class itemActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        long lv_item_id = getIntent().getLongExtra("lv_item_id", -1);
        if(lv_item_id != -1) {
            //根据ID查询做数据库操作吧
        }
    }
}
