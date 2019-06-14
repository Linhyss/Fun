package android.linhyss.fun;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mwelcometext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mwelcometext=(TextView)findViewById(R.id.welcometext);
        new waitStart().start();
    }


    private class waitStart extends Thread  {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public void run() {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent i=new Intent(MainActivity.this,FunctionList.class);
            startActivity(i);
            finish();
        }

    }




}
