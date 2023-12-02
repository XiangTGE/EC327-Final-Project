package com.example.chessgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;


/*
* UI Info:
* The UI consists of 64 text boxes with their own ids ("Rxx") that can store the image of a piece
*   - The first digit in "Rxx" is the row index, and it goes from 0-7 from the top to bottom
*     of the board as seen from the view of the white player
*   - The second digit is the column index, and it goes from 0-7 from left to right
*
* The tiles also have the same id naming convention (they color in the squares),
* but they are in the form "Rxxx", and the first digit is always 0 to indicate that it is a tile,
* and the rest is col and row indices in that order.
* */

public class BoardActivity extends AppCompatActivity {

    public TextView[][] BoardTiles = new TextView[8][8];                                            // Stores ids of board tiles
    public TextView[][] BoardPieceSlots = new TextView[8][8];                                       // Stores where proper piece images should be placed
    public TextView WhiteInvalidMoveMsg;                                                            // Move invalid message for white
    public TextView BlackInvalidMoveMsg;                                                            // Move invalid message for black
    public int[] StartCoordinate = new int[2];                                                      // Stores coordinates where piece may be
    public int[] EndCoordinate = new int[2];                                                        // Stores coordinates where piece may go
    public int tapNumber;                                                                           // Stores what "number" tap the users have done, odd number
                                                                                                    // means it is a start coordinate, even means it is an end coordinate
    GamePlay game;                                                                                  // GamePlay object to keep track of game operations
                                                                                                    // in the background

