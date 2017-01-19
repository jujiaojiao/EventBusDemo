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
        EventBus.getDefault().register(this);
        tv = (TextView) findViewById(R.id.textview);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Main2Activity.class);
//        EventBus.getDefault().post(new FirstEvent("firstname"));
        startActivity(intent);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(FirstEvent event){
        tv.setText(event.getName());
        Toast.makeText(this, event.getName(), Toast.LENGTH_SHORT).show();
    }

}
