package com.example.yangyws.slidingtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动菜单Demo主Activity
 *
 * @author guolin
 */
public class MyActivity extends Activity {

    /**
     * 双向滑动菜单布局
     */
    private BidirSlidingLayout bidirSldingLayout;
    private BidirSlidingLayout bidirSldingLayout2;
    /**
     * 在内容布局上显示的ListView
     */
    private ListView contentList;

    /**
     * ListView的适配器
     */
    private ArrayAdapter<String> contentListAdapter;

    /**
     * 在内容布局上显示的ListView
     */
    private ListView contentList2;
    private ListView contentList3;

    /**
     * ListView的适配器
     */
    private ArrayAdapter<String> contentListAdapter2;
    private ArrayAdapter<String> contentListAdapter3;


    /**
     * 用于填充contentListAdapter的数据源。
     */
    private String[] contentItems = { "Content Item 1", "Content Item 2", "Content Item 3",
            "Content Item 4", "Content Item 5", "Content Item 6", "Content Item 7",
            "Content Item 8", "Content Item 9", "Content Item 10", "Content Item 11",
            "Content Item 12", "Content Item 13", "Content Item 14", "Content Item 15",
            "Content Item 16" };
    private String[] contentItems2 = { "Content Item 11", "Content Item 21", "Content Item 31",
            "Content Item 41", "Content Item 51", "Content Item 6", "Content Item 7",
            "Content Item 8", "Content Item 9", "Content Item 10", "Content Item 11",
            "Content Item 12", "Content Item 13", "Content Item 14", "Content Item 15",
            "Content Item 16" };
    View layout1, layout2;
    private OverwriteAdapter adapter;
    ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my);
        LayoutInflater inflater = LayoutInflater.from(this);
        layout1 = inflater.inflate(R.layout.activity_my, null);
        layout2 = inflater.inflate(R.layout.item, null);
        //自定義list佈局
        for(int i=0; i<10; i++){
            HashMap<String,Object> item = new HashMap<String,Object>();
            item.put( "food", "f"+i);
            item.put("place", "p" + i);
            item.put("rating", "評分："+i+" 星");
            item.put("imageView2",R.drawable.red);
            list.add( item );
        }

        adapter = new OverwriteAdapter(this,list,R.layout.list1_layout,
                new String[]{"food","place","rating","imageView2"},
                new int[] { R.id.textView1, R.id.textView2, R.id.textView3 ,R.id.imageView2});
        set1();
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);

    }
    //第一畫面 監聽動作
    public void set1(){
        setContentView(layout1);
        bidirSldingLayout = (BidirSlidingLayout) findViewById(R.id.bidir_sliding_layout);
        contentList = (ListView) findViewById(R.id.contentList);
        contentListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                contentItems);


        contentList.setAdapter(contentListAdapter);
        contentList2 = (ListView) findViewById(R.id.contentList2);
        contentListAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                contentItems);

        //改用自定義LIST layout
        contentList2.setAdapter(adapter);
        //監聽click
        contentList2.setOnItemClickListener(on1);
        bidirSldingLayout.setScrollEvent(contentList);
        bidirSldingLayout.closeTwo();
    }

    //第二畫面 監聽動作
    public void set2(){
        setContentView(layout2);
        bidirSldingLayout2 = (BidirSlidingLayout) findViewById(R.id.bidir_sliding_layout2);
        contentList3 = (ListView) findViewById(R.id.contentList3);
        contentListAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                contentItems2);
        contentList3.setAdapter(contentListAdapter3);
        contentList2 = (ListView) findViewById(R.id.contentList21);
        contentListAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                contentItems);
        contentList2.setAdapter(contentListAdapter2);

        //監聽click
        contentList2.setOnItemClickListener(on2);
        bidirSldingLayout2.setScrollEvent(contentList3);


        bidirSldingLayout2.closeTwo();
    }


     AdapterView.OnItemClickListener on1 = new AdapterView.OnItemClickListener() {
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             set2();


         }
     };
    AdapterView.OnItemClickListener on2 = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            set1();


        }
    };

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        menu.add(0,1,Menu.NONE,"123");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

//更改背景
class OverwriteAdapter extends SimpleAdapter {
    // 颜色
    private int[] colors = { Color.BLUE, Color.BLACK,
            Color.RED, Color.GREEN, Color.YELLOW,Color.BLUE, Color.BLACK,
            Color.RED, Color.GREEN, Color.YELLOW};

    public OverwriteAdapter(Context context,
                            List<? extends Map<String, ?>> data, int resource,
                            String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
       View view = super.getView(position, convertView, parent);
//        view.setBackgroundColor(colors[position % 10]);
//        view.setBackgroundResource(R.drawable.red);
        return view;
    }
}
