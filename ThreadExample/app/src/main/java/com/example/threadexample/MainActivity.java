package com.example.threadexample;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btnStartThread;
    private Handler mainHandler = new Handler();

    private volatile boolean stopThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartThread = findViewById(R.id.button_start_thread);
    }

    public void startThread(View view){
        /*
        ExampleThread thread = new ExampleThread(10);
        thread.start();
        */

        // preferred
        stopThread = false;
        ExampleRunnable thread = new ExampleRunnable(10);
        new Thread(thread).start();


        /* //anonymous
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        */

    }

    public void stopThread(View view){
        stopThread = true;
    }

    class ExampleThread extends Thread{
        int seconds;

        public ExampleThread(int seconds){
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    class ExampleRunnable implements Runnable{

        int seconds;

        public ExampleRunnable(int seconds){
            this.seconds = seconds;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {

                if(stopThread)
                    return;

                if(i == 5){
                    /*
                    Handler threadHandler = new Handler(Looper.getMainLooper());
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            btnStartThread.setText(("%50"));
                        }
                    });*/

/*                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            btnStartThread.setText(("%50"));
                        }
                    });*/

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            btnStartThread.setText("%50");
                        }
                    });

                }

                Log.d(TAG, "startThread: " + i);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
