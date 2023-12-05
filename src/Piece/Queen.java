package Piece;
import Board.Board;
public class Queen extends Piece {
    public Queen(PieceColor color, String ch) {
        super(color, ch);
    }
    @Override
    public boolean isValidMove(Board board, int startX, int startY, int endX, int endY) {
        // Проверка, что начальные и конечные координаты находятся в пределах доски
        if (!isWithinBoard(startX, startY) || !isWithinBoard(endX, endY)) {
            return false;
        }

        // Проверка, что начальная и конечная ячейки не совпадают
        if (startX == endX && startY == endY) {
            return false;
        }

        // Проверка, что ферзь не препятствован другими фигурами по горизонтали, вертикали или диагонали
        if (!isClearHorizontalPath(board, startX, startY, endX, endY) ||
                !isClearVerticalPath(board, startX, startY, endX, endY) ||
                !isClearDiagonalPath(board, startX, startY, endX, endY)) {
            return false;
        }

        return true;
    }

    private boolean isWithinBoard(int x, int y) {
        return x >= 0 && x < 9 && y >= 0 && y < 9;
    }

    private boolean isClearHorizontalPath(Board board, int startX, int startY, int endX, int endY) {
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);

        for (int x = minX + 1; x < maxX; x++) {
            if (board.getPiece(x, startY) != null) {
                return false;
            }
        }

        return true;
    }

    private boolean isClearVerticalPath(Board board, int startX, int startY, int endX, int endY) {
        int minY = Math.min(startY, endY);
        int maxY = Math.max(startY, endY);

        for (int y = minY + 1; y < maxY; y++) {
            if (board.getPiece(startX, y) != null) {
                return false;
            }
        }

        return true;
    }

    private boolean isClearDiagonalPath(Board board, int startX, int startY, int endX, int endY) {
        int minX = Math.min(startX, endX);
        int maxX = Math.max(startX, endX);
        int minY = Math.min(startY, endY);
        int maxY = Math.max(startY, endY);

        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);

        if (dx != dy) {
            return false;
        }

        int stepX = startX < endX ? 1 : -1;
        int stepY = startY < endY ? 1 : -1;

        int x = startX + stepX;
        int y = startY + stepY;

        while (x != endX || y != endY) {
            if (board.getPiece(x, y) != null) {
                return false;
            }

            x += stepX;
            y += stepY;
        }

        return true;
    }
}