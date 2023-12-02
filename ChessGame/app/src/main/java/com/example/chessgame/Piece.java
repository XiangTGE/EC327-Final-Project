package com.example.chessgame;
/*
//////  THINGS TO IMPLEMENT AND/OR CONSIDER///////
Board refresh function.
    ** After each move, the board should be refreshed to reflect the new positions of the pieces.
        This function should be called after each move.
        This function should also be called when the board is first initialized.

    ** The hasMoved variable should be set to true after a piece has moved ??
    ** The isAlive variable should be set to false after a piece has been killed ??
        - Would it make more sense to call a destructor on that object?
    ** The isAttacking variable should be set to true after a piece has attacked ??
    ** isBlocked is not fully fleshed out yet.
        - Should this be folded in to isValidMove?


 */
public class Piece {
    boolean color;
    boolean hasMoved;
    boolean isAlive;
    boolean isAttacking;
    boolean isBlocked;
    String type;
    int xPos;
    int yPos;

    // Constructor of Piece class
    // true if color is white, false if color is black
    public Piece (boolean color) {

        this.color = color;
    }


    // public void move(int xNewPos, int yNewPos)
    // {
    //     int xPos = xNewPos;
    //     int yPos = yNewPos;
    //     boolean hasMoved = false; // should hasMoved be set to true here?
    // }


    // public boolean isValidMove(int xNewPos, int yNewPos)
    // {
    //     //check if move is valid
    //     return true;
    // }
    public void kill()
    {
        isAlive = false;
    }
    public boolean isBlocked()
    {
        //check if piece is blocked
        return false;
    }
    public int[] getPosition()
    {
        int position[] = {xPos, yPos};
        
//        for(int i = 0; i < 8; i++)
//        {
//            for(int j = 0; j < 8; i++)
//            {
//                if(Board.board[i][j] == this)
//                {
//                    position[0] = i;
//                    position[1] = j;
//                }
//            }
//        }
        
        return position;
    }

    public void setPosition(int xNewPos, int yNewPos)
    {
        xPos = xNewPos;
        yPos = yNewPos;
    }


    // Get color of piece (1 if white, 0 if black)
    boolean isWhite () {

        return color;
    }


}

class Pawn extends Piece
{   
    public Pawn(boolean color) {

        super(color);
        type = "Pawn";
    }

    // @Override
    // public boolean isValidMove(int xNewPos, int yNewPos)
    // {
    //     //check if move is valid
    //     if(!hasMoved && !isBlocked)
    //     {
    //         if(xNewPos == xPos && yNewPos == yPos + 1)
    //         {
    //             return true;
    //         }
    //         else if(xNewPos == xPos && yNewPos == yPos + 2)
    //         {
    //             return true;
    //         }
    //     }
    //     else if(isAttacking)
    //     {
    //         if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
    //         {
    //             return true;
    //         }
    //         else if(xNewPos == xPos - 1 && yNewPos == yPos + 1)
    //         {
    //             return true;
    //         }
    //     }
    //     else
    //     {
    //         return false;
    //     }

    //     // Default return statement so I can compile the code, feel free to edit this ~Xiang
    //     return false;
    // }
}

class Rook extends Piece
{
    public Rook(boolean color) {

        super(color);
        type = "Rook";
    }

    // @Override
    // public boolean isValidMove(int xNewPos, int yNewPos)
    // {
    //     //check if move is valid
    //     if(xNewPos == xPos || yNewPos == yPos) // Also have to consider rook moving to the same location. Can't allow that to happen
    //     {
    //         return true;
    //     }
    //     return false;
    // }
}

class Knight extends Piece
{
    public Knight(boolean color) {

        super(color);
        type = "Knight";
    }

    // @Override
    // public boolean isValidMove(int xNewPos, int yNewPos)
    // {
    //     //check if move is valid
    //     if(xNewPos == xPos + 2 && yNewPos == yPos + 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 2 && yNewPos == yPos - 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 2 && yNewPos == yPos + 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 2 && yNewPos == yPos - 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 1 && yNewPos == yPos + 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 1 && yNewPos == yPos - 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 1 && yNewPos == yPos + 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 1 && yNewPos == yPos - 2)
    //     {
    //         return true;
    //     }
    //     else
    //     {
    //         return false;
    //     }
    // }
}

