package com.example.chessgame;

public class GamePlay {

    public Piece[][] BoardPositions = new Piece[8][8];                                              // Stores the positions of pieces
    public boolean whiteTurn;                                                                       // Game starts with white
    public int[] StartCoordinates = new int[2];                                                     // Start coordinate (piece to move)
    public int[] EndCoordinates = new int[2];                                                       // End coordinate (place to move to)
    public boolean coordinatesValid;                                                                // Flags whether an entered coordinate was valid
    public boolean validStartTap;                                                                   // Flags whether a valid start tap has been made by a player
    public boolean validMoveMade;                                                                   // Flags whether a valid move has been made by a player,
                                                                                                    // BoardPositions updated accordingly
    public int gameEndState;                                                                        // 1 if white won, -1 if black won, 0 if draw

    public int validTapCount;                                                                       // Keeps track of how many valid taps have been made
                                                                                                    // (used to determine whether a full move has been made)

    // Declare Piece objects
    public static Piece bKing;
    public static Piece wKing;

    public static Piece bQueen;
    public static Piece wQueen;

    public static Piece bKnight1;
    public static Piece bKnight2;
    public static Piece wKnight1;
    public static Piece wKnight2;

    public static Piece bRook1;
    public static Piece bRook2;
    public static Piece wRook1;
    public static Piece wRook2;

    public static Piece bBishop1;
    public static Piece bBishop2;
    public static Piece wBishop1;
    public static Piece wBishop2;

    public static Piece bPawn1;
    public static Piece bPawn2;
    public static Piece bPawn3;
    public static Piece bPawn4;
    public static Piece bPawn5;
    public static Piece bPawn6;
    public static Piece bPawn7;
    public static Piece bPawn8;

    public static Piece wPawn1;
    public static Piece wPawn2;
    public static Piece wPawn3;

    public static Piece wPawn4;
    public static Piece wPawn5;
    public static Piece wPawn6;
    public static Piece wPawn7;
    public static Piece wPawn8;



    // Set up board, start the game
    public GamePlay () {

        whiteTurn = true;                                                                           // Game starts with white
        initializeBoard();                                                                          // Set up board
    }


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


    // Get reference to a Piece object
    public Piece getPiece (int row, int col) {

        return BoardPositions[row][col];
    }

    // Give access to BoardPositions
    public Piece[][] getBoardPositions () {

        return BoardPositions;
    }


    // Make a move (only called when a valid move entry has been made with Start and End tap)
    private void makeMove () {

        // Update BoardPositions using StartCoordinates and EndCoordinates
        BoardPositions[EndCoordinates[0]][EndCoordinates[1]] = BoardPositions[StartCoordinates[0]][StartCoordinates[1]];
        BoardPositions[StartCoordinates[0]][StartCoordinates[1]] = null;
        BoardPositions[EndCoordinates[0]][EndCoordinates[1]].setPosition(EndCoordinates[0],EndCoordinates[1]);

        // Update validMoveMade
        validMoveMade = true;

        // Check whether king is in check, if game is over
    }


