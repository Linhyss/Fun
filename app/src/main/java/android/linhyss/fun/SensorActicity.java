package android.linhyss.fun;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SensorActicity extends AppCompatActivity {

    SensorManager sm;
    TextView sensorshow;
    SensorAdapter adapter;
    private List<mySensors> msensorlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonsor);
        sensorshow=(TextView)findViewById(R.id.sensorshow);
        sm=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList =sm.getSensorList(Sensor.TYPE_ALL);

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyc_sensor);
        adapter=new SensorAdapter(msensorlist);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        StringBuilder sb = new StringBuilder();
        sb.append("此手机有" + sensorList.size() + "个传感器，分别有：\n\n");
        sensorshow.setText(sb.toString());

        for(Sensor s:sensorList){
            switch (s.getType()){
                case Sensor.TYPE_ACCELEROMETER:
                    addSensor("加速度传感器",s);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    addSensor("陀螺仪传感器",s);
                    break;
                case Sensor.TYPE_LIGHT:
                    addSensor("光线传感器",s);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    addSensor("磁场传感器",s);
                    break;
                case Sensor.TYPE_ORIENTATION:
                    addSensor("方向传感器",s);
                    break;
                case Sensor.TYPE_PRESSURE:
                    addSensor("气压传感器",s);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    addSensor("距离传感器",s);
                    break;
                case Sensor.TYPE_TEMPERATURE:
                    addSensor("温度传感器",s);
                    break;
                default:
                    //addSensor("其他传感器");
                    break;
            }
           // sb.append("设备名称：" + s.getName() + "\n 设备版本：" + s.getVersion() + "\n 供应商："
           //         + s.getVendor() + "\n\n");
        }
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void addSensor(String sensorName, Sensor sensor){
        mySensors mySensors = new mySensors();
        mySensors.setName(sensorName);
        mySensors.setSensor(sensor);
        msensorlist.add(mySensors);

    }


}

