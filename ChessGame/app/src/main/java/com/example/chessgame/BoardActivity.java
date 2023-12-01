package com.example.chessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;


public class BoardActivity extends AppCompatActivity {

    public TextView[][] BoardPieceSlots = new TextView[8][8];                                       // Stores where proper piece images should be placed
    public int[] StartCoordinate = new int[2];                                                      // Stores coordinates where piece may be
    public int[] EndCoordinate = new int[2];                                                        // Stores coordinates where piece may go
    public int tapNumber;                                                                           // Stores what "number" tap the users have done, odd number
                                                                                                    // means it is a start coordinate, even means it is an end coordinate
    GamePlay game;                                                                                  // GamePlay object to keep track of game operations
                                                                                                    // in the background

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
        BoardPieceSlots[1][7] = (TextView) findViewById(R.id.R17);
        BoardPieceSlots[2][7] = (TextView) findViewById(R.id.R27);
        BoardPieceSlots[3][7] = (TextView) findViewById(R.id.R37);
        BoardPieceSlots[4][7] = (TextView) findViewById(R.id.R47);
        BoardPieceSlots[5][7] = (TextView) findViewById(R.id.R57);
        BoardPieceSlots[6][7] = (TextView) findViewById(R.id.R67);
        BoardPieceSlots[7][7] = (TextView) findViewById(R.id.R77);


        // Place piece images on the board, assuming that the proper piece
        // positions are already recorded in BoardPositions
        setBoard(game.getBoardPositions());
    }


    // Refreshes the board positions based on what is in BoardPositions
    private void setBoard(Piece[][] BoardPositions) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Piece p = BoardPositions[i][j];
                int x;

                if (BoardPositions[i][j] != null) {
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


    // Get user input from tapping a tile and tapping another tile
    @Override
    public void onClick(View v) {

        int col;
        int row;


        switch (v.getId()) {
            case R.id.R00:
                col = 0;
                row = 0;
                break;
            case R.id.R10:
                col = 1;
                row = 0;
                break;
            case R.id.R20:
                col = 2;
                row = 0;
                break;
            case R.id.R30:
                col = 3;
                row = 0;
                break;
            case R.id.R40:
                col = 4;
                row = 0;
                break;
            case R.id.R50:
                col = 5;
                row = 0;
                break;
            case R.id.R60:
                col = 6;
                row = 0;
                break;
            case R.id.R70:
                col = 7;
                row = 0;
                break;

            case R.id.R01:
                col = 0;
                row = 1;
                break;
            case R.id.R11:
                col = 1;
                row = 1;
                break;
            case R.id.R21:
                col = 2;
                row = 1;
                break;
            case R.id.R31:
                col = 3;
                row = 1;
                break;
            case R.id.R41:
                col = 4;
                row = 1;
                break;
            case R.id.R51:
                col = 5;
                row = 1;
                break;
            case R.id.R61:
                col = 6;
                row = 1;
                break;
            case R.id.R71:
                col = 7;
                row = 1;
                break;

            case R.id.R02:
                col = 0;
                row = 2;
                break;
            case R.id.R12:
                col = 1;
                row = 2;
                break;
            case R.id.R22:
                col = 2;
                row = 2;
                break;
            case R.id.R32:
                col = 3;
                row = 2;
                break;
            case R.id.R42:
                col = 4;
                row = 2;
                break;
            case R.id.R52:
                col = 5;
                row = 2;
                break;
            case R.id.R62:
                col = 6;
                row = 2;
                break;
            case R.id.R72:
                col = 7;
                row = 2;
                break;

            case R.id.R03:
                col = 0;
                row = 3;
                break;
            case R.id.R13:
                col = 1;
                row = 3;
                break;
            case R.id.R23:
                col = 2;
                row = 3;
                break;
            case R.id.R33:
                col = 3;
                row = 3;
                break;
            case R.id.R43:
                col = 4;
                row = 3;
                break;
            case R.id.R53:
                col = 5;
                row = 3;
                break;
            case R.id.R63:
                col = 6;
                row = 3;
                break;
            case R.id.R73:
                col = 7;
                row = 3;
                break;

            case R.id.R04:
                col = 0;
                row = 4;
                break;
            case R.id.R14:
                col = 1;
                row = 4;
                break;
            case R.id.R24:
                col = 2;
                row = 4;
                break;
            case R.id.R34:
                col = 3;
                row = 4;
                break;
            case R.id.R44:
                col = 4;
                row = 4;
                break;
            case R.id.R54:
                col = 5;
                row = 4;
                break;
            case R.id.R64:
                col = 6;
                row = 4;
                break;
            case R.id.R74:
                col = 7;
                row = 4;
                break;

            case R.id.R05:
                col = 0;
                row = 5;
                break;
            case R.id.R15:
                col = 1;
                row = 5;
                break;
            case R.id.R25:
                col = 2;
                row = 5;
                break;
            case R.id.R35:
                col = 3;
                row = 5;
                break;
            case R.id.R45:
                col = 4;
                row = 5;
                break;
            case R.id.R55:
                col = 5;
                row = 5;
                break;
            case R.id.R65:
                col = 6;
                row = 5;
                break;
            case R.id.R75:
                col = 7;
                row = 5;
                break;

            case R.id.R06:
                col = 0;
                row = 6;
                break;
            case R.id.R16:
                col = 1;
                row = 6;
                break;
            case R.id.R26:
                col = 2;
                row = 6;
                break;
            case R.id.R36:
                col = 3;
                row = 6;
                break;
            case R.id.R46:
                col = 4;
                row = 6;
                break;
            case R.id.R56:
                col = 5;
                row = 6;
                break;
            case R.id.R66:
                col = 6;
                row = 6;
                break;
            case R.id.R76:
                col = 7;
                row = 6;
                break;

            case R.id.R07:
                col = 0;
                row = 7;
                break;
            case R.id.R17:
                col = 1;
                row = 7;
                break;
            case R.id.R27:
                col = 2;
                row = 7;
                break;
            case R.id.R37:
                col = 3;
                row = 7;
                break;
            case R.id.R47:
                col = 4;
                row = 7;
                break;
            case R.id.R57:
                col = 5;
                row = 7;
                break;
            case R.id.R67:
                col = 6;
                row = 7;
                break;
            case R.id.R77:
                col = 7;
                row = 7;
                break;
        }


        // Determine whether tap refers to StartCoordinate or EndCoordinate
        if (tapNumber % 2 != 0) {

            StartCoordinate[0] = row;
            StartCoordinate[1] = col;
        } else {

            EndCoordinate[0] = row;
            EndCoordinate[1] = col;
        }


        // Update tap number
        tapNumber++;
    }


    // Run the game, melds back-end and front-end
    void runGame () {

        // Set up the board (ONLY RUNS ONCE!!) in UI
        setUpBoard();


        // Get the game going!
        while (!game.gameOver()) {




            // Refresh board - set up board pieces
            setBoard(game.getBoardPositions());
        }
    }


    @Override
    protected void onCreate (Bundle savedInstanceState) {

        // Set up chess board screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);


        // Set up board in background
        game = new GamePlay();


        // Run the game
        runGame();


        // Determine if user wants to play again? (lower priority issue)
    }
}
