package com.example.aj.wifibluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
//By the help of android startActivityForResult() method, we can get result from another activity.
//By the help of android startActivityForResult() method, we can send information from one activity to another and vice-versa. The android startActivityForResult method, requires a result from the second activity (activity to be invoked).
public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;
    BluetoothAdapter bluetoothAdapter;
    WifiManager wifi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.enable);
        b2=(Button)findViewById(R.id.discover);
        b3=(Button)findViewById(R.id.disable);
        b4=(Button)findViewById(R.id.wenable);
        b5=(Button)findViewById(R.id.wdisable);


        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter==null)
        {
            Toast.makeText(this, "Device not supported", Toast.LENGTH_SHORT).show();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bluetoothAdapter.isEnabled())
                {
                    Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(i,0);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!bluetoothAdapter.isDiscovering())
                {
                    Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(i,0);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bluetoothAdapter.disable())
                {
                    Toast.makeText(MainActivity.this, "Turning off bluetooth", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              wifi=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
              wifi.setWifiEnabled(true);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wifi=(WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
            }
        });
    }
}
