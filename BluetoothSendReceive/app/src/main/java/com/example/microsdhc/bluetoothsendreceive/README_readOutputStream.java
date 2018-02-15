package com.example.microsdhc.bluetoothsendreceive;

/**
 * Created by microsdhc on 5/7/17.
 */

public class README_readOutputStream {

    // IN ACTIVITY MAIN
    // CREATE NEW TEXTVIEW


    // In MAINACTIVITY.JAVA
    // Declare textview id and initialize
    // add
        // StringBuilder messages; to global variables

    // Initialize inside onCreate
            // messages = new StringBuilder();
            // LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter("incomingMessage"));


    // BluetoothConnectionService.java >> private class ConnectedThread >> public void run()
    // add this line
            // Intent incomingMessageIntent = new Intent("incomingMessage");  // for reading data sent by other devices
            // incomingMessageIntent.putExtra("theMessage", incomingMessage); // for reading data sent by other devices
            // LocalBroadcastManager.getInstance(mContext).sendBroadcast(incomingMessageIntent); // for reading data sent by other devices
    // then create a new BroadcastReceiver, refer to
            // BroadcastReceiver mReceiver = new BroadcastReceiver() {
}

