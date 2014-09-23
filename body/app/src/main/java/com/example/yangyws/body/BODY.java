package com.example.yangyws.body;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class BODY extends Activity implements LocationListener{

    private LocationManager mLocationManager;

    public void onProviderEnabled(String provider){};
    public void onProviderDisabled(String provider){};
    public void onStatusChanged(String provider,int status,Bundle extras){};
    public void onLocationChanged(Location location){
        TextView mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setText(
                "緯度"+String.valueOf(location.getLatitude()+"\n")+
                "經度"+String.valueOf(location.getLongitude()+"\n")+
                "飆高"+String.valueOf(location.getAltitude()+"\n")+
                "精確度"+String.valueOf(location.getAccuracy()+"\n")+
                "時間"+String.valueOf(location.getTime()+"\n")+
                "方位"+String.valueOf(location.getBearing()+"\n")+
                "速度"+String.valueOf(location.getSpeed()+"\n")
        );

        Log.e("TEXT","緯度"+String.valueOf(location.getLatitude()+"\n")+
                "經度"+String.valueOf(location.getLongitude()+"\n")+
                "飆高"+String.valueOf(location.getAltitude()+"\n")+
                "精確度"+String.valueOf(location.getAccuracy()+"\n")+
                "時間"+String.valueOf(location.getTime()+"\n")+
                "方位"+String.valueOf(location.getBearing()+"\n")+
                "速度"+String.valueOf(location.getSpeed()+"\n"));
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        mLocationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.body, menu);
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
