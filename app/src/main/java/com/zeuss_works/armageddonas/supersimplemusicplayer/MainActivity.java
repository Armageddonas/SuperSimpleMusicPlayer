package com.zeuss_works.armageddonas.supersimplemusicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;
    boolean playing = false;
    final String TAG = "MusicAppInfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Initializing variables
        mp = new MediaPlayer();

        mp = MediaPlayer.create(getApplicationContext(), R.raw.song1);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                playing = false;
                ((ImageButton) findViewById(R.id.play_pause)).setImageResource(R.drawable.ic_play_arrow_black_36dp);
            }
        });


        ImageButton play_pause = (ImageButton) findViewById(R.id.play_pause);

        play_pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (playing == true) {
                    mp.pause();
                    playing = false;
                    ((ImageButton) v).setImageResource(R.drawable.ic_play_arrow_black_36dp);
                } else {
                    mp.start();
                    playing = true;
                    ((ImageButton) v).setImageResource(R.drawable.ic_pause_black_36dp);
                }
            }
        });


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (playing == true) {
            mp.pause();
            //((ImageButton) findViewById(R.id.play_pause)).setImageResource(R.drawable.ic_play_arrow_black_36dp);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (playing == true) {
            mp.start();
            playing = true;
            //((ImageButton) findViewById(R.id.play_pause)).setImageResource(R.drawable.ic_pause_black_36dp);
        }
    }

}
