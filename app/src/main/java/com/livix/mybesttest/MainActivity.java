package com.livix.mybesttest;

import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.livix.lib_base.api.ApiManager;
import com.livix.lib_base.api.BaseObserver;
import com.livix.lib_base.api.Response;
import com.livix.lib_base.api.RxUtils;
import com.livix.lib_base.api.TokenBean;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity{


    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tvTest);
        TextView textView1 =findViewById(R.id.tvName);
        textView1.setText("DOLBY_VISION = 1\nHDR10 = 2\nHDR10_PLUS = 4\nHLG = 3");
        Display.HdrCapabilities test = this.getDisplay().getHdrCapabilities();
        int[] q = test.getSupportedHdrTypes();
        if (q != null && q.length > 0) {
            String hdr = Arrays.toString(q);
            textView.setText("屏幕HDR类型：\n"+hdr);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testHttp();
            }
        });

    }

    private void testHttp(){
        ApiManager.getInstance().getMainApi().getToken().compose(RxUtils.schedulerTransformer()).subscribe(new BaseObserver<Response<TokenBean>>() {
            @Override
            public void onFailure(String string) {

            }

            @Override
            public void onSuccess(Response<TokenBean> tokenBeanResponse) {
                Toast.makeText(MainActivity.this, tokenBeanResponse.getData().getAccessToken(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}