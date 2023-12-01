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


    public void move(int xNewPos, int yNewPos)
    {
        int xPos = xNewPos;
        int yPos = yNewPos;
        boolean hasMoved = false; // should hasMoved be set to true here?
    }


    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
        return true;
    }
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
        return position;
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

    @Override
    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
        if(!hasMoved && !isBlocked)
        {
            if(xNewPos == xPos && yNewPos == yPos + 1)
            {
                return true;
            }
            else if(xNewPos == xPos && yNewPos == yPos + 2)
            {
                return true;
            }
        }
        else if(isAttacking)
        {
            if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
            {
                return true;
            }
            else if(xNewPos == xPos - 1 && yNewPos == yPos + 1)
            {
                return true;
            }
        }
        else
        {
            return false;
        }

        // Default return statement so I can compile the code, feel free to edit this ~Xiang
        return false;
    }
}

class Rook extends Piece
{
    public Rook(boolean color) {

        super(color);
        type = "Rook";
    }

    @Override
    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
        if(xNewPos == xPos || yNewPos == yPos) // Also have to consider rook moving to the same location. Can't allow that to happen
        {
            return true;
        }
        return false;
    }
}

class Knight extends Piece
{
    public Knight(boolean color) {

        super(color);
        type = "Knight";
    }

    @Override
    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
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
}

class Bishop extends Piece
{
    public Bishop(boolean color) {

        super (color);
        type = "Bishop";
    }

    @Override
    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
        if(xNewPos == xPos + 1 && yNewPos == yPos + 1)
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
}

class Queen extends Piece
{
    public Queen(boolean color) {

        super(color);
        type = "Queen";
    }

    @Override
    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
        if(xNewPos == xPos || yNewPos == yPos)
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
}

class King extends Piece
{
    boolean isChecked = false;
    boolean isCheckmated = false;

    public King(boolean color) {

        super (color);
        type = "King";
    }

    @Override
    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
        if(!isChecked && !isCheckmated)
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
        // else if(isChecked && !isCheckmated)
        // {
        //     //add functionailty for checking if king is in check and then moving it out
        //     return true; //delete this later
        // }
        // else if(isCheckmated)
        // {
        //     //add functionality for checking if king is in checkmate and ending game
        //     return false; //delete this later
        // }
        else return false;
    }


}