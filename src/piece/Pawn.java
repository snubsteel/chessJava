package piece;

import main.GamePanel;

public class Pawn extends Piece {

    public Pawn(int color, int col, int row) {
        super(color, col, row);

        if (color == GamePanel.WHITE) {
            image = getImage("/piece_images/w-pawn");
        } else {
            image = getImage("/piece_images/b-pawn");
        }
    }

    public boolean canMove(int targetCol, int targetRow) {

        if (isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false) {

            // Define the move value based on its color
            int moveValue;
            if (color == GamePanel.WHITE) {
                moveValue = -1;
            } else {
                moveValue = 1;
            }

            // Check the hitting piece
            hittingP = getHittingP(targetCol, targetRow);

            // 1 square movement
            if (targetCol == preCol && targetRow == preRow + moveValue && hittingP == null) {
                return true;
            }
            // 2 squares movement (only if the pawn hasn't moved yet)
            if (targetCol == preCol && targetRow == preRow + moveValue * 2 && hittingP == null && !moved) {
                // Calculate intermediate row
                int intermediateRow = preRow + moveValue;

                // Check if the intermediate square is unoccupied
                if (getHittingP(preCol, intermediateRow) == null) {
                    return true;
                }
            }
            // Diagonal movement & Capture (if a piece is on a square diagonally in front of it)
            if (Math.abs(targetCol - preCol) == 1 && targetRow == preRow + moveValue && hittingP != null &&
                    hittingP.color != color) {
                        return true;
                    }
        }
        return false;
    }

}
