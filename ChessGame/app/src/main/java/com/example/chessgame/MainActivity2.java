package com.example.chessgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    public TextView[][] BoardTiles = new TextView[8][8];
    public TextView[][] BoardPieceSlot = new TextView[8][8];

    // Function to set up the board


    @Override
    protected void onCreate (Bundle savedInstanceState) {

        // Set up chess board screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);
    }
}
