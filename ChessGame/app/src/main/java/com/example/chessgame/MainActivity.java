package com.example.chessgame;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.chessgame.databinding.ActivityMainBinding;

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
                Intent intent = new Intent (getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}