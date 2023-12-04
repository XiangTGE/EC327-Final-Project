package com.example.chessgame;

public class GamePlay {

    public Piece[][] BoardPositions = new Piece[8][8];                                              // Stores the positions of pieces
    public Piece pieceToMove;                                                                       // Reference to piece that player selected to move
    public int[] StartCoordinates = new int[2];                                                     // Start coordinate (piece to move)
    public int[] EndCoordinates = new int[2];                                                       // End coordinate (place to move to)
    public boolean coordinatesValid;                                                                // Flags whether an entered coordinate was valid
    public boolean validStartTap;                                                                   // Flags whether a valid start tap has been made by a player
    public boolean validMoveMade;                                                                   // Flags whether a valid move has been made by a player,
                                                                                                    // BoardPositions updated accordingly
    public int gameEndState;                                                                        // 1 if white won, -1 if black won, 0 if draw

<<<<<<< HEAD
    public int tapCount;                                                                            // Keeps track of how many valid taps have been made
                                                                                                    // (used to determine whether a full move has been made)
    public boolean gameOver;                                                                        // Keep track of whether game is over
    public boolean kingChecked;                                                                     // Flags whether king is in check
    public int[] checkedKingPos;                                                                    // Position of checked king
=======
    public int tapCount;                                                                          // Initialize tap count to 0. Increment in handleCoordinates after each valid tap.
                                                                                                    // 0 = 1st move white ; 1 = 2nd move white ; 2 = 1st move black ; 3 = 2nd move black
    public boolean gameOver = false;                                                                // Keep track of whether game is over
>>>>>>> ee6d466c393352c7a44b7b7fd71343d8350856ff


    // Declare Piece objects
    public static King bKing;
    public static King wKing;

    public static Queen bQueen;
    public static Queen wQueen;

    public static Knight bKnight1;
    public static Knight bKnight2;
    public static Knight wKnight1;
    public static Knight wKnight2;

    public static Rook bRook1;
    public static Rook bRook2;
    public static Rook wRook1;
    public static Rook wRook2;
    public static Bishop bBishop1;
    public static Bishop bBishop2;
    public static Bishop wBishop1;
    public static Bishop wBishop2;

    public static Pawn bPawn1;
    public static Pawn bPawn2;
    public static Pawn bPawn3;
    public static Pawn bPawn4;
    public static Pawn bPawn5;
    public static Pawn bPawn6;
    public static Pawn bPawn7;
    public static Pawn bPawn8;

    public static Pawn wPawn1;
    public static Pawn wPawn2;
    public static Pawn wPawn3;

    public static Pawn wPawn4;
    public static Pawn wPawn5;
    public static Pawn wPawn6;
    public static Pawn wPawn7;
    public static Pawn wPawn8;



