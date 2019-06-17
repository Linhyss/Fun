package android.linhyss.fun;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.GenericArrayType;

public class SensorRunActivity extends AppCompatActivity implements SensorEventListener {



    private TextView tv_value3;
    private SensorManager sManager;
    private Sensor mSensor;
    private int sensorType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_run);
        Intent intent =getIntent();
        tv_value3 = (TextView) findViewById(R.id.tv_value3);
        if( intent.getIntExtra("sensorType",9999) !=9999) {
            sensorType = intent.getIntExtra("sensorType", 9999);
            sManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            mSensor = sManager.getDefaultSensor(sensorType);
            sManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_UI);
        }
        else
            Toast.makeText(getApplicationContext(),"未知错误",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        StringBuilder sb = new StringBuilder();
        switch (sensorType) {
            case Sensor.TYPE_ACCELEROMETER:
                sb.append(" 加速度传感器(Accelerometer sensor)" + "\n");
                sb.append(" x：" + event.values[0]+"m/s2\n");
                sb.append(" y：" + event.values[1]+"m/s2\n");
                sb.append(" z：" + event.values[2]+"m/s2\n");
                break;
            case Sensor.TYPE_GYROSCOPE:
                sb.append(" 陀螺仪传感器(Gyroscope sensor)" + "\n");
                sb.append(" 传感器值1：" + event.values[0]+"\n");
                sb.append(" 传感器值2：" + event.values[1]+"\n");
                sb.append(" 传感器值3：" + event.values[2]+"\n");
                break;
            case Sensor.TYPE_LIGHT:
                sb.append( " 光线传感器(Light sensor)" + "\n");
                sb.append(" 光线强度：" + event.values[0]+"lux\n");
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                sb.append(" 磁场传感器(Magnetic field sensor)" + "\n");
                sb.append(" X：" + event.values[0]+"T\n");
                sb.append(" Y：" + event.values[1]+"T\n");
                sb.append(" Z：" + event.values[2]+"T\n");
                break;
            case Sensor.TYPE_ORIENTATION:
                sb.append( " 方向传感器(Orientation sensor)" + "\n");
                sb.append(" 方位角：" + event.values[0]+"\n");
                sb.append(" 倾斜角：" + event.values[1]+"\n");
                sb.append(" 滚动角：" + event.values[2]+"\n");
                break;
            case Sensor.TYPE_PRESSURE:
                sb.append( " 气压传感器(Pressure sensor)" + "\n");
                sb.append(" 气压：" + event.values[0]+"hPa\n");
                break;
            case Sensor.TYPE_PROXIMITY:
                sb.append(  " 距离传感器(Proximity sensor)" + "\n");
                sb.append(" 距离：" + event.values[0]+"cm\n");
                break;
            case Sensor.TYPE_TEMPERATURE:
                sb.append( " 温度传感器(Temperature sensor)" + "\n");
                sb.append(" 传感器值1：" + event.values[0]+"\n");
                sb.append(" 传感器值2：" + event.values[1]+"\n");
                sb.append(" 传感器值3：" + event.values[2]+"\n");
                break;

            default:
                sb.append( " 其他传感器" + "\n");
                break;
        }
        tv_value3.setText(sb.toString());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
