package com.example.chessgame;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Set up menu screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        // Play button, will bring user to board upon tapping
        Button playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Draw board screen
                Intent intent = new Intent (getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });

        // Info button, will bring user to info screen upon tapping
        Button infoButton = (Button) findViewById(R.id.info_button);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Draw info screen
                Intent intent = new Intent (getApplicationContext(), InfoActivity.class);
                startActivity(intent);
            }
        });
    }
}