class Bishop extends Piece
{
    public Bishop(boolean color) {

        super (color);
        type = "Bishop";
    }

    // @Override
    // public boolean isValidMove(int xNewPos, int yNewPos)
    // {
    //     //check if move is valid
    //     if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 2 && yNewPos == yPos + 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 3 && yNewPos == yPos + 3)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 4 && yNewPos == yPos + 4)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 5 && yNewPos == yPos + 5)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 6 && yNewPos == yPos + 6)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 7 && yNewPos == yPos + 7)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 1 && yNewPos == yPos + 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 2 && yNewPos == yPos + 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 3 && yNewPos == yPos + 3)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 4 && yNewPos == yPos + 4)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 5 && yNewPos == yPos + 5)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 6 && yNewPos == yPos + 6)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 7 && yNewPos == yPos + 7)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 1 && yNewPos == yPos - 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 2 && yNewPos == yPos - 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 3 && yNewPos == yPos - 3)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 4 && yNewPos == yPos - 4)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 5 && yNewPos == yPos - 5)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 6 && yNewPos == yPos - 6)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 7 && yNewPos == yPos - 7)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 1 && yNewPos == yPos - 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 2 && yNewPos == yPos - 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 3 && yNewPos == yPos - 3)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 4 && yNewPos == yPos - 4)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 5 && yNewPos == yPos - 5)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 6 && yNewPos == yPos - 6)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 7 && yNewPos == yPos - 7)
    //     {
    //         return true;
    //     }
    //     else
    //     {
    //         return false;
    //     }
    // }
}

class Queen extends Piece
{
    public Queen(boolean color) {

        super(color);
        type = "Queen";
    }

    // @Override
    // public boolean isValidMove(int xNewPos, int yNewPos)
    // {
    //     //check if move is valid
    //     if(xNewPos == xPos || yNewPos == yPos)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 2 && yNewPos == yPos + 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 3 && yNewPos == yPos + 3)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 4 && yNewPos == yPos + 4)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 5 && yNewPos == yPos + 5)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 6 && yNewPos == yPos + 6)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 7 && yNewPos == yPos + 7)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 1 && yNewPos == yPos + 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 2 && yNewPos == yPos + 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 3 && yNewPos == yPos + 3)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 4 && yNewPos == yPos + 4)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 5 && yNewPos == yPos + 5)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 6 && yNewPos == yPos + 6)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 7 && yNewPos == yPos + 7)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 1 && yNewPos == yPos - 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 2 && yNewPos == yPos - 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 3 && yNewPos == yPos - 3)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 4 && yNewPos == yPos - 4)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 5 && yNewPos == yPos - 5)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 6 && yNewPos == yPos - 6)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos + 7 && yNewPos == yPos - 7)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 1 && yNewPos == yPos - 1)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 2 && yNewPos == yPos - 2)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 3 && yNewPos == yPos - 3)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 4 && yNewPos == yPos - 4)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 5 && yNewPos == yPos - 5)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 6 && yNewPos == yPos - 6)
    //     {
    //         return true;
    //     }
    //     else if(xNewPos == xPos - 7 && yNewPos == yPos - 7)
    //     {
    //         return true;
    //     }
    //     else
    //     {
    //         return false;
    //     }
    // }
}

class King extends Piece
{
    boolean isChecked = false;
    boolean isCheckmated = false;

    public King(boolean color) {

        super (color);
        type = "King";
    }


    // Return whether king is in check
    public void setKingIsChecked(boolean kingChecked) {

        isChecked = kingChecked;
    }


    // Return whether king is checkmated
    public boolean kingCheckmated () {

        return isCheckmated;
    }


    // @Override
    // public boolean isValidMove(int xNewPos, int yNewPos)
    // {
    //     //check if move is valid
    //     if(!isChecked && !isCheckmated)
    //     {
    //         if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
    //         {
    //             return true;
    //         }
    //         else if(xNewPos == xPos + 1 && yNewPos == yPos - 1)
    //         {
    //             return true;
    //         }
    //         else if(xNewPos == xPos - 1 && yNewPos == yPos + 1)
    //         {
    //             return true;
    //         }
    //         else if(xNewPos == xPos - 1 && yNewPos == yPos - 1)
    //         {
    //             return true;
    //         }
    //         else if(xNewPos == xPos && yNewPos == yPos + 1)
    //         {
    //             return true;
    //         }
    //         else if(xNewPos == xPos && yNewPos == yPos - 1)
    //         {
    //             return true;
    //         }
    //         else if(xNewPos == xPos + 1 && yNewPos == yPos)
    //         {
    //             return true;
    //         }
    //         else if(xNewPos == xPos - 1 && yNewPos == yPos)
    //         {
    //             return true;
    //         }
    //         else
    //         {
    //             return false;
    //         }
    //     }
    //     else if(isChecked)
    //     {
    //         //add functionailty for checking if king is in check and then moving it out
            
