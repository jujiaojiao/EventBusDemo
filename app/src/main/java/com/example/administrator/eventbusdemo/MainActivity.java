package com.example.administrator.eventbusdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(this);
        tv = (TextView) findViewById(R.id.textview);
        EventBus.getDefault().postSticky("粘性");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
        EventBus.getDefault().register(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(FirstEvent event){
        Toast.makeText(this, event.getName(), Toast.LENGTH_SHORT).show();
    }
//
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(String event){
        tv.setText(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
