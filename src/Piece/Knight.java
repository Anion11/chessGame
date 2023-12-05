package Piece;
import Board.Board;
public class Knight extends Piece {
    public Knight(PieceColor color, String ch) {
        super(color, ch);
    }

    @Override
    public boolean isValidMove(Board board, int startX, int startY, int endX, int endY) {
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        if ((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)) {
            return true;
        }

        return false;
    }
}