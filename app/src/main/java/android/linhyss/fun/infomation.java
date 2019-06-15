package android.linhyss.fun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class infomation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomation);
        TextView infotv=(TextView)findViewById(R.id.infotxt);
        StringBuilder sb=new StringBuilder();
        sb.append("关于软件"+"\n\n");
        sb.append("本软件仅供娱乐和学习"+"\n");
        sb.append("请勿转载"+"\n");
        infotv.setText(sb.toString());

    }
}
