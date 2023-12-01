package com.example.chessgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // add additional initialization code here if needed


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
}