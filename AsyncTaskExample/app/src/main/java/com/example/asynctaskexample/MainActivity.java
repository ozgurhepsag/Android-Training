package com.example.asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_bar);
    }

    public void startAsyncTask(View view){
        ExampleAsyncTask task = new ExampleAsyncTask(this);
        task.execute(10); // 10 seconds freeze
    }

    private static class ExampleAsyncTask extends AsyncTask<Integer, Integer, String>{ // second, progress, url

        private WeakReference<MainActivity> activityWeakReference; // weakreference for garbage collector to prevent memory leak
                                                                    // when the activity is closed

        public ExampleAsyncTask(MainActivity activity){
            activityWeakReference = new WeakReference<MainActivity>(activity);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                publishProgress(i * 100 / integers[0]); // onProgressUpdate called
                try {
                    Thread.sleep(1000); // every second progress bar will progress
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Finished!";
        }

        @Override
        protected void onPreExecute() { // only in the cope of onProExecute, we can use strong reference
            super.onPreExecute();
            MainActivity activity = activityWeakReference.get();

            if(activity == null || activity.isFinishing()){
                return;
            }

            activity.progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            MainActivity activity = activityWeakReference.get();

            if(activity == null || activity.isFinishing()){
                return;
            }

            Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
            activity.progressBar.setProgress(0);
            activity.progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            MainActivity activity = activityWeakReference.get();

            if(activity == null || activity.isFinishing()){
                return;
            }

            activity.progressBar.setProgress(values[0]);
        }
    }
}
