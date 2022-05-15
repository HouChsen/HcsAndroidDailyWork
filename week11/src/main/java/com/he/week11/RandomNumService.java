package com.he.week11;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumService extends Service {
    public RandomNumService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return new MyBinder();
    }
    public class MyBinder extends Binder {
        public RandomNumService getService(){
            return RandomNumService.this;
        }
    }
    public List getRandomNumber(){
        List resArr =new ArrayList();
        String strNumber="";
        for(int i=0;i<7;i++){
            int number=new Random().nextInt(33)+1;
            if(number<10){
                strNumber="0"+String.valueOf(number);
            }else{
                strNumber=String.valueOf(number);
            }
            resArr.add(strNumber);
        }
        return resArr;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
