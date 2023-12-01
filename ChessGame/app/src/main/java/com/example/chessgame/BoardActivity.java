package com.example.chessgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class BoardActivity extends AppCompatActivity {

    //public TextView[][] BoardTiles = new TextView[8][8];
    public TextView[][] BoardPieceSlots = new TextView[8][8];                                       // Stores where proper piece images should be placed
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
        BoardPieceSlots[1][7] = (TextView) findViewById(R.id.R07);
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
