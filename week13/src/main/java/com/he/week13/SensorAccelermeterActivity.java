package com.he.week13;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SensorAccelermeterActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    private Vibrator vibrator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_accelermeter);

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        vibrator=(Vibrator)getSystemService(Service.VIBRATOR_SERVICE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values=event.values;
        int sensorType=event.sensor.getType();
        if(sensorType==Sensor.TYPE_ACCELEROMETER){
            if((Math.abs(values[0])>9)||(Math.abs(values[1])>20)||(Math.abs(values[2])>9)){
                Toast.makeText(SensorAccelermeterActivity.this,"摇一摇",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
                alertDialog.setView(R.layout.packet);
                alertDialog.show();
                vibrator.vibrate(500);
                sensorManager.unregisterListener(this);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
