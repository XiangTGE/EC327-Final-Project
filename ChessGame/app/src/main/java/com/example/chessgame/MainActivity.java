package com.example.chessgame;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;                                                                 // To play pirate shanty
    public boolean info_screen_clicked = false;                                                     // Determine if info screen clicked
    public boolean board_screen_clicked = false;                                                    // Determine if board screen clicked


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set up menu screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);


        // Set up music!
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.home_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();


        // Play button, will bring user to board upon tapping
        Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Set flag
                board_screen_clicked = true;

                // Draw board screen
                Intent intent = new Intent (getApplicationContext(), BoardActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // Info button, will bring user to info screen upon tapping
        Button infoButton = (Button) findViewById(R.id.info_button);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Set flag
                info_screen_clicked = true;

                // Draw info screen
                Intent intent = new Intent (getApplicationContext(), InfoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onDestroy () {

        // Normal destroy process
        super.onDestroy();


        // Release music if info screen button clicked
        if (mediaPlayer != null) {

            mediaPlayer.release();
        }
    }
}