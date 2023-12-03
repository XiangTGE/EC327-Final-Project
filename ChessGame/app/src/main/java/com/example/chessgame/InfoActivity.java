package com.example.chessgame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    public MediaPlayer mediaPlayer;                                                                 // To play background music

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Set up music!
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music_file);
        mediaPlayer.start();


        // Create back button to go back to menu
        Button backButton = (Button) findViewById(R.id.info_activity_back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Draw info screen
                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish(); // Destroys InfoActivity
            }
        });
    }


    @Override
    public void onDestroy () {

        // Normal destroy process
        super.onDestroy();

        // Release music
        if (mediaPlayer != null) {

            mediaPlayer.release();
        }
    }
}