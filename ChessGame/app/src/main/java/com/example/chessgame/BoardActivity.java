package com.example.chessgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.MediaActionSound;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
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

    // UI Components
    public MediaPlayer mediaPlayer;                                                                 // Plays the background music
    public Button backButton;                                                                       // Button that returns user to menu
    public TextView WhiteInvalidMoveMsg;                                                            // Move invalid message for white
    public TextView BlackInvalidMoveMsg;                                                            // Move invalid message for black
    public LinearLayout GameOverMsg;                                                                // Displays the game over message box
    public boolean allowSquareTaps;                                                                 // Flags whether players are allowed to tap square tiles
    public TextView[][] BoardTiles = new TextView[8][8];                                            // Stores ids of board tiles
    public TextView[][] BoardPieceSlots = new TextView[8][8];                                       // Stores where proper piece images should be placed


    // Data fields to interface with back-end
    public int[] StartCoordinate = new int[2];                                                      // Stores coordinates where piece may be
    public int[] EndCoordinate = new int[2];                                                        // Stores coordinates where piece may go
    public int tapNumber;                                                                           // Stores what "number" tap the users have done, odd number
                                                                                                    // means it is a start coordinate, even means it is an end coordinate
    public int[] checkedKingPos;                                                                    // Stores the position of checked king
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

        // Allow square tiles to register taps
        allowSquareTaps = true;

    
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

                                    // Feed coordinate to back-end
                                    if (allowSquareTaps)
                                        game.handleCoordinates(i, j);


                                    // Check if this is a valid tap, display proper messages if not
                                    if (!game.validCoordinates() && allowSquareTaps) {

                                        // Display error message

                                        if (game.tapCount == 0) {             // Check if it is white's turn

                                            WhiteInvalidMoveMsg.setVisibility(View.VISIBLE);
                                        } else {

                                            BlackInvalidMoveMsg.setVisibility(View.VISIBLE);
                                        }

                                        // Refresh board tiles
                                        resetBoardTiles(false);
                                    } else if (allowSquareTaps){

                                        // Erase error messages that might have been there from previous taps
                                        WhiteInvalidMoveMsg.setVisibility(View.INVISIBLE);
                                        BlackInvalidMoveMsg.setVisibility(View.INVISIBLE);

                                        // Check if a move has been made; if so, then update board positions
                                        if (game.isValidStartTap()) {

                                            // Highlight tile tapped
                                            BoardTiles[i][j].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.light_green));

                                            // Set board positions so pieces can be on top of tiles
                                            //setBoard(game);
                                        } else {

                                            // If we are here, a move should have been made by GamePlay
                                            if (game.isValidMoveMade()) {

                                                // Refresh board tiles
                                                resetBoardTiles(true);

                                                // Update board positions
                                                setBoard(game);


                                                // Check whether a king is in check
                                                // NOTE: Check to see if isKingChecked flag needs to be reset
                                                /*if (game.isKingChecked()) {

                                                    // Highlight checked king
                                                    checkedKingPos = game.getCheckedKingPos();
                                                    BoardTiles[checkedKingPos[0]][checkedKingPos[1]].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.));
                                                }*/

                                                // Check whether game is over, display Game Over message if so
                                                /*if (game.gameOver()) {

                                                    GameOverMsg.setVisibility(View.VISIBLE);
                                                    allowSquareTaps = false;
                                                }*/
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
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


    // Reset board tile colors to original
    // Parameter will let function know whether to reset tile for checked king
    private void resetBoardTiles(boolean resetCheckedKingTile) {

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                if (checkedKingPos[0] == i && checkedKingPos[1] == j && !resetCheckedKingTile) {}
                else {

                    if ((i + j) % 2 == 0)
                        BoardTiles[i][j].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardDark));
                    else
                        BoardTiles[i][j].setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorBoardLight));
                }
            }
        }
    }


    // Run the game, melds back-end and front-end
    void runGame () {

        // Set up the board (ONLY RUNS ONCE!!) in UI
        setUpBoard();


        // Get the game going!
        //while (!game.gameOver()) {}


        // End game message


    }


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


        // Make game over message invisible until needed
        GameOverMsg = (LinearLayout) findViewById(R.id.game_over_msg_box);
        GameOverMsg.setVisibility(View.INVISIBLE);


        // Play music
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.chess_bg);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();


        // Set up board in background
        game = new GamePlay();


        // Set up back button
        backButton = (Button) findViewById(R.id.board_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Draw info screen
                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        // Run the game (set up board in UI, set up squares to listen for taps)
        runGame();


        // Determine if user wants to play again? (lower priority issue, focus after working game is completed)
    }


    @Override
    public void onDestroy () {

        // Normal destroy process
        super.onDestroy();

        // Release music
        if (mediaPlayer != null) {

            mediaPlayer.release();
        }
    }
}