    // Set up board (UI)
    private void setUpBoard () {

        // Initialize where each slot
        BoardTiles[0][0] = (TextView) findViewById(R.id.R000);
        BoardTiles[1][0] = (TextView) findViewById(R.id.R010);
        BoardTiles[2][0] = (TextView) findViewById(R.id.R020);
        BoardTiles[3][0] = (TextView) findViewById(R.id.R030);
        BoardTiles[4][0] = (TextView) findViewById(R.id.R040);
        BoardTiles[5][0] = (TextView) findViewById(R.id.R050);
        BoardTiles[6][0] = (TextView) findViewById(R.id.R060);
        BoardTiles[7][0] = (TextView) findViewById(R.id.R070);

        BoardTiles[0][1] = (TextView) findViewById(R.id.R001);
        BoardTiles[1][1] = (TextView) findViewById(R.id.R011);
        BoardTiles[2][1] = (TextView) findViewById(R.id.R021);
        BoardTiles[3][1] = (TextView) findViewById(R.id.R031);
        BoardTiles[4][1] = (TextView) findViewById(R.id.R041);
        BoardTiles[5][1] = (TextView) findViewById(R.id.R051);
        BoardTiles[6][1] = (TextView) findViewById(R.id.R061);
        BoardTiles[7][1] = (TextView) findViewById(R.id.R071);

        BoardTiles[0][2] = (TextView) findViewById(R.id.R002);
        BoardTiles[1][2] = (TextView) findViewById(R.id.R012);
        BoardTiles[2][2] = (TextView) findViewById(R.id.R022);
        BoardTiles[3][2] = (TextView) findViewById(R.id.R032);
        BoardTiles[4][2] = (TextView) findViewById(R.id.R042);
        BoardTiles[5][2] = (TextView) findViewById(R.id.R052);
        BoardTiles[6][2] = (TextView) findViewById(R.id.R062);
        BoardTiles[7][2] = (TextView) findViewById(R.id.R072);

        BoardTiles[0][3] = (TextView) findViewById(R.id.R003);
        BoardTiles[1][3] = (TextView) findViewById(R.id.R013);
        BoardTiles[2][3] = (TextView) findViewById(R.id.R023);
        BoardTiles[3][3] = (TextView) findViewById(R.id.R033);
        BoardTiles[4][3] = (TextView) findViewById(R.id.R043);
        BoardTiles[5][3] = (TextView) findViewById(R.id.R053);
        BoardTiles[6][3] = (TextView) findViewById(R.id.R063);
        BoardTiles[7][3] = (TextView) findViewById(R.id.R073);

        BoardTiles[0][4] = (TextView) findViewById(R.id.R004);
        BoardTiles[1][4] = (TextView) findViewById(R.id.R014);
        BoardTiles[2][4] = (TextView) findViewById(R.id.R024);
        BoardTiles[3][4] = (TextView) findViewById(R.id.R034);
        BoardTiles[4][4] = (TextView) findViewById(R.id.R044);
        BoardTiles[5][4] = (TextView) findViewById(R.id.R054);
        BoardTiles[6][4] = (TextView) findViewById(R.id.R064);
        BoardTiles[7][4] = (TextView) findViewById(R.id.R074);

        BoardTiles[0][5] = (TextView) findViewById(R.id.R005);
        BoardTiles[1][5] = (TextView) findViewById(R.id.R015);
        BoardTiles[2][5] = (TextView) findViewById(R.id.R025);
        BoardTiles[3][5] = (TextView) findViewById(R.id.R035);
        BoardTiles[4][5] = (TextView) findViewById(R.id.R045);
        BoardTiles[5][5] = (TextView) findViewById(R.id.R055);
        BoardTiles[6][5] = (TextView) findViewById(R.id.R065);
        BoardTiles[7][5] = (TextView) findViewById(R.id.R075);

        BoardTiles[0][6] = (TextView) findViewById(R.id.R006);
        BoardTiles[1][6] = (TextView) findViewById(R.id.R016);
        BoardTiles[2][6] = (TextView) findViewById(R.id.R026);
        BoardTiles[3][6] = (TextView) findViewById(R.id.R036);
        BoardTiles[4][6] = (TextView) findViewById(R.id.R046);
        BoardTiles[5][6] = (TextView) findViewById(R.id.R056);
        BoardTiles[6][6] = (TextView) findViewById(R.id.R066);
        BoardTiles[7][6] = (TextView) findViewById(R.id.R076);

        BoardTiles[0][7] = (TextView) findViewById(R.id.R007);
        BoardTiles[1][7] = (TextView) findViewById(R.id.R017);
        BoardTiles[2][7] = (TextView) findViewById(R.id.R027);
        BoardTiles[3][7] = (TextView) findViewById(R.id.R037);
        BoardTiles[4][7] = (TextView) findViewById(R.id.R047);
        BoardTiles[5][7] = (TextView) findViewById(R.id.R057);
        BoardTiles[6][7] = (TextView) findViewById(R.id.R067);
        BoardTiles[7][7] = (TextView) findViewById(R.id.R077);


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
        BoardPieceSlots[1][7] = (TextView) findViewById(R.id.R17);
        BoardPieceSlots[2][7] = (TextView) findViewById(R.id.R27);
        BoardPieceSlots[3][7] = (TextView) findViewById(R.id.R37);
        BoardPieceSlots[4][7] = (TextView) findViewById(R.id.R47);
        BoardPieceSlots[5][7] = (TextView) findViewById(R.id.R57);
        BoardPieceSlots[6][7] = (TextView) findViewById(R.id.R67);
        BoardPieceSlots[7][7] = (TextView) findViewById(R.id.R77);


        // Place piece images on the board, assuming that the proper piece
        // positions are already recorded in BoardPositions
        setBoard(game);


    /*
        // Set up listeners for each tile
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                BoardPieceSlots[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (v == BoardPieceSlots[i][j]) {
                                    // The piece at BoardPositions[i][j] was clicked
                                    Piece clickedPiece = BoardPositions[i][j];
                                    // Do something with clickedPiece
                                }
                            }
                        }
                    }
                });
            }
        }*/
    }


    // Refreshes the board positions based on what is in BoardPositions
    private void setBoard(GamePlay game) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Piece p = game.getPiece(i, j);
                int x;

