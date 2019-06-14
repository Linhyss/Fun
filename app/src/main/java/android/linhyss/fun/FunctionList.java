package android.linhyss.fun;

import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FunctionList extends AppCompatActivity {

    private List<Function> mfunctionlist=new ArrayList<>();
    String[] functionname={"传感器","百度定位","蓝牙功能","下载更新"};
    FunctionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_list);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyc_function);
        initFunction();
        adapter=new FunctionAdapter(mfunctionlist);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

    }


    private void initFunction(){
        int size=functionname.length;
        int i;
        for(i=0;i<size;i++){
            Function function = new Function();
            function.setName(functionname[i]);
            mfunctionlist.add(function);
        }

    }



}