package com.example.administrator.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.greenrobot.eventbus.EventBus;
public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn = (Button) findViewById(R.id.btn2);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new FirstEvent("firstname"));
        this.finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
