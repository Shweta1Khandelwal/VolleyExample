package com.iskylar.shweta.volleyexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ServiceExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example);
        startService(new Intent(this,MyService.class));

    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(getApplicationContext(),MyService.class));
    }
}
