package com.example.yvtc.yvn102701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb, pb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb2 = (ProgressBar) findViewById(R.id.progressBar2);
    }
    public void clickShow(View v)
    {
        pb.setVisibility(View.VISIBLE);
    }
    public void clickHide(View v)
    {
        pb.setVisibility(View.INVISIBLE);
    }
    public void click1(View v)
    {
        pb.setVisibility(View.VISIBLE);
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pb.setVisibility(View.INVISIBLE);
                    }
                });

            }
        }.start();

    }

    public void click2(View v)
    {
        pb2.setProgress(pb2.getProgress() + 10);
    }

}
