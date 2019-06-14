package android.linhyss.fun;



import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.ViewHolder>{
//
    private static final String TAG = "FruitAdapter";
//
    private Context mContext;
//
       private List<Function> mFunctionlist;
//
    static class ViewHolder extends RecyclerView.ViewHolder {
          CardView cardView;
          TextView functionName;
//
        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            functionName = (TextView) view.findViewById(R.id.functiontxt);
        }
    }
//
    public FunctionAdapter(List<Function> functionlist) {
        mFunctionlist = functionlist;
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
                Function function=mFunctionlist.get(position);
                start(function.getName());

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Function function=mFunctionlist.get(position);
        holder.functionName.setText(function.getName());
        //Log.d(TAG, "onBindViewHolder unction.getName(): "+function.getName());
    }

    @Override
    public int getItemCount() {
        return mFunctionlist.size();
    }


    private void start(String name){
        Intent intent;
        switch (name){
            case "传感器":
                intent=new Intent(mContext,SensorActicity.class);
                mContext.startActivity(intent);
                break;
            case"百度定位":
                intent=new Intent(mContext,BaiduLBSActivity.class);
                mContext.startActivity(intent);
                break;
            case"蓝牙功能":
                intent=new Intent(mContext,BluetoothActivity.class);
                mContext.startActivity(intent);
                break;
            case"下载更新":
                intent=new Intent(mContext,DownloadActivity.class);
                mContext.startActivity(intent);
                break;
            default:
                Toast.makeText(mContext,"该功能未添加",Toast.LENGTH_SHORT).show();
                break;

        }


    }


}