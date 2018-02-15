package com.example.microsdhc.bluetoothsendreceive;

/**
 * Created by microsdhc on 5/7/17.
 */

public class README_MainActivity {


// NOTE :::
//
// In creating BroadcastReceiver for "enabling/disabling BT" and "enabling/disabling discoverability",
//          they are almost the same,
// enabling/ disabling BT :                 if(action.equals(mBluetoothAdapter.ACTION_STATE_CHANGED))
// enabling/disabling discoverability :     if(action.equals(mBluetoothAdapter.ACTION_SCAN_MODE_CHANGED))

// NOTE :::
// LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG
// LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG LOG



    // MANIFEST.XML
    // 1. "set bluetooth permission in android manifest"


    // MAIN ACTIVITY START
    // BLUETOOTH TURN ON AND OFF START

    // >> GLOBAL DECLARATIONS

        // 2. add button for turning bluetooth on and off in layout then declare in mainactivity
        // 3. "declare BluetoothAdapter class in mainactivity" - BluetoothAdapter lets you perform
        // local bluetooth tasks such as turning bluetooth on and off, discover devices, list bonded devices. etc


    // >> onCreate method

        // initialize all id's such as button and BluetoothAdapter;
        // 4. inside onCreate method create a buttonClickListener for button on and off,
        //      then call for enableDisableBT() method.


    // >> below onCreate method
        // 5. Below the onCreate method create a method called enableDisableBT()
        // 6. .........refer to MainActivity.java


    // >> above onCreate call for mBroadcastReceiver1

        // 7. create switch case statements for logging 4 different BluetoothAdapter STATES
        //      such as STATE.ON, STATE.TURNING_ON, STATE.OFF, STATE.TURNING_OFF

    // >> below mBroadcastReceiver1 method
        // 8. create @Override method for onDestroy()



    // BLUETOOTH TURN ON AND OFF END
    // MAIN ACTIVITY END





// ==================================================================================================//
// ==================================================================================================//
// ==================================================================================================//



    // BLUETOOTH DISCOVERABILITY START
    // MAIN ACTIVITY START

    // >> GLOBAL DECLARATIONS

        // 2. add button for enabling/disabling discoverability in layout then declare in mainactivity

    // >> onCreate method

        // initialize all id's such as button and BluetoothAdapter;
        // 4. inside onCreate method create a buttonClickListener for enabling/disabling discoverability,
        //      then call for enableDisableBTDiscoverability() method.


    // >> below onCreate method
        // 5. Below the onCreate method create a method called enableDisableBTDiscoverability()
        // 6. .........refer to MainActivity.java


    // >> above onCreate call for mBroadcastReceiver2

    // 7. create switch case statements for logging 4 different BluetoothAdapter STATES
    //      such as SCAN_MODE_CONNECTABLE_DISCOVERABLE, SCAN_MODE_CONNECTABLE, SCAN_MODE_NONE,
    //                                      STATE.CONNECTING, STATE_CONNECTED


    // >> inside onDestroy() method
        // unregister mBroadcastReceiver2


    // MAIN ACTIVITY END
    // BLUETOOTH DISCOVERABILITY END






// ==================================================================================================//
// ==================================================================================================//
// ==================================================================================================//




    // DISCOVER DEVICES START


            // 1. Add a <Listview layout in activity_main
            // 2. Create a new layout file for listview layout ex. device_list_adapter.xml
            // 3. Inside device_list_adapter, add two TextView widgets.
            //                  One for @id/BluetoothDeviceName, One for @id/BluetoothDeviceAddress
            // 4. Create new java class for listview ex. DeviceListAdapter.java
            //   .................refer to DeviceListAdapter.java



    // MAIN ACTIVITY START

    // >> GLOBAL DECLARATIONS

        // 1.  declare this >> public ArrayList<BluetoothDevice> mBTDevices = new ArrayList<>();
        //              >> public DeviceListAdapter mDeviceListAdapter;
        //              >> ListView lvNewDev;

    // >> onCreate method

    // 2. initialize all id's such as button, listview;
    // 3. inside onCreate method create a buttonClickListener for discovering devices,
    //      then call for discoverDevices() method.


    // >> below onCreate method
    // 4. Below the onCreate method create a method called discoverDevices()
    // . .........refer to MainActivity.java


    // >> above onCreate call for mBroadcastReceiver3
    // ............refer to mBroadcastReceiver3



    // MAIN ACTIVITY END

    // DISCOVER DEVICES END






// ==================================================================================================//
// ==================================================================================================//
// ==================================================================================================//


    // PAIR DEVICES START

    // MAIN ACTIVITY START


    // >> on onCreate method

        // add this lines

            // IntentFilter pairBTDeviceIntent = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
            // registerReceiver(mBroadcastReceiver4, pairBTDeviceIntent);


            // lvNewDevices.setOnItemClickListener(MainActivity.this);
            // mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


    // >> above onCreate call for mBroadcastReceiver4
        // ............refer to mBroadcastReceiver4


    // implement "AdapterView.OnItemClickListener" on MainActivity header
        // public class MainActivity extends AppCompatActivity {
        // example :
            // public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
            // implement the red squiggly lines then go to the implemented method.

    // >> on the implemented onItemClick

        // call for cancelDiscovery for mBluetoothAdapter
        // example :
            // mBluetoothAdapter.cancelDiscovery();
            // ... refer to MainActivity



    // MAIN ACTIVITY END

    // PAIR DEVICES END







}
