package com.vstech.jamesl.irextdemo;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
//import android.os.ServiceManager;
import android.util.Log;
import android.hardware.IConsumerIrExtService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by JamesL on 2017/12/18.
 */

public class ConsumerIrExtManager {
    private static final String TAG = "ConsumerIrExt";
    private final String mPackageName;
    //private final IConsumerIrExtService mService;
    private static final String CONSUMER_IR_EXT_SERVICE = "consumer_ir_ext";

    private Method method = null;
    private IBinder binder = null;
    private IConsumerIrExtService mService = null;

    public ConsumerIrExtManager(Context context) {
        mPackageName = context.getPackageName();
        //mService = IConsumerIrExtService.Stub.asInterface(ServiceManager.getService(Context.CONSUMER_IR_EXT_SERVICE));

        try {
            method = Class.forName("android.os.ServiceManager").getMethod("getService", String.class);
            binder = (IBinder)method.invoke(null, new Object[]{CONSUMER_IR_EXT_SERVICE});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        mService = IConsumerIrExtService.Stub.asInterface(binder);
    }

    public int input_ir_ext_key_once(String protocol, int vendor_code, int keycode, int repeat) {
        int ret = 0;
        Log.w(TAG,"try to set protocal!");
        if(mService != null) {
            try {
                //int input_ir_ext_key_once(String protocol, int vendor_code, int keycode, int repeat);
                // TODO: look for procotol and code
                // protocol : NEC / RC5 / RC6
                // vendor_code: 0x0000 to 0xFFFF
                // keycode: 0x0000 to 0xFFFF
                // repeat: repeat times, about repeat per 100ms
                ret = mService.input_ir_ext_key_once(protocol,vendor_code,keycode,repeat);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.w(TAG, "set result: " + ret);
        }
        else{
            Log.w(TAG, "no consumer ir ext service.");
        }
        return  ret;
    }

    public boolean hasIrEmitter() {
        if(mService != null) {
            try {
                return mService.hasIrEmitter();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        else{
            Log.w(TAG, "no consumer ir ext service.");
        }
        return false;
    }

    public int setup_ir_ext_procotol(String protocol) {
        int ret = 0;
        Log.w(TAG,"try to set protocal!");
        if(mService != null) {
            try {
                //int input_ir_ext_key_once(String protocol, int vendor_code, int keycode, int repeat);
                // TODO: look for procotol and code
                // protocol : NEC / RC5 / RC6
                // vendor_code: 0x0000 to 0xFFFF
                // keycode: 0x0000 to 0xFFFF
                // repeat: repeat times, about repeat per 100ms
                ret = mService.setup_ir_ext_procotol(protocol);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.w(TAG, "set result: " + ret);
        }
        else{
            Log.w(TAG, "no consumer ir ext service.");
        }
        return  ret;
    }
    public int input_ir_ext_key(int vendor_code, int keycode, int repeat) {
        int ret = 0;
        Log.w(TAG,"try to set protocal!");
        if(mService != null) {
            try {
                //int input_ir_ext_key_once(String protocol, int vendor_code, int keycode, int repeat);
                // TODO: look for procotol and code
                // protocol : NEC / RC5 / RC6
                // vendor_code: 0x0000 to 0xFFFF
                // keycode: 0x0000 to 0xFFFF
                // repeat: repeat times, about repeat per 100ms
                ret = mService.input_ir_ext_key(vendor_code,keycode,repeat);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.w(TAG, "set result: " + ret);
        }
        else{
            Log.w(TAG, "no consumer ir ext service.");
        }
        return  ret;
    }
}