    // Handle coordinate info (user input) from front-end
    public void handleCoordinates (int col, int row) {

        Piece selectedPiece = BoardPositions[col][row];

        // Process entered coordinates from the user (is it a start coordinate, end coordinate?)
        if (whiteTurn && selectedPiece.isWhite() && pieceCanMove(selectedPiece) && validTapCount % 4 == 0) {
            // If it is white's turn and a white piece is tapped, then it is a valid start tap
            validStartTap = true;
            validTapCount++;
            coordinatesValid = true;

            StartCoordinates[0] = col;
            StartCoordinates[1] = row;
        }
        else if(whiteTurn && isValidMove(selectedPiece, EndCoordinates[0], EndCoordinates[1]) && validTapCount % 4 == 1)
        {
            validStartTap = false;
            validTapCount++;
            coordinatesValid = true;

            EndCoordinates[0] = col;
            EndCoordinates[1] = row;

            makeMove();
            whiteTurn = false;
        }    
        else if (!whiteTurn && !selectedPiece.isWhite() && pieceCanMove(selectedPiece) && validTapCount % 4 == 2) {
            validStartTap = true;
            validTapCount++;
            coordinatesValid = true;

            StartCoordinates[0] = col;
            StartCoordinates[1] = row;
        }    
        else if(!whiteTurn && isValidMove(selectedPiece, EndCoordinates[0],EndCoordinates[1]) && validTapCount % 4 == 3)
        {
            validStartTap = false;
            validTapCount++;
            coordinatesValid = true;

            EndCoordinates[0] = col;
            EndCoordinates[1] = row;

            makeMove();
            whiteTurn = true;
        }   
        else {
            validStartTap = false;
            coordinatesValid = false;
        }

        // Determine if the tap associated with those coordinates are valid
        // Update coordinatesValid flag


        // Check if a valid Start Tap had been made previously, if so then check if this is a
        // valid End Tap using Piece class method isValidMove


        // Update whether that was a valid tap that was also a "Start Tap" (update validStartTap)


        // Determine if a full move (Start Tap and End Tap) are made, if so then make the move
        // Update validMoveMade flag


    }


    // Return boolean indicating whether it is white's turn (true if yes, false otherwise)
    public boolean isWhiteTurn () {

        return whiteTurn;
    }


    // Returns whether a "Start Tap" has been made, reset flag to false once it is called
    public boolean isValidStartTap () {

        if (validStartTap) {

            validStartTap = false;
            return true;
        } else {

            return false;
        }
    }


    // Returns whether a move has recently been made (let's UI know to update board positions)
    // Resets validMoveMade flag to false when called
    public boolean isValidMoveMade () {

        if (validMoveMade) {

            validMoveMade = false;
            return true;
        } else {

            return false;
        }
    }



    // Return whether coordinates valid
    public boolean validCoordinates () {

        return coordinatesValid;
    }


    // Check game over status
    public boolean gameOver () {

        // Determine if game is over, true if yes, false if no
        //Default return for now (CHANGE THIS LATER!!!!)
        return false;
    }


    // Check whether piece can move
    private boolean pieceCanMove (Piece piece) {

        // Go through each tile and see if those are valid moves
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                if (isValidMove(piece, i, j))
                    return true;
            }
        }

        return false;
    }

    public boolean isKinginCheck(boolean color)
    {
        boolean isKingInCheck = false;
        if(!color)
        {
            if(wRook1.isAlive && wRook1.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wKnight1.isAlive && wKnight1.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wBishop1.isAlive && wBishop1.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wRook2.isAlive && wRook2.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wKnight2.isAlive && wKnight2.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wBishop2.isAlive && wBishop2.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wQueen.isAlive && wQueen.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wKing.isAlive && wKing.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn1.isAlive && wPawn1.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn2.isAlive && wPawn2.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn3.isAlive && wPawn3.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn4.isAlive && wPawn4.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn5.isAlive && wPawn5.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn6.isAlive && wPawn6.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn7.isAlive && wPawn7.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(wPawn8.isAlive && wPawn8.isValidMove(bKing.xpos,bKing.ypos))
            {
                bKing.isChecked = true;
                isKingInCheck = true;
            }
        }
        else
        {
            if(bRook1.isAlive && bRook1.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bKnight1.isAlive && bKnight1.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bBishop1.isAlive && bBishop1.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bRook2.isAlive && bRook2.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bKnight2.isAlive && bKnight2.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bBishop2.isAlive && bBishop2.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bQueen.isAlive && bQueen.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bKing.isAlive && bKing.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn1.isAlive && bPawn1.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn2.isAlive && bPawn2.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn3.isAlive && bPawn3.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn4.isAlive && bPawn4.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn5.isAlive && bPawn5.isValidMove(cwKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn6.isAlive && bPawn6.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn7.isAlive && bPawn7.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
            else if(bPawn8.isAlive && bPawn8.isValidMove(wKing.xpos,wKing.ypos))
            {
                wKing.isChecked = true;
                isKingInCheck = true;
            }
        }
        return isKingInCheck;
    }
}
