package android.linhyss.fun;

import android.hardware.Sensor;

/**
 * Created by Administrator on 2019/6/14.
 */

public class mySensors {



    String name;
    Sensor sensor;
    int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
