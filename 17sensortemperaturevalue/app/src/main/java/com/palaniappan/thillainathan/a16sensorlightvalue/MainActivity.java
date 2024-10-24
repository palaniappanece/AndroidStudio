package com.palaniappan.thillainathan.a16sensorlightvalue;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    TextView tv1,tv2;
    SensorManager sensormanager;
    Sensor sensor1, sensor2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv1=(TextView) findViewById(R.id.T1);
        tv2=(TextView) findViewById(R.id.T2);
        sensormanager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor1 = sensormanager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensor2 = sensormanager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            float temperature = event.values[0];
            tv1.setText("Temperature: " + temperature + "°C");
        } else if (event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {
            float humidity = event.values[0];
            tv2.setText("Humidity: " + humidity + "m^3");
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensor1 != null) {
            sensormanager.registerListener(this, sensor1, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (sensor2 != null) {
            sensormanager.registerListener(this, sensor2, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensormanager.unregisterListener(this,sensor1);
        sensormanager.unregisterListener(this,sensor2);
    }
}