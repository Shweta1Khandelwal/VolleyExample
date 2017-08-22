package com.iskylar.shweta.volleyexample;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Shweta on 8/22/2017.
 */
public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int r=3000;


        Thread thr;
        thr = new Thread(){
            public void run(){
                try{
                    for(int i=0;i<100;i++){
                        sleep(4000);
                        Log.e("Values", i +"");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thr.start();

        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }
}
