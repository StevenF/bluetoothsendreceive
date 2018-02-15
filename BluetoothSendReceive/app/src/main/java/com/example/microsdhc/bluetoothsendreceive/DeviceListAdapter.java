package com.example.microsdhc.bluetoothsendreceive;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by microsdhc on 5/7/17.
 */

public class DeviceListAdapter extends ArrayAdapter<BluetoothDevice> {
    private LayoutInflater mLayoutInflater;
    private ArrayList<BluetoothDevice> mDevices;
    private int mViewResourceId;

    public DeviceListAdapter(Context context,int resource, ArrayList<BluetoothDevice> devices) {
        super(context, resource, devices);


        this.mDevices = devices;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = resource;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = mLayoutInflater.inflate(mViewResourceId, null);
        BluetoothDevice device = mDevices.get(position);

        if(device != null){
            TextView tvDeviceNAme = (TextView)convertView.findViewById(R.id.tvDeviceNAme);
            TextView tvDeviceAddress = (TextView)convertView.findViewById(R.id.tvDeviceAddress);

            if(tvDeviceNAme != null){
                tvDeviceNAme.setText(device.getName());
            }
            if (tvDeviceAddress != null) {
                tvDeviceAddress.setText(device.getAddress());
            }
        }
        return convertView;
    }

}
