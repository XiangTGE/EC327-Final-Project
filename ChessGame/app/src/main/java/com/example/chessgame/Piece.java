class Piece {
    bool color;
    bool hasMoved;
    bool isAlive;
    bool isAttacking;
    string type;
    int xPos;
    int yPos;

    public void move(int xNewPos, int yNewPos)
    {
        int xPos = xNewPos;
        int yPos = yNewPos;
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
}

class Pawn extends Piece
{   
    public Pawn() {
        type = "Pawn";
    }

    @Override
    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
        if(!hasMoved)
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
    }
}

class Rook extends Piece
{
    public Rook() {
        type = "Rook";
    }

    @Override
    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
        if(xNewPos == xPos || yNewPos == yPos)
        {
            return true;
        }
        return false;
    }
}

class Knight extends Piece
{
    public Knight() {
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
    public Bishop() {
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
    public Queen() {
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
    bool isChecked = false;
    bool isCheckmated = false;

    public King() {
        type = "King";
    }

    @Override
    public boolean isValidMove(int xNewPos, int yNewPos)
    {
        //check if move is valid
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
}