package android.linhyss.fun;



import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.ViewHolder>{
//
    private static final String TAG = "FruitAdapter";
//
    private Context mContext;
//
       private List<mySensors> mSensorlist;
//
    static class ViewHolder extends RecyclerView.ViewHolder {
          CardView cardView;
          TextView sensorName;
//
        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            sensorName = (TextView) view.findViewById(R.id.functiontxt);
        }
    }
//
    public SensorAdapter(List<mySensors> senmsorlist) {
        mSensorlist = senmsorlist;
    }
//
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.function_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                mySensors sensor=mSensorlist.get(position);
                start(sensor.getSensor());

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mySensors sensor=mSensorlist.get(position);
        holder.sensorName.setText(sensor.getName());
    }

    @Override
    public int getItemCount() {
        return mSensorlist.size();
    }


    private void start(Sensor sensor){
        Intent intent;
        intent=new Intent(mContext,SensorRunActivity.class);
        intent.putExtra("sensorType",sensor.getType());
        mContext.startActivity(intent);



    }


}