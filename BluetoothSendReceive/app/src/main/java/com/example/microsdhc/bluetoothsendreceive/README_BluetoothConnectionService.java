package com.example.microsdhc.bluetoothsendreceive;

/**
 * Created by microsdhc on 5/7/17.
 */

public class README_BluetoothConnectionService {


// NOTE THERE ARE FOUR PRIVATE CLASSES NEEDED
    // private AcceptThread()
    // private ConnectThread()
    // private ConnectedThread()


    //Declare global variables

    // private static final String TAG = "FW_BTConnServ";
    // private static final String appName = "myApp";
    // private static final UUID MY_UUID_SECURE = UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
    // private static final UUID MY_UUID_INSECURE = UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a66");
    // private final BluetoothAdapter mBluetoothAdapter;
    // Context mContext;
    // private AcceptThread mInsecureAcceptThread;
    // private ConnectThread mConnectThread;
    // private BluetoothDevice mmDevice;
    // private UUID deviceUUID;
    // ProgressDialog mProgressDialog;


    // Create new public method named BluetoothConnectionService
    // example :
    //              public BluetoothConnectionService(Context context){
    // then create variable mContext = context;

    // then initialized mBluetooth adapter to BluetoothAdapter.getDefaultAdapter(); inside this method
                        // mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();



    // >> below public BluetoothConnectionService



    // >> Create new private class AcceptThread that extends to Thread,

        // Declare private final BluetoothServerSocket mmServerSocket;


        // NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE
        //
        //
        // There are 3 constructor needed inside AcceptThread >>
        // public void AcceptThread
        // public run
        // public cancel
            //
        //
        // NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE


            // BluetoothServerSocket is called for listening bluetooth sockets
            // BluetoothSocket is for conneecting or connected bluetooth sockets.



    // >> public AcceptThread()
        // Call for BluetoothServerSocket tmp = null;
        // Initialize
            // tmp = mBluetoothAdapter.listenUsingInsecureRfcommWithServiceRecord(appName, MY_UUID_INSECURE);
        // mmServerSocket tmp = null;


    // >> public void run()
        // Call for BluetoothSocket socket = null;
        // initialize socket
            // socket = mmServerSocket.accept();

        // create if statement,
            // if(socket!=null){
            //  connected(socket, mmDevice)


    // >> public void cancel()

        // call for mmServerSocket.close();


    // ============================================================================
    // ============================================================================
    // ============================================================================
    // ============================================================================



    // private class ConnectThread


    // Create new private class ConnectThread that extends to Thread

        // Declare BluetoothSocket mmSocket

        // NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE
        //
        //
        // There are 3 constructor needed inside AcceptThread >>
        // public void AcceptThread
        // public run
        // public cancel
        //
        //
        // NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE NOTE







    // IN ACTIVITY MAIN XML
    // CREATE BUTTONS FOR SENDING, STARTING CONNECTION, EDITTEXT WIDGET FOR SENDING DATA

    // IN MAINACTIVITY.JAVA

    // call the class name of for bluetooth connection
            // example BluetoothConnectionService mBluetoothConnectionService;
    // call MY_UUID_INSECURE
    // call BluetoothDevice from BluetoothConnectionService and assign new variable name
            // BluetoothDevice mBTDevice;


    // >> on onCreate

        //Initialize all recently added button, edittext fields
        // call onClickListener for btn_send and btn_startCOnnection
        // call startConnection() method inside btn_startConnection

            // below onCreate
            // create new public method for startConnection()
            // then add this line
                // startBTConnection(mBTDevice, MY_UUID_INSECURE);





    // below onCreate

        // Create new public method
            // example : public void startBTConnection(BluetoothDevice mBTDevice, UUID uuid)
            // then inside this method add this line
                // mBluetoothConnectionService.startClient(mBTDevice, uuid);


    // on BroadcastReceiver4 BOND_BONDED declare this line
            //mBTDevice = mDevice;

    // Add this line on public BluetoothConnectionService(Context context) {
    // start();





}
