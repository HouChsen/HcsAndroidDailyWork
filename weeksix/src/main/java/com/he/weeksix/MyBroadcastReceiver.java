package com.he.weeksix;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d("提示", "收到信息，我正在日志中监听！");
        String str = intent.getExtras().getString("broadcast_content");
        Toast.makeText(context,"收到的广播说：" + str, Toast.LENGTH_LONG).show();
    }
}
