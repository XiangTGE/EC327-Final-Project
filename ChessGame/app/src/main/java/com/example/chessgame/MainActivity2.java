package com.example.chessgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

import com.example.chessgame.Piece.*;


public class MainActivity2 extends AppCompatActivity {

    public TextView[][] BoardTiles = new TextView[8][8];
    public TextView[][] BoardPieceSlot = new TextView[8][8];

    // Function to set up the board
    private void setBoardPieces () {

        BoardPieceSlot[0][0] = (TextView) findViewById(R.id.R17);
        BoardPieceSlot[0][0].setBackgroundResource(R.drawable.bking);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        // Set up chess board screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);


        // Set up board pieces
        setBoardPieces();
    }
}
