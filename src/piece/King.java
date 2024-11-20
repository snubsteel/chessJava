package piece;

import main.GamePanel;

public class King extends Piece {

    public King(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE) {
            image = getImage("/piece_images/w-king");
        } else {
            image = getImage("/piece_images/b-king");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {

        if (isWithinBoard(targetCol, targetRow)) {

            if(Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1 || 
                    Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 1) {

                if(isValidSquare(targetCol, targetRow)) {
                    return true;
                }
            }

            // CASTLING
            if (moved == false) {

                // Right castling
                if (targetCol == preCol + 2 && targetRow == preRow && pieceIsOnStraightLine(targetCol, targetRow) == false) {
                    for (Piece piece : GamePanel.simPieces) {
                        if(piece.col == preCol + 3 && piece.row == preRow && piece.moved == false) {
                            GamePanel.castlingP = piece;
                            return true;
                        }
                    }
                }
                // Left castling
                if (targetCol == preCol - 2 && targetRow == preRow && pieceIsOnStraightLine(targetCol, targetRow) == false) {
                    
                }
            }
        }
        return false;
    }
}