    //         //check if new position would leave the king in check
    //         //check all pieces of the opposite color to see if they can attack the king at the new pos
    //         if(color)
    //         {
    //             //check if any black pieces can attack the king at the new pos
    //             boolean[] bAttack = new boolean[16];
    //             bAttack[0] = bRook1.isValidMove(xNewPos,yNewPos);
    //             bAttack[1] = bKnight1.isValidMove(xNewPos,yNewPos);
    //             bAttack[2] = bBishop1.isValidMove(xNewPos,yNewPos);
    //             bAttack[3] = bQueen.isValidMove(xNewPos,yNewPos);
    //             bAttack[4] = bKing.isValidMove(xNewPos,yNewPos);
    //             bAttack[5] = bBishop2.isValidMove(xNewPos,yNewPos);
    //             bAttack[6] = bKnight2.isValidMove(xNewPos,yNewPos);
    //             bAttack[7] = bRook2.isValidMove(xNewPos,yNewPos);
    //             bAttack[8] = bPawn1.isValidMove(xNewPos,yNewPos);
    //             bAttack[9] = bPawn2.isValidMove(xNewPos,yNewPos);
    //             bAttack[10] = bPawn3.isValidMove(xNewPos,yNewPos);
    //             bAttack[11] = bPawn4.isValidMove(xNewPos,yNewPos);
    //             bAttack[12] = bPawn5.isValidMove(xNewPos,yNewPos);
    //             bAttack[13] = bPawn6.isValidMove(xNewPos,yNewPos);
    //             bAttack[14] = bPawn7.isValidMove(xNewPos,yNewPos);
    //             bAttack[15] = bPawn8.isValidMove(xNewPos,yNewPos);

    //             for(int i = 0; i < 16; i++)
    //             {
    //                 if(bAttack[i])
    //                 {
    //                     return false;
    //                 }
    //             }

    //         }
    //         else
    //         {
    //             boolean[] wAttack = new boolean[16];
    //             wAttack[0] = wRook1.isValidMove(xNewPos,yNewPos);
    //             wAttack[1] = wKnight1.isValidMove(xNewPos,yNewPos);
    //             wAttack[2] = wBishop1.isValidMove(xNewPos,yNewPos);
    //             wAttack[3] = wQueen.isValidMove(xNewPos,yNewPos);
    //             wAttack[4] = wKing.isValidMove(xNewPos,yNewPos);
    //             wAttack[5] = wBishop2.isValidMove(xNewPos,yNewPos);
    //             wAttack[6] = wKnight2.isValidMove(xNewPos,yNewPos);
    //             wAttack[7] = wRook2.isValidMove(xNewPos,yNewPos);
    //             wAttack[8] = wPawn1.isValidMove(xNewPos,yNewPos);
    //             wAttack[9] = wPawn2.isValidMove(xNewPos,yNewPos);
    //             wAttack[10] = wPawn3.isValidMove(xNewPos,yNewPos);
    //             wAttack[11] = wPawn4.isValidMove(xNewPos,yNewPos);
    //             wAttack[12] = wPawn5.isValidMove(xNewPos,yNewPos);
    //             wAttack[13] = wPawn6.isValidMove(xNewPos,yNewPos);
    //             wAttack[14] = wPawn7.isValidMove(xNewPos,yNewPos);
    //             wAttack[15] = wPawn8.isValidMove(xNewPos,yNewPos);

    //             for(int i = 0; i < 16; i++)
    //             {
    //                 if(wAttack[i])
    //                 {
    //                     return false;
    //                 }
    //             }
    //         }
    //         return true; //King successfully leaves check
    //     }
    //     else if(isCheckmated)
    //     {
    //         //if in checkmate, there are no valid moves
    //         return false;
    //     }
    //     else
    //     {
    //         //if none of the above, return false
    //         return false;
    //     }
    // }


}