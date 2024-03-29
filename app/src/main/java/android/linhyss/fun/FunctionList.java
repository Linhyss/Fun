package android.linhyss.fun;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Callback;
import okhttp3.Response;

public class FunctionList extends AppCompatActivity {

    private List<Function> mfunctionlist=new ArrayList<>();
    String[] functionname={"传感器","百度定位","蓝牙功能","下载更新"};
    FunctionAdapter adapter;
    private ListView menulv;
    public SwipeRefreshLayout swipeRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_list);
        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.recyc_function);
        menulv=(ListView)findViewById(R.id.menulist);
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        initFunction();
        adapter=new FunctionAdapter(mfunctionlist);
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeRefresh.setRefreshing(false);
            }
        });
        String[] data={"菜单","关于","设置"};
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        menulv.setAdapter(arrayAdapter);
        menulv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent setting;
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 1:
                         setting=new Intent(FunctionList.this,infomation.class);
                        startActivity(setting);
                        break;
                    case 2:
                         setting=new Intent(FunctionList.this,SettingActivity.class);
                        startActivity(setting);
                        break;
                    default:break;

                }
            }
        });
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