                if (p != null) {
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
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.wking);
                            } else {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.bking);
                            }
                            break;

                        case 1:
                            if (p.isWhite()) {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.wqueen);
                            } else {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.bqueen);
                            }
                            break;

                        case 2:
                            if (p.isWhite()) {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.wrook);
                            } else {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.brook);
                            }
                            break;

                        case 3:
                            if (p.isWhite()) {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.wbishop);
                            } else {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.bbishop);
                            }
                            break;

                        case 4:
                            if (p.isWhite()) {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.wknight);
                            } else {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.bknight);
                            }
                            break;

                        case 5:
                            if (p.isWhite()) {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.wpawn);
                            } else {
                                BoardPieceSlots[i][j].setBackgroundResource(R.drawable.bpawn);
                            }
                            break;

                        default:

                    }
                }else{
                    BoardPieceSlots[i][j].setBackgroundResource(0);
                }
            }
        }
        //isKingInDanger();
    }


    // Refresh board tile colors
    private void refreshBoardTiles () {

        BoardTiles[0][0].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[1][0].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[2][0].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[3][0].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[4][0].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[5][0].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[6][0].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[7][0].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[0][1].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[2][1].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[1][1].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[3][1].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[4][1].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[5][1].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[6][1].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[7][1].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[0][2].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[1][2].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[2][2].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[3][2].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[4][2].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[5][2].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[6][2].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[7][2].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[0][3].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[1][3].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[2][3].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[3][3].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[4][3].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[5][3].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[6][3].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[7][3].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[0][4].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[1][4].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[2][4].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[3][4].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[4][4].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[5][4].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[6][4].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[7][4].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[0][5].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[1][5].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[2][5].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[3][5].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[4][5].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[5][5].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[6][5].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[7][5].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[0][6].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[1][6].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[2][6].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[3][6].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[4][6].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[5][6].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[6][6].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[7][6].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[0][7].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[1][7].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[2][7].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[3][7].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[4][7].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[5][7].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));

        BoardTiles[6][7].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));

        BoardTiles[7][7].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));
    }


    // Get user input from tapping a tile and tapping another tile
    /*@Override
    public void onClick(View v) {

        int col;                                                                                    // Stores column index in board
        int row;                                                                                    // Stores row index in board
        int viewID = v.getId();                                                                     // Get the id of the clicked tile


        // Get coordinates corresponding to the clicked tile
        if (viewID == R.id.R00) {

            col = 0;
            row = 0;
        }
        else if (viewID == R.id.R10) {
            col = 1;
            row = 0;
        }
        else if (viewID == R.id.R20) {
            col = 2;
            row = 0;
        }
        else if (viewID == R.id.R30) {
            col = 3;
            row = 0;
        }
        else if (viewID == R.id.R40) {
            col = 4;
            row = 0;
        }
        else if (viewID == R.id.R50) {
            col = 5;
            row = 0;
        }
        else if (viewID == R.id.R60) {
            col = 6;
            row = 0;
        }
        else if (viewID == R.id.R70) {
            col = 7;
            row = 0;
        }
        else if (viewID == R.id.R01) {
            col = 0;
            row = 1;
        }
        else if (viewID == R.id.R11) {
            col = 1;
            row = 1;
        }
        else if (viewID == R.id.R21) {
            col = 2;
            row = 1;
        }
        else if (viewID == R.id.R31) {
            col = 3;
            row = 1;
        }
        else if (viewID == R.id.R41) {
            col = 4;
            row = 1;
        }
        else if (viewID == R.id.R51) {
            col = 5;
            row = 1;
        }
        else if (viewID == R.id.R61) {
            col = 6;
            row = 1;
        }
        else if (viewID == R.id.R71) {
            col = 7;
            row = 1;
        }
        else if (viewID == R.id.R02) {
            col = 0;
            row = 2;
        }
        else if (viewID == R.id.R12) {
            col = 1;
            row = 2;
        }
        else if (viewID == R.id.R22) {
            col = 2;
            row = 2;
        }
        else if (viewID == R.id.R32) {
            col = 3;
            row = 2;
        }
        else if (viewID == R.id.R42) {
            col = 4;
            row = 2;
        }
        else if (viewID == R.id.R52) {
            col = 5;
            row = 2;
        }
        else if (viewID == R.id.R62) {
            col = 6;
            row = 2;
        }
        else if (viewID == R.id.R72) {
            col = 7;
            row = 2;
        }
        else if (viewID == R.id.R03) {
            col = 0;
            row = 3;
        }
        else if (viewID == R.id.R13) {
            col = 1;
            row = 3;
        }
        else if (viewID == R.id.R23) {
            col = 2;
            row = 3;
        }
        else if (viewID == R.id.R33) {
            col = 3;
            row = 3;
        }
        else if (viewID == R.id.R43) {
            col = 4;
            row = 3;
        }
        else if (viewID == R.id.R53) {
            col = 5;
            row = 3;
        }
        else if (viewID == R.id.R63) {
            col = 6;
            row = 3;
        }
        else if (viewID == R.id.R73) {
            col = 7;
            row = 3;
        }
        else if (viewID == R.id.R04) {
            col = 0;
            row = 4;
        }
        else if (viewID == R.id.R14) {
            col = 1;
            row = 4;
        }
        else if (viewID == R.id.R24) {
            col = 2;
            row = 4;
        }
        else if (viewID == R.id.R34) {
            col = 3;
            row = 4;
        }
        else if (viewID == R.id.R44) {
            col = 4;
            row = 4;
        }
        else if (viewID == R.id.R54) {
            col = 5;
            row = 4;
        }
        else if (viewID == R.id.R64) {
            col = 6;
            row = 4;
        }
        else if (viewID == R.id.R74) {
            col = 7;
            row = 4;
        }
        else if (viewID == R.id.R05) {
            col = 0;
            row = 5;
        }
        else if (viewID == R.id.R15) {
            col = 1;
            row = 5;
        }
        else if (viewID == R.id.R25) {
            col = 2;
            row = 5;
        }
        else if (viewID == R.id.R35) {
            col = 3;
            row = 5;
        }
        else if (viewID == R.id.R45) {
            col = 4;
            row = 5;
        }
        else if (viewID == R.id.R55) {
            col = 5;
            row = 5;
        }
        else if (viewID == R.id.R65) {
            col = 6;
            row = 5;
        }
        else if (viewID == R.id.R75) {
            col = 7;
            row = 5;
        }
        else if (viewID == R.id.R06) {
            col = 0;
            row = 6;
        }
        else if (viewID == R.id.R16) {
            col = 1;
            row = 6;
        }
        else if (viewID == R.id.R26) {
            col = 2;
            row = 6;
        }
        else if (viewID == R.id.R36) {
            col = 3;
            row = 6;
        }
        else if (viewID == R.id.R46) {
            col = 4;
            row = 6;
        }
        else if (viewID == R.id.R56) {
            col = 5;
            row = 6;
        }
        else if (viewID == R.id.R66) {
            col = 6;
            row = 6;
        }
        else if (viewID == R.id.R76) {
            col = 7;
            row = 6;
        }

        else if (viewID == R.id.R07) {
            col = 0;
            row = 7;
        }
        else if (viewID == R.id.R17) {
            col = 1;
            row = 7;
        }
        else if (viewID == R.id.R27) {
            col = 2;
            row = 7;
        }
        else if (viewID == R.id.R37) {
            col = 3;
            row = 7;
        }
        else if (viewID == R.id.R47) {
            col = 4;
            row = 7;
        }
        else if (viewID == R.id.R57) {
            col = 5;
            row = 7;
        }
        else if (viewID == R.id.R67) {
            col = 6;
            row = 7;
        }
        else if (viewID == R.id.R77) {
            col = 7;
            row = 7;
        }


        // Highlight tiles
        BoardPieceSlots[row][col].setBackgroundColor(getResources().getColor(R.color.brown));


        // Feed coordinate to the back-end (GamePlay class)
        game.handleCoordinates(col, row);


        // Check if the latest tap was valid, handle error message if not valid tap
        boolean validTap = game.validCoordinates();

        if (!validTap) {

            // Display error message
        }

            // Check if the tap is a valid one
    }*/



    // Run the game, melds back-end and front-end
    void runGame () {

        // Set up the board (ONLY RUNS ONCE!!) in UI
        setUpBoard();


        // Get the game going!
        while (!game.gameOver()) {

//            // Get user input
//            if(clickedPiece.isWhite() == turn) {
//                // Do something with clickedPiece
//                Piece selectedPiece = clickedPiece;
//                if(clickedPiece == null)
//                {
//                    boolean isValidMove = clickedPiece.isValidMove(StartCoordinate, EndCoordinate);
//                    if(isValidMove)
//                    {
//                        game.movePiece(StartCoordinate, EndCoordinate);
//                        turn = !turn;
//                    }
//                }
//                //Add code to check if king is in check
//                else if(clickedPiece.type == "King")
//                {
//                    boolean isValidMove = clickedPiece.isValidMove(StartCoordinate, EndCoordinate);
//                    if(isValidMove)
//                    {
//                        boolean check = isKinginCheck(clickedPiece.isWhite());
//                        if(!check)
//                        {
//                            game.movePiece(StartCoordinate, EndCoordinate);
//                            turn = !turn;
//                        }
//                        else
//                        {
//                            error("King is in check!");
//                        }
//                    }
//                }
//                else if(clickedPiece.isWhite() != selectedPiece.isWhite())
//                {
//                    boolean isValidMove = clickedPiece.isValidMove(StartCoordinate, EndCoordinate);
//                    if(isValidMove)
//                    {
//                        game.movePiece(StartCoordinate, EndCoordinate);
//                        clickedPiece.kill();
//                        turn = !turn;
//                    }
//                }
//            }
//            else
//            {
//                error("Not your turn!");
//            }

            // 


            // Refresh board - set up board pieces
            //setBoard(game);
        }

        // End game message

    }

    /*public boolean isKinginCheck(boolean color)
    {
        boolean isKingInCheck = false;
        if(!color)
        {
            if(wRook1.isAlive && wRook1.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wKnight1.isAlive && wKnight1.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wBishop1.isAlive && wBishop1.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wRook2.isAlive && wRook2.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wKnight2.isAlive && wKnight2.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wBishop2.isAlive && wBishop2.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wQueen.isAlive && wQueen.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wKing.isAlive && wKing.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn1.isAlive && wPawn1.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn2.isAlive && wPawn2.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn3.isAlive && wPawn3.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn4.isAlive && wPawn4.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn5.isAlive && wPawn5.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn6.isAlive && wPawn6.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn7.isAlive && wPawn7.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn8.isAlive && wPawn8.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
        }
        else
        {
            if(bRook1.isAlive && bRook1.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bKnight1.isAlive && bKnight1.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bBishop1.isAlive && bBishop1.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bRook2.isAlive && bRook2.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bKnight2.isAlive && bKnight2.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bBishop2.isAlive && bBishop2.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bQueen.isAlive && bQueen.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bKing.isAlive && bKing.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn1.isAlive && bPawn1.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn2.isAlive && bPawn2.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn3.isAlive && bPawn3.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn4.isAlive && bPawn4.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn5.isAlive && bPawn5.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn6.isAlive && bPawn6.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn7.isAlive && bPawn7.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn8.isAlive && bPawn8.isValidMove(currentPiece.xpos,currentPiece.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
        }
        return isKingInCheck;
    }*/

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        // Set up chess board screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);


        // Make player move error messages, set to invisible for now
        WhiteInvalidMoveMsg = (TextView) findViewById(R.id.whiteErrorMsg);
        BlackInvalidMoveMsg = (TextView) findViewById(R.id.blackErrorMsg);
        WhiteInvalidMoveMsg.setVisibility(View.INVISIBLE);
        BlackInvalidMoveMsg.setVisibility(View.INVISIBLE);


        // Set up board in background
        game = new GamePlay();


        // Run the game
        runGame();


        // Determine if user wants to play again? (lower priority issue, focus after working game is completed)
    }
}
