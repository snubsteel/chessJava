package piece;

import main.GamePanel;

public class Queen extends Piece {

    public Queen(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE) {
            image = getImage("/piece_images/w-queen");
        } else {
            image = getImage("/piece_images/b-queen");
        }
    }

}
