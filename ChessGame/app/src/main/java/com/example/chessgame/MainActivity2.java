package com.example.chessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    //public TextView[][] BoardTiles = new TextView[8][8];
    public TextView[][] BoardPieceSlots = new TextView[8][8];                                        // Stores where proper piece images should be placed
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
        bKing = new King(false);
        wKing = new King(true);

        bQueen = new Queen(false);
        wQueen = new Queen(true);

        bRook1 = new Rook(false);
        bRook2 = new Rook(false);
        wRook1 = new Rook(true);
        wRook2 = new Rook(true);

        bKnight1 = new Knight(false);
        bKnight2 = new Knight(false);
        wKnight1 = new Knight(true);
        wKnight2 = new Knight(true);

        bBishop1 = new Bishop(false);
        bBishop2 = new Bishop(false);
        wBishop1 = new Bishop(true);
        wBishop2 = new Bishop(true);

        bPawn1 = new Pawn(false);
        bPawn2 = new Pawn(false);
        bPawn3 = new Pawn(false);
        bPawn4 = new Pawn(false);
        bPawn5 = new Pawn(false);
        bPawn6 = new Pawn(false);
        bPawn7 = new Pawn(false);
        bPawn8 = new Pawn(false);

        wPawn1 = new Pawn(true);
        wPawn2 = new Pawn(true);
        wPawn3 = new Pawn(true);
        wPawn4 = new Pawn(true);
        wPawn5 = new Pawn(true);
        wPawn6 = new Pawn(true);
        wPawn7 = new Pawn(true);
        wPawn8 = new Pawn(true);


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
        BoardPositions[1][0] = bKnight1;
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

        // Initialize where each slot is, place them in the array for easy access
        BoardPieceSlots[0][0] = (TextView) findViewById(R.id.R00);
        BoardPieceSlots[1][0] = (TextView) findViewById(R.id.R10);
        BoardPieceSlots[2][0] = (TextView) findViewById(R.id.R20);
        BoardPieceSlots[3][0] = (TextView) findViewById(R.id.R30);
        BoardPieceSlots[4][0] = (TextView) findViewById(R.id.R40);
        BoardPieceSlots[5][0] = (TextView) findViewById(R.id.R50);
        BoardPieceSlots[6][0] = (TextView) findViewById(R.id.R60);
        BoardPieceSlots[7][0] = (TextView) findViewById(R.id.R70);

        BoardPieceSlots[0][1] = (TextView) findViewById(R.id.R01);
        BoardPieceSlots[1][1] = (TextView) findViewById(R.id.R11);
        BoardPieceSlots[2][1] = (TextView) findViewById(R.id.R21);
        BoardPieceSlots[3][1] = (TextView) findViewById(R.id.R31);
        BoardPieceSlots[4][1] = (TextView) findViewById(R.id.R41);
        BoardPieceSlots[5][1] = (TextView) findViewById(R.id.R51);
        BoardPieceSlots[6][1] = (TextView) findViewById(R.id.R61);
        BoardPieceSlots[7][1] = (TextView) findViewById(R.id.R71);

        BoardPieceSlots[0][2] = (TextView) findViewById(R.id.R02);
        BoardPieceSlots[1][2] = (TextView) findViewById(R.id.R12);
        BoardPieceSlots[2][2] = (TextView) findViewById(R.id.R22);
        BoardPieceSlots[3][2] = (TextView) findViewById(R.id.R32);
        BoardPieceSlots[4][2] = (TextView) findViewById(R.id.R42);
        BoardPieceSlots[5][2] = (TextView) findViewById(R.id.R52);
        BoardPieceSlots[6][2] = (TextView) findViewById(R.id.R62);
        BoardPieceSlots[7][2] = (TextView) findViewById(R.id.R72);

        BoardPieceSlots[0][3] = (TextView) findViewById(R.id.R03);
        BoardPieceSlots[1][3] = (TextView) findViewById(R.id.R13);
        BoardPieceSlots[2][3] = (TextView) findViewById(R.id.R23);
        BoardPieceSlots[3][3] = (TextView) findViewById(R.id.R33);
        BoardPieceSlots[4][3] = (TextView) findViewById(R.id.R43);
        BoardPieceSlots[5][3] = (TextView) findViewById(R.id.R53);
        BoardPieceSlots[6][3] = (TextView) findViewById(R.id.R63);
        BoardPieceSlots[7][3] = (TextView) findViewById(R.id.R73);

        BoardPieceSlots[0][4] = (TextView) findViewById(R.id.R04);
        BoardPieceSlots[1][4] = (TextView) findViewById(R.id.R14);
        BoardPieceSlots[2][4] = (TextView) findViewById(R.id.R24);
        BoardPieceSlots[3][4] = (TextView) findViewById(R.id.R34);
        BoardPieceSlots[4][4] = (TextView) findViewById(R.id.R44);
        BoardPieceSlots[5][4] = (TextView) findViewById(R.id.R54);
        BoardPieceSlots[6][4] = (TextView) findViewById(R.id.R64);
        BoardPieceSlots[7][4] = (TextView) findViewById(R.id.R74);

        BoardPieceSlots[0][5] = (TextView) findViewById(R.id.R05);
        BoardPieceSlots[1][5] = (TextView) findViewById(R.id.R15);
        BoardPieceSlots[2][5] = (TextView) findViewById(R.id.R25);
        BoardPieceSlots[3][5] = (TextView) findViewById(R.id.R35);
        BoardPieceSlots[4][5] = (TextView) findViewById(R.id.R45);
        BoardPieceSlots[5][5] = (TextView) findViewById(R.id.R55);
        BoardPieceSlots[6][5] = (TextView) findViewById(R.id.R65);
        BoardPieceSlots[7][5] = (TextView) findViewById(R.id.R75);

        BoardPieceSlots[0][6] = (TextView) findViewById(R.id.R06);
        BoardPieceSlots[1][6] = (TextView) findViewById(R.id.R16);
        BoardPieceSlots[2][6] = (TextView) findViewById(R.id.R26);
        BoardPieceSlots[3][6] = (TextView) findViewById(R.id.R36);
        BoardPieceSlots[4][6] = (TextView) findViewById(R.id.R46);
        BoardPieceSlots[5][6] = (TextView) findViewById(R.id.R56);
        BoardPieceSlots[6][6] = (TextView) findViewById(R.id.R66);
        BoardPieceSlots[7][6] = (TextView) findViewById(R.id.R76);

        BoardPieceSlots[0][7] = (TextView) findViewById(R.id.R07);
        BoardPieceSlots[1][7] = (TextView) findViewById(R.id.R07);
        BoardPieceSlots[2][7] = (TextView) findViewById(R.id.R27);
        BoardPieceSlots[3][7] = (TextView) findViewById(R.id.R37);
        BoardPieceSlots[4][7] = (TextView) findViewById(R.id.R47);
        BoardPieceSlots[5][7] = (TextView) findViewById(R.id.R57);
        BoardPieceSlots[6][7] = (TextView) findViewById(R.id.R67);
        BoardPieceSlots[7][7] = (TextView) findViewById(R.id.R77);


        // Place piece images on the board
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                
            }
        }
    }


    // Set pieces on board according to
    private void setBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Piece p = BoardPositions[i][j];
                int x;

                if (Board[i][j].getPiece() != null) {
                    if (p instanceof King) x = 0;
                    else if (p instanceof Queen) x = 1;
                    else if (p instanceof Rook) x = 2;
                    else if (p instanceof Bishop) x = 3;
                    else if (p instanceof Knight) x = 4;
                    else if (p instanceof Pawn) x = 5;
                    else x = 6;

                    switch (x) {
                        case 0:
                            if (p.isWhite()) {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.wking);
                            } else {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.bking);
                            }
                            break;

                        case 1:
                            if (p.isWhite()) {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.wqueen);
                            } else {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.bqueen);
                            }
                            break;

                        case 2:
                            if (p.isWhite()) {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.wrook);
                            } else {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.brook);
                            }
                            break;

                        case 3:
                            if (p.isWhite()) {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.wbishop);
                            } else {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.bbishop);
                            }
                            break;

                        case 4:
                            if (p.isWhite()) {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.wknight);
                            } else {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.bknight);
                            }
                            break;

                        case 5:
                            if (p.isWhite()) {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.wpawn);
                            } else {
                                DisplayBoard[i][j].setBackgroundResource(R.drawable.bpawn);
                            }
                            break;

                        default:

                    }
                }else{
                    DisplayBoard[i][j].setBackgroundResource(0);
                }
            }
        }
        isKingInDanger();
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
