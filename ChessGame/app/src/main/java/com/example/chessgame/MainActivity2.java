package com.example.chessgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.w3c.dom.Text;

import com.example.chessgame.Piece;


public class MainActivity2 extends AppCompatActivity {

    //public TextView[][] BoardTiles = new TextView[8][8];
    public TextView[][] BoardPieceSlot = new TextView[8][8];                                        // Stores where proper piece images should be placed
    public Piece[][] BoardPositions = new Piece[8][8];                                              // Stores the positions of pieces


    // Declare Piece objects
    Piece bKing;
    Piece wKing;

    Piece bQueen;
    Piece wQueen;

    Piece bKnight1;
    Piece bKnight2;
    Piece wKnight1;
    Piece wKnight2;

    Piece bRook1;
    Piece bRook2;
    Piece wRook1;
    Piece wRook2;

    Piece bBishop1;
    Piece bBishop2;
    Piece wBishop1;
    Piece wBishop2;

    Piece bPawn1;
    Piece bPawn2;
    Piece bPawn3;
    Piece bPawn4;
    Piece bPawn5;
    Piece bPawn6;
    Piece bPawn7;
    Piece bPawn8;

    Piece wPawn1;
    Piece wPawn2;
    Piece wPawn3;
    Piece wPawn4;
    Piece wPawn5;
    Piece wPawn6;
    Piece wPawn7;
    Piece wPawn8;

    // Initialize the board in the background
    private void initializeBoard () {

        // Initialize Piece objects
        bKing = new King();
        wKing = new King();

        bQueen = new Queen();
        wQueen = new Queen();

        bRook1 = new Rook();
        bRook2 = new Rook();
        wRook1 = new Rook();
        wRook2 = new Rook();

        bKnight1 = new Knight();
        bKnight2 = new Knight();
        wKnight1 = new Knight();
        wKnight2 = new Knight();

        bBishop1 = new Bishop();
        bBishop2 = new Bishop();
        wBishop1 = new Bishop();
        wBishop2 = new Bishop();

        bPawn1 = new Pawn();
        bPawn2 = new Pawn();
        bPawn3 = new Pawn();
        bPawn4 = new Pawn();
        bPawn5 = new Pawn();
        bPawn6 = new Pawn();
        bPawn7 = new Pawn();
        bPawn8 = new Pawn();

        wPawn1 = new Pawn();
        wPawn2 = new Pawn();
        wPawn3 = new Pawn();
        wPawn4 = new Pawn();
        wPawn5 = new Pawn();
        wPawn6 = new Pawn();
        wPawn7 = new Pawn();
        wPawn8 = new Pawn();


        // Store where pieces will be in starting position
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                BoardPositions[i][j] = null;
            }
        }

        BoardPositions[0][7] = wRook1;
        BoardPositions[1][7] = wKnight1;
        BoardPositions[2][7] = wBishop1;
        BoardPositions[3][7] = wQueen;
        BoardPositions[4][7] = wKing;
        BoardPositions[5][7] = wBishop2;
        BoardPositions[6][7] = wKnight2;
        BoardPositions[7][7] = wRook2;

        BoardPositions[0][6] = wPawn1;
        BoardPositions[1][6] = wPawn2;
        BoardPositions[2][6] = wPawn3;
        BoardPositions[3][6] = wPawn4;
        BoardPositions[4][6] = wPawn5;
        BoardPositions[5][6] = wPawn6;
        BoardPositions[6][6] = wPawn7;
        BoardPositions[7][6] = wPawn8;

        BoardPositions[0][0] = bRook1;
        BoardPositions[1][0] = bKnight1);
        BoardPositions[2][0] = bBishop1;
        BoardPositions[3][0] = bQueen;
        BoardPositions[4][0] = bKing;
        BoardPositions[5][0] = bBishop2;
        BoardPositions[6][0] = bKnight2;
        BoardPositions[7][0] = bRook2;

        BoardPositions[0][1] = bPawn1;
        BoardPositions[1][1] = bPawn2;
        BoardPositions[2][1] = bPawn3;
        BoardPositions[3][1] = bPawn4;
        BoardPositions[4][1] = bPawn5;
        BoardPositions[5][1] = bPawn6;
        BoardPositions[6][1] = bPawn7;
        BoardPositions[7][1] = bPawn8;
    }


    // Set up board (UI)
    private void setUpBoard () {


        BoardPieceSlot[0][0] = (TextView) findViewById(R.id.R17);
        BoardPieceSlot[0][0].setBackgroundResource(R.drawable.bking);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        // Set up chess board screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);


        // Set up board in background
        initializeBoard();

        // Set up board in UI
        setUpBoard();
    }
}
