package com.he.week11;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("My service", "onCreate executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String msg = intent.getStringExtra("message");
        Log.d("My service", "onStartCommand executed" +
                " intent:" + msg + ",flags:" + flags + ",startId:" + startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("My service", "onDestroy executed");
        super.onDestroy();
    }
public class  MyBinder extends Binder {
    public MyService getService(){
        return MyService.this;
    }
}
    private MyBinder myBinder=new MyBinder();
    private String valueToShow="我代表希望传出去的值";
    public String getValue(){return valueToShow;}

    @NonNull
    @Override
    public IBinder onBind(Intent intent) {
        String msg=intent.getStringExtra("message");
        Log.d("MyService","绑定时收到MainActivity intent 消息:"+msg);
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("MyService","散伙就散伙——onUnbind executed");
        return super.onUnbind(intent);
    }

    public String doSomeOperation(String str){
        Log.d("MyService","收到MainActivity要求："+str);
        return "谁怕谁，跟一个";
    }
}
