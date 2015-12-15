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
        // Initializing variables
        mp = new MediaPlayer();

        // Play song
        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), R.raw.song1);// create's


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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
