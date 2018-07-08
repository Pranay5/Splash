package com.example.pranayarora.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(getApplicationContext(), R.raw.abc);
        mp.start();
        Thread t = new Thread()
        {
            public void run() {
                try {
                    Thread.sleep(5000);
                }
                catch (Exception e)
                {

                }
                finally
                {
                    Intent A = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(A);
                }

            }
        };
        t.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        mp.pause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mp.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }
    }


