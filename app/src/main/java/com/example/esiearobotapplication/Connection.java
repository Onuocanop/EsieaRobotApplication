/*package com.example.esiearobotapplication;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.felhr.usbserial.UsbSerialDevice;
import com.felhr.usbserial.UsbSerialInterface;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class onnection {

    public final String ACTION_USB_PERMISSION = "com.hariharan.arduinousb.USB_PERMISSION";

    UsbDevice device;
    UsbManager usbManager;
    UsbSerialDevice serialPort;
    UsbDeviceConnection connection;

    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // Broadcast Receiver to automatically
        // start and stop the serial connection.
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_USB_PERMISSION)){
                boolean granted = intent.getExtras().getBoolean(UsbManager.EXTRA_PERMISSION_GRANTED);
                if (granted){
                    connection = usbManager.openDevice(device);
                    serialPort = UsbSerialDevice.createUsbSerialDevice(device,connection);
                    if (serialPort != null){
                        if (serialPort.open()){ // Set serial conection parameters
                            serialPort.setBaudRate(9600);
                            serialPort.setDataBits(UsbSerialInterface.DATA_BITS_8);
                            serialPort.setStopBits(UsbSerialInterface.STOP_BITS_1);
                            serialPort.setParity(UsbSerialInterface.PARITY_NONE);
                            serialPort.setFlowControl(UsbSerialInterface.FLOW_CONTROL_OFF);
                            serialPort.read(mCallBack);
                            Toast.makeText(context, "Serial connection Opened!", Toast.LENGTH_SHORT).show();
                        }else {
                            Log.d("SERIAL", "PORT NOT OPEN");
                            Toast.makeText(context, "PORT NOT OPEN", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Log.d("SERIAL", "PORT IS NULL");
                        Toast.makeText(context, "PORT IS NULL", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Log.d("SERIAL", "PERM NOT GRANTED");
                    Toast.makeText(context, "PERM NOT GRANTED", Toast.LENGTH_SHORT).show();
                }
            }else if (intent.getAction().equals(UsbManager.ACTION_USB_DEVICE_ATTACHED)){
                onCLickConnect(CntBtn);
            }else if (intent.getAction().equals(UsbManager.ACTION_USB_DEVICE_DETACHED)){

            }
        };
    };


    UsbSerialInterface.UsbReadCallback mCallBack = new UsbSerialInterface.UsbReadCallback(){
        // DEfining CallBack which triggers whenever data is read.
        @Override
        public void onReceivedData(byte[] arg0){
            String data = null;
            try {
                data = new String(arg0, "UTF-8");
                data.concat("\n");
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
    };

    public void onCLickConnect(View view) {
        HashMap<String, UsbDevice> usbDevices = usbManager.getDeviceList();
        if (!usbDevices.isEmpty()){
            boolean keep = true;
            for (Map.Entry<String, UsbDevice>entry:usbDevices.entrySet()){
                device = entry.getValue();
                int deviceVID = device.getVendorId();
                if(deviceVID == 0x2341)// Arduino Vendor ID
                {
                    PendingIntent pi = PendingIntent.getBroadcast(this,0, new Intent(ACTION_USB_PERMISSION),0);
                    usbManager.requestPermission(device, pi);
                    keep = false;
                }else{
                    connection = null;
                    device = null;
                }
                if (!keep)
                    break;
            }
        }

    }
    public void onClickedSwitch(View view)
    {
        if (view.getId() == R.id.switch2){
            if (Sw.isChecked()){
                String string ="L";
                serialPort.write(string.getBytes());
            }
            else{
                String string ="O";
                serialPort.write(string.getBytes());
            }
        }
    }



}
*/