    // Set up board, start the game
    public GamePlay () {
        initializeBoard();
        tapCount = 0;// Set up board
        gameOver = false;
        kingChecked = false;
        checkedKingPos = new int[2];
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

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(BoardPositions[i][j] != null)
                {
                    BoardPositions[i][j].setPosition(i,j); // Set position of each piece
                }
            }
        }
    }


    // Get reference to a Piece object
    public Piece getPiece (int col, int row) {

        return BoardPositions[col][row];
    }

    // Give access to BoardPositions
    public Piece[][] getBoardPositions () {

        return BoardPositions;
    }


    // Make a move (only called in handleCoordinates when a valid move entry has been made with Start and End tap)
    private void makeMove () {
        //Check if game is still running
        gameOver = isInCheckmate();

        // Update BoardPositions using StartCoordinates and EndCoordinates
        BoardPositions[EndCoordinates[0]][EndCoordinates[1]] = BoardPositions[StartCoordinates[0]][StartCoordinates[1]];
        BoardPositions[StartCoordinates[0]][StartCoordinates[1]] = null;
        BoardPositions[EndCoordinates[0]][EndCoordinates[1]].setPosition(EndCoordinates[0],EndCoordinates[1]);

        // Update validMoveMade
        validMoveMade = true;
    }


    // Handle coordinate info (user input) from front-end
    public void handleCoordinates (int col, int row) {

        Piece selectedPiece = BoardPositions[col][row];

        switch (tapCount) {
            case 0: //0 count is 1st move for WHITE
                if (selectedPiece == null || !selectedPiece.isWhite()) {
                    coordinatesValid = false;
                    pieceToMove = null;
                } //do nothing or print error message
                else {
                    // If it is white's turn and a white piece is tapped, then it is a valid  tap
                    tapCount++;
                    validStartTap = true;
                    coordinatesValid = true;
                    StartCoordinates[0] = col;
                    StartCoordinates[1] = row;
                    pieceToMove = selectedPiece;
                }
                break;
            case 1:
                //Get selected coordinates for checking
                EndCoordinates[0] = col;
                EndCoordinates[1] = row;
                if (selectedPiece == null) {
                    if (isValidMove(pieceToMove, EndCoordinates[0], EndCoordinates[1])) {
                        tapCount++;
                        coordinatesValid = true;
                        makeMove();
                    } else {
                        coordinatesValid = false;
                        tapCount = 0;
                    }
                }
                else if (!selectedPiece.isWhite()) { //attack mode
                    if (isValidMove(pieceToMove, EndCoordinates[0], EndCoordinates[1])) {
                        tapCount++;
                        coordinatesValid = true;
                        makeMove(); // Should be an attack
                    } else {
                        coordinatesValid = false;
                        tapCount = 0;
                    }
                }
                else {
                    coordinatesValid = false;
                    tapCount = 0;
                    }
                break;
            case 2: //2 count is 1st move for BLACK
                if (selectedPiece == null || selectedPiece.isWhite()){
                    coordinatesValid = false;
                    pieceToMove = null;
                } //do nothing or print error message
                else {
                    // If it is black's turn and a black piece is tapped, then it is a valid  tap
                    tapCount++;
                    validStartTap = true;
                    coordinatesValid = true;
                    StartCoordinates[0] = col;
                    StartCoordinates[1] = row;
                    pieceToMove = selectedPiece;
                }
                break;
            case 3: //Black's 2nd move
                //Get selected coordinates for checking
                EndCoordinates[0] = col ;
                EndCoordinates[1] = row ;

                if (selectedPiece == null) {
                    if (isValidMove(pieceToMove, EndCoordinates[0], EndCoordinates[1])) {
                        coordinatesValid = true;
                        makeMove();
                        tapCount = 0;
                    } else {
                        coordinatesValid = false;
                        tapCount = 2; //Black goes back to 1st tap
                    }
                }
                else if (selectedPiece.isWhite()) { //attack mode
                    if (isValidMove(pieceToMove, EndCoordinates[0], EndCoordinates[1])) {
                        coordinatesValid = true;
                        makeMove(); // Should be an attack
                        tapCount = 0;
                    } else {
                        coordinatesValid = false;
                        tapCount = 2; //Black back to 1st tap
                    }
                }
                else {
                    coordinatesValid = false;
                    tapCount = 2;
                }
                break;
        }
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


    // Let's UI know whether a king is checked
    public boolean isKingChecked () {

        return kingChecked;
    }


    // Get checked king position
    public int[] getCheckedKingPos () {

        return checkedKingPos;
    }


    // Check game over status
    public boolean gameOver () {

        // Determine if game is over, true if yes, false if no
        //Default return for now (CHANGE THIS LATER!!!!)
        return gameOver;
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

    public boolean isValidMove(Piece piece, int xNewPos, int yNewPos)
    {
        /* KNOWN WORKING
        -Pawns moving one or two spaces
        -Pawns taking pieces
        -Queen
        -Knight
        -Rook
        -Bishop

        KNOWN UNKNOWN WORKING
        -isKingInCheck()
         */


        //return true; // Debug
        if (piece.isAlive) //working correctly
        {
            int[] position = piece.getPosition(); //works
            int xPos = position[0];
            int yPos = position[1];

            if(piece.type.equals("King"))
            {
                if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
                {
                    return true;
                }
                else if(xNewPos == xPos + 1 && yNewPos == yPos - 1)
                {
                    return true;
                }
                else if(xNewPos == xPos - 1 && yNewPos == yPos + 1)
                {
                    return true;
                }
                else if(xNewPos == xPos - 1 && yNewPos == yPos - 1)
                {
                    return true;
                }
                else if(xNewPos == xPos && yNewPos == yPos + 1)
                {
                    return true;
                }
                else if(xNewPos == xPos && yNewPos == yPos - 1)
                {
                    return true;
                }
                else if(xNewPos == xPos + 1 && yNewPos == yPos)
                {
                    return true;
                }
                else if(xNewPos == xPos - 1 && yNewPos == yPos)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if(piece.type.equals("Queen"))
            {
                if(!isBlocked(piece, xNewPos, yNewPos))
                {
                    if(xNewPos == xPos ^ yNewPos == yPos)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 2 && yNewPos == yPos + 2)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 3 && yNewPos == yPos + 3)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 4 && yNewPos == yPos + 4)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 5 && yNewPos == yPos + 5)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 6 && yNewPos == yPos + 6)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 7 && yNewPos == yPos + 7)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 1 && yNewPos == yPos + 1)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 2 && yNewPos == yPos + 2)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 3 && yNewPos == yPos + 3)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 4 && yNewPos == yPos + 4)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 5 && yNewPos == yPos + 5)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 6 && yNewPos == yPos + 6)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 7 && yNewPos == yPos + 7)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 1 && yNewPos == yPos - 1)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 2 && yNewPos == yPos - 2)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 3 && yNewPos == yPos - 3)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 4 && yNewPos == yPos - 4)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 5 && yNewPos == yPos - 5)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 6 && yNewPos == yPos - 6)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 7 && yNewPos == yPos - 7)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 1 && yNewPos == yPos - 1)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 2 && yNewPos == yPos - 2)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 3 && yNewPos == yPos - 3)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 4 && yNewPos == yPos - 4)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 5 && yNewPos == yPos - 5)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 6 && yNewPos == yPos - 6)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 7 && yNewPos == yPos - 7)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else if(piece.type.equals("Rook"))
            {
                if(!isBlocked(piece, xNewPos, yNewPos))
                {
                        if(xNewPos == xPos ^ yNewPos == yPos) // Also have to consider rook moving to the same location. Can't allow that to happen
                    {
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else if(piece.type.equals("Bishop"))
            {
                if(!isBlocked(piece, xNewPos, yNewPos))
                {
                    boolean valid = false;
                    for(int i = 1; i < 8; i++)
                    {
                        if((xNewPos == xPos + i && yNewPos == yPos + i)
                            || (xNewPos == xPos + i && yNewPos == yPos - i)
                            || (xNewPos == xPos - i && yNewPos == yPos + i)
                            || (xNewPos == xPos - i && yNewPos == yPos - i))
                        {
                            valid = true;
                        }
                    }
                    return valid;

                    /*if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 2 && yNewPos == yPos + 2)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 3 && yNewPos == yPos + 3)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 4 && yNewPos == yPos + 4)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 5 && yNewPos == yPos + 5)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 6 && yNewPos == yPos + 6)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 7 && yNewPos == yPos + 7)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 1 && yNewPos == yPos + 1)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 2 && yNewPos == yPos + 2)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 3 && yNewPos == yPos + 3)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 4 && yNewPos == yPos + 4)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 5 && yNewPos == yPos + 5)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 6 && yNewPos == yPos + 6)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 7 && yNewPos == yPos + 7)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 1 && yNewPos == yPos - 1)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 2 && yNewPos == yPos - 2)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 3 && yNewPos == yPos - 3)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 4 && yNewPos == yPos - 4)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 5 && yNewPos == yPos - 5)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 6 && yNewPos == yPos - 6)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos + 7 && yNewPos == yPos - 7)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 1 && yNewPos == yPos - 1)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 2 && yNewPos == yPos - 2)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 3 && yNewPos == yPos - 3)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 4 && yNewPos == yPos - 4)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 5 && yNewPos == yPos - 5)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 6 && yNewPos == yPos - 6)
                    {
                        return true;
                    }
                    else if(xNewPos == xPos - 7 && yNewPos == yPos - 7)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }*/
                }
                else
                {
                    return false;
                }
                
            }
            else if(piece.type.equals("Knight"))
            {
                if(xNewPos == xPos + 2 && yNewPos == yPos + 1)
                {
                    return true;
                }
                else if(xNewPos == xPos + 2 && yNewPos == yPos - 1)
                {
                    return true;
                }
                else if(xNewPos == xPos - 2 && yNewPos == yPos + 1)
                {
                    return true;
                }
                else if(xNewPos == xPos - 2 && yNewPos == yPos - 1)
                {
                    return true;
                }
                else if(xNewPos == xPos + 1 && yNewPos == yPos + 2)
                {
                    return true;
                }
                else if(xNewPos == xPos + 1 && yNewPos == yPos - 2)
                {
                    return true;
                }
                else if(xNewPos == xPos - 1 && yNewPos == yPos + 2)
                {
                    return true;
                }
                else if(xNewPos == xPos - 1 && yNewPos == yPos - 2)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else if(piece.type.equals("Pawn"))
            {
                if(piece.isWhite())    // Edit to condition here to see if this corrects origin at bottom left issue (UI has it top left)
                {
                    if(!isBlocked(piece, xNewPos, yNewPos))
                    {
                        if(xNewPos == xPos && yNewPos == yPos - 1)
                        {
                            piece.hasMoved = true;
                            return true;
                        }
                        else if(xNewPos == xPos && yNewPos == yPos - 2 && !piece.hasMoved)
                        {
                            piece.hasMoved = true;
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else if(PawnAttacking(piece))
                    {
                        if(xNewPos == xPos + 1 && yNewPos == yPos - 1)
                        {
                            piece.hasMoved = true;
                            return true;
                        }
                        else if(xNewPos == xPos - 1 && yNewPos == yPos - 1)
                        {
                            piece.hasMoved = true;
                            return true;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    if(!piece.hasMoved && !isBlocked(piece, xNewPos, yNewPos))
                    {
                        if(xNewPos == xPos && yNewPos == yPos + 1)
                        {
                            piece.hasMoved = true;
                            return true;
                        }
                        else if(xNewPos == xPos && yNewPos == yPos + 2)
                        {
                            piece.hasMoved = true;
                            return true;
                        }
                    }
                    else if(PawnAttacking(piece))
                    {
                        if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
                        {
                            piece.hasMoved = true;
                            return true;
                        }
                        else if(xNewPos == xPos - 1 && yNewPos == yPos + 1)
                        {
                            piece.hasMoved = true;
                            return true;
                        }
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            else
            {
                return false;
            }

        }
        else
        {
            return false;
        }

        return false;
    }

    public boolean isBlocked(Piece piece, int xNewPos, int yNewPos)
    {
        int[] position = piece.getPosition();
        
        if(piece.type.equals("Pawn"))
        {
            if(piece.isWhite())
            {
                //if pawn is white
                if(position[1] - yNewPos == 1 && BoardPositions[xNewPos][yNewPos] != null)
                {
                    return true;
                }
                else if(position[1] - yNewPos == 2
                        && BoardPositions[position[0]][position[1] + 1] != null
                        && BoardPositions[position[0]][yNewPos] != null)
                {
                    //if there is a piece in front of the pawn
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(yNewPos - position[1] == 1 && BoardPositions[xNewPos][yNewPos] != null)
                {
                    return true;
                }
                else if(yNewPos - position[1] == 2
                        && BoardPositions[position[0]][position[1] - 1] != null
                        && BoardPositions[position[0]][yNewPos] != null)
                {
                    //if there is a piece in front of the pawn
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else if(piece.type.equals("Rook"))
        {
            if(yNewPos == position[1])  //if the rook is moving horizontally
            {
                if(xNewPos > position[0])   //if the rook is moving right
                {
                    for(int i = position[0] + 1; i < xNewPos; i++)
                    {
                        if(BoardPositions[i][position[1]] != null)
                        {
                            return true;
                        }
                    }
                    return false;
                }
                else    //if the rook is moving left
                {
                    for(int i = position[0] - 1; i > xNewPos; i--)
                    {
                        if(BoardPositions[i][position[1]] != null)
                        {
                            return true;
                        }
                    }
                    return false;
                }
            }
            else    //if the rook is moving vertically
            {
                if(yNewPos > position[1]) //if the rook is moving up
                {
                    
                    for(int i = position[1] + 1; i < yNewPos; i++)
                    {
                        if(BoardPositions[position[0]][i] != null)
                        {
                            return true;
                        }
                    }
                    return false;
                }
                else     //if the rook is moving down
                {
                    for(int i = position[1] + 1; i > xNewPos; i--)
                    {
                        if(BoardPositions[position[1]][i] != null)
                        {
                            return true;
                        }
                    }
                    return false;
                }
            }
        }
        else if(piece.type.equals("Bishop"))
        {
            int spaces = Math.abs(position[0] - xNewPos);
            boolean movingRight = false;
            boolean movingUp = false;

            if(xNewPos > position[0])
            {
                movingRight = true;
            }
            if(yNewPos < position[1])
            {
                movingUp = true;
            }

            if(movingRight)   //if the bishop is moving right
            {
                if(movingUp)   //if the bishop is moving up and to the left
                {
                    for (int i = 1; i < spaces; i++)
                    {
                        if(BoardPositions[position[0] + i][position[1] - i] != null) {
                            return true;
                        }
                    }
                    return false;
                }
                else //if the bishop is moving down and to the right
                {
                    for (int i = 1; i < spaces; i++)
                    {
                        if(BoardPositions[position[0] + i][position[1] + i] != null) {
                            return true;
                        }
                    }
                    return false;
                }
            }
            else // if the bishop is moving left
            {
                if(movingUp)   //if the bishop is moving up and to the left
                {
                    for (int i = 1; i < spaces; i++)
                    {
                        if(BoardPositions[position[0] - i][position[1] - i] != null) {
                            return true;
                        }
                    }
                    return false;
                }
                else //if the bishop is moving down and to the left
                {
                    for (int i = 1; i < spaces; i++)
                    {
                        if(BoardPositions[position[0] - i][position[1] + i] != null) {
                            return true;
                        }
                    }
                    return false;
                }
            }

        }
        else if(piece.type.equals("Queen"))
        {
            if(xNewPos == position[0] ^ yNewPos == position[1]) //if the queen is moving horizontally or vertically
            {
                if(yNewPos == position[1])  //if the queen is moving horizontally
                {
                    if(xNewPos > position[0])   //if the queen is moving right
                    {
                        for(int i = position[0] + 1; i < xNewPos; i++)
                        {
                            if(BoardPositions[i][position[1]] != null)
                            {
                                return true;
                            }
                        }
                        return false;
                    }
                    else    //if the queen is moving left
                    {
                        for(int i = position[0] - 1; i > xNewPos; i--)
                        {
                            if(BoardPositions[i][position[1]] != null)
                            {
                                return true;
                            }
                        }
                        return false;
                    }
                }
                else    //if the queen is moving vertically
                {
                    if(yNewPos > position[1]) //if the queen is moving down
                    {
                        
                        for(int i = position[1] + 1; i < yNewPos; i++)
                        {
                            if(BoardPositions[position[0]][i] != null)
                            {
                                return true;
                            }
                        }
                        return false;
                    }
                    else     //if the queen is moving up
                    {
                        for(int i = position[1] - 1; i > yNewPos; i--)
                        {
                            if(BoardPositions[position[0]][i] != null)
                            {
                                return true;
                            }
                        }
                        return false;
                    }
                }
            }
            else    //if the queen is moving diagonally
            {
                int spaces = Math.abs(position[0] - xNewPos);
                boolean movingRight = false;
                boolean movingUp = false;

                if(xNewPos > position[0])
                {
                    movingRight = true;
                }
                if(yNewPos < position[1])
                {
                    movingUp = true;
                }

                if(movingRight)   //if the queen is moving right
                {
                    if(movingUp)   //if the queen is moving up and to the right
                    {
                        for (int i = 1; i < spaces; i++)
                        {
                            if(BoardPositions[position[0] + i][position[1] - i] != null) {
                                return true;
                            }
                        }
                        return false;
                    }
                    else //if the queen is moving down and to the right
                    {
                        for (int i = 1; i < spaces; i++)
                        {
                            if(BoardPositions[position[0] + i][position[1] + i] != null) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
                else // if the queen is moving left
                {
                    if(movingUp)   //if the queen is moving up and to the left
                    {
                        for (int i = 1; i < spaces; i++)
                        {
                            if(BoardPositions[position[0] - i][position[1] - i] != null) {
                                return true;
                            }
                        }
                        return false;
                    }
                    else //if the queen is moving down and to the left
                    {
                        for (int i = 1; i < spaces; i++)
                        {
                            if(BoardPositions[position[0] - i][position[1] + i] != null) {
                                return true;
                            }
                        }
                        return false;
                    }
                }

            }
        }
        else if(piece.type.equals("King"))
        {
            if(BoardPositions[xNewPos][yNewPos] != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public boolean PawnAttacking(Piece piece)
    {
        if(!piece.type.equals("Pawn"))
        {
            //Return false for all non-Pawn pieces
            return false;
        }
        else
        {
            int[] position = piece.getPosition();
            if(piece.isWhite())
            {
                //if pawn is white
                if(BoardPositions[position[0] + 1][position[1] - 1] != null || BoardPositions[position[0] - 1][position[1] - 1] != null)
                {
                    //if there is a piece in front of the pawn
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(BoardPositions[position[0] + 1][position[1] + 1] != null || BoardPositions[position[0] - 1][position[1] + 1] != null)
                {
                    //if there is a piece in front of the pawn
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    public boolean isKingInCheck(boolean color, int x, int y)
    {
        //Hardcoded to false until isValidMove works
        //return false;

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                Piece temp = BoardPositions[i][j];
                if(BoardPositions[i][j] != null && (color == temp.isWhite()))
                {

                    if(isValidMove(temp,i,j))
                    {
                        kingChecked = true;
                        checkedKingPos[0] = x;
                        checkedKingPos[1] = y;
                        return true;
                    }
                }
            }
        }

        kingChecked = false;
        return false;

        /*if(color)
        {
            boolean[] bChecks = new boolean[16];
            bChecks[0] = isValidMove(bPawn1,x,y);
            bChecks[1] = isValidMove(bPawn2,x,y);
            bChecks[2] = isValidMove(bPawn3,x,y);
            bChecks[3] = isValidMove(bPawn4,x,y);
            bChecks[4] = isValidMove(bPawn5,x,y);
            bChecks[5] = isValidMove(bPawn6,x,y);
            bChecks[6] = isValidMove(bPawn7,x,y);
            bChecks[7] = isValidMove(bPawn8,x,y);
            bChecks[8] = isValidMove(bKing,x,y);
            bChecks[9] = isValidMove(bQueen,x,y);
            bChecks[10] = isValidMove(bRook1,x,y);
            bChecks[11] = isValidMove(bRook2,x,y);
            bChecks[12] = isValidMove(bBishop1,x,y);
            bChecks[13] = isValidMove(bBishop2,x,y);
            bChecks[14] = isValidMove(bKnight1,x,y);
            bChecks[15] = isValidMove(bKnight2,x,y);

            for(int i = 0; i < 16; i++)
            {
                if (bChecks[i])
                {
                    return true;
                }
            }

            return false;
        }
        else
        {
            boolean[] wChecks = new boolean[16];
            wChecks[0] = isValidMove(wPawn1,x,y);
            wChecks[1] = isValidMove(wPawn2,x,y);
            wChecks[2] = isValidMove(wPawn3,x,y);
            wChecks[3] = isValidMove(wPawn4,x,y);
            wChecks[4] = isValidMove(wPawn5,x,y);
            wChecks[5] = isValidMove(wPawn6,x,y);
            wChecks[6] = isValidMove(wPawn7,x,y);
            wChecks[7] = isValidMove(wPawn8,x,y);
            wChecks[8] = isValidMove(wKing,x,y);
            wChecks[9] = isValidMove(wQueen,x,y);
            wChecks[10] = isValidMove(wRook1,x,y);
            wChecks[11] = isValidMove(wRook2,x,y);
            wChecks[12] = isValidMove(wBishop1,x,y);
            wChecks[13] = isValidMove(wBishop2,x,y);
            wChecks[14] = isValidMove(wKnight1,x,y);
            wChecks[15] = isValidMove(wKnight2,x,y);

            for(int i = 0; i < 16; i++)
            {
                if (wChecks[i])
                {
                    return true;
                }
            }

            return false;
        }*/
    }

    public boolean isInCheckmate()
    {
        return false;
        /*int wPosition[] = wKing.getPosition();
        int bPosition[] = bKing.getPosition();

        // if white king is in check
        if(isKingInCheck(true,wPosition[0],wPosition[1]) && pieceCanMove(wKing))
        {
            gameOver = false;
            return false;
        }
        else if(isKingInCheck(true,wPosition[0],wPosition[1]) && !pieceCanMove(wKing))
        {
            gameOver = true;
            return true;
        }
        else if(isKingInCheck(false,wPosition[0],wPosition[1]) && pieceCanMove(bKing))
        {
            gameOver = false;
            return false;
        }
        else if(isKingInCheck(false,wPosition[0],wPosition[1]) && !pieceCanMove(bKing))
        {
            gameOver = true;
            return true;
        }
        else
        {
            gameOver = false;
            return false;
        }*/
    }
}
