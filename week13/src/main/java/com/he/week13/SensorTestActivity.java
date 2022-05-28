package com.he.week13;

import android.app.SearchManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.widget.EditText;

public class SensorTestActivity extends AppCompatActivity implements SensorEventListener{

    EditText gravityEdt,lightEdt;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test);

        gravityEdt=(EditText)findViewById(R.id.gravityEdt);
        lightEdt=(EditText)findViewById(R.id.lightEdt);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //sensorEventListener=new MySensorEventListener();
        //Sensor orientationSensor=sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),
                SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values=event.values;
        int sensorType=event.sensor.getType();
        StringBuilder stringBuilder=null;
        switch (sensorType){
            case Sensor.TYPE_GRAVITY:
                stringBuilder=new StringBuilder();
                stringBuilder.append("x轴横向重力值：");
                stringBuilder.append(values[0]);
                stringBuilder.append("\nY轴纵向重力值：");
                stringBuilder.append(values[1]);
                stringBuilder.append("\nZ轴向上重力值：");
                stringBuilder.append(values[2]);
                gravityEdt.setText(stringBuilder.toString());
                break;
            case Sensor.TYPE_LIGHT:
                stringBuilder=new StringBuilder();
                stringBuilder.append("光的强度值：");
                stringBuilder.append(values[0]);
                lightEdt.setText(stringBuilder.toString());
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
