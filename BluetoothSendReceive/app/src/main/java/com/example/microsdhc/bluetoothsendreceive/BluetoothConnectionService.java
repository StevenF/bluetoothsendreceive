package com.example.microsdhc.bluetoothsendreceive;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * Created by microsdhc on 5/7/17.
 */

public class BluetoothConnectionService {
    private static final String TAG = "FW_BTConnServ";
    private static final String appName = "myApp";
    private static final UUID MY_UUID_SECURE = UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
    private static final UUID MY_UUID_INSECURE = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // 00001101-0000-1000-8000-00805F9B34FB
    private final BluetoothAdapter mBluetoothAdapter;
    Context mContext;

    private AcceptThread mInsecureAcceptThread;
    private ConnectThread mConnectThread;
    private BluetoothDevice mmDevice;
    private UUID deviceUUID;
    ProgressDialog mProgressDialog;

    private ConnectedThread mConnectedThread;

    public BluetoothSocket mmSocket;
    public InputStream mmInStream;
    public OutputStream mmOutStream;


    public BluetoothConnectionService(Context context) {
        mContext = context;
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        start();
    }

    private class AcceptThread extends Thread{
        private final BluetoothServerSocket mmServerSocket;

        public AcceptThread() {
            BluetoothServerSocket tmp = null;    //BluetoothServerSocket -- for Listening sockets;

            try{
                tmp = mBluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(appName, MY_UUID_INSECURE);

                Log.d(TAG, "AcceptThread : setting up server using " + MY_UUID_INSECURE);
            }catch (IOException e){
                Log.e(TAG, "AcceptThread : IOException :" + e.getMessage());

            }
            mmServerSocket = tmp;
        }
        public void run(){
            Log.d(TAG, "run : AcceptThread running");

            BluetoothSocket socket = null;  // BluetoothSocket -- for connected or connecting bluetooth socket

            try {
                Log.d(TAG, "run : RFCOM server socket start");

                socket = mmServerSocket.accept();

                Log.d(TAG, "run : RFCOM server socket accepted connection.");

            } catch (IOException e) {
                Log.e(TAG, "AcceptThread : IOException :" + e.getMessage());
            }
            if(socket != null){
                connected(socket, mmDevice);
            }
            Log.i(TAG, "run : end mAcceptThread");
        }
        public void cancel(){
            Log.d(TAG, "cancel : Cancelling AcceptThread.");

            try{
                mmServerSocket.close();
            }catch (IOException e){
                Log.e(TAG, "cancel : Close of AcceptThread ServerSocket failed. " + e.getMessage());
            }
        }
    }




    private class ConnectThread extends Thread {
        private BluetoothSocket mmSocket;

        public ConnectThread(BluetoothDevice device, UUID uuid) {
            Log.d(TAG, "ConnectThread : started");
            mmDevice = device;
            deviceUUID = uuid;
        }

        public void run() {
            BluetoothSocket tmp = null;
            Log.d(TAG, "ConnectThread : run ConnectThread");

            try {
                tmp = mmDevice.createInsecureRfcommSocketToServiceRecord(deviceUUID);
                Log.d(TAG, "ConnectThread : run : Trying to create InsecureRfCommSocket using UUID " +
                        MY_UUID_INSECURE);

            } catch (IOException e) {
                Log.d(TAG, "ConnectThread : run : Could not create InsecureRfCommSocket using UUID " +
                        e.getMessage());
            }
            mmSocket = tmp;

            mBluetoothAdapter.cancelDiscovery();

            try {
                mmSocket.connect(); //blocking call and will only return on a successful connection or an exception
                Log.d(TAG, "ConnectThread : run : connected");
            } catch (IOException e) {
                try {
                    mmSocket.close();
                    Log.d(TAG, "ConnectThread : run : Closed socket");
                } catch (IOException e1) {
                    Log.e(TAG, "ConnectThread : run : unabled to close connection in socket" + e1.getMessage());
                }
                Log.d(TAG, "ConnectThread : run : Could not connect to UIID" + MY_UUID_INSECURE);
            }

            connected(mmSocket, mmDevice);

        }

        public void cancel() {
            try {
                Log.d(TAG, "cancel: Closing Client Socket.");
                mmSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "cancel: close() of mmSocket in Connectthread failed. " + e.getMessage());
            }
        }
    }




    public synchronized void start(){
        if (mConnectThread != null) {
            mConnectThread.cancel();
            mConnectThread = null;
        }
        if (mInsecureAcceptThread == null) {
            mInsecureAcceptThread = new AcceptThread();
            mInsecureAcceptThread.start();
        }
    }





    public void startClient(BluetoothDevice device,UUID uuid){
        Log.d(TAG, "startClient: Started.");

        //initprogress dialog
        mProgressDialog = ProgressDialog.show(mContext,"Connecting Bluetooth"
                ,"Please Wait...",true);

        mConnectThread = new ConnectThread(device, uuid);
        mConnectThread.start();
    }





    public class ConnectedThread extends Thread{

        public ConnectedThread(BluetoothSocket socket) {

            Log.d(TAG, "ConnectedThread : started.");

            mmSocket = socket;
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            try {
                mProgressDialog.dismiss();
            }catch (NullPointerException e){
                e.printStackTrace();
            }

            try {
                tmpIn = mmSocket.getInputStream();
                tmpOut = mmSocket.getOutputStream();
            } catch (IOException e) {

            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run(){
            byte[] buffer = new byte[1024];
            int bytes;

            // keep listening to the inputstream until an exception occurs
            while(true){

                /////   BufferedReader newBR = new BufferedReader(new InputStreamReader(mmInStream));
                try {
                    bytes = mmInStream.read(buffer);
                    String incomingMessage = new String(buffer, 0, bytes); // convert buffer and bytes into string message;
                    Log.d(TAG, "ConnectedThread : run : inputStream " + incomingMessage);


                    Intent incomingMessageIntent = new Intent("incomingMessage");  // for reading data sent by other devices
                    incomingMessageIntent.putExtra("theMessage", incomingMessage); // for reading data sent by other devices
                    LocalBroadcastManager.getInstance(mContext).sendBroadcast(incomingMessageIntent); // for reading data sent by other devices



                } catch (IOException e) {
                    Log.e(TAG, "ConnectedThread : write : Error reading to inputStream. " + e.getMessage());
                    break;
                }
            }
        }

        public void write(byte[] bytes){
            String text = new String(bytes, Charset.defaultCharset());
            Log.d(TAG, "ConnectedThread : write : Writing to OutputStream");
            try {
                mmOutStream.write(bytes);
            } catch (IOException e) {
                Log.e(TAG, "ConnectedThread : write : Error writing to outputStream. " + e.getMessage());
            }
        }

        public void cancel(){
            try{
                mmSocket.close();
            }catch (IOException e){

            }
        }
    }



    public void connected(BluetoothSocket mmSocket, BluetoothDevice mmDevice){
        mConnectedThread = new ConnectedThread(mmSocket);
        mConnectedThread.start();
    }

    public void write(byte[] out){
        ConnectedThread r;

        Log.d(TAG, "write : write called");
        mConnectedThread.write(out);
    }
}


