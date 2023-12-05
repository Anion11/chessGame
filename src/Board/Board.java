package Board;

import Piece.Piece;
import Piece.Pawn;
import Piece.Rook;
import Piece.Knight;
import Piece.Bishop;
import Piece.Queen;
import Piece.King;
import Piece.PieceColor;
import Move.Move;
public class Board {
    private Piece[][] pieces;
    public Board() {
        resetBoard();
    }
    private void resetBoard() {
        pieces = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            pieces[1][i] = new Pawn(PieceColor.WHITE, "P");
            pieces[6][i] = new Pawn(PieceColor.BLACK, "P^");
        }

        pieces[0][0] = new Rook(PieceColor.WHITE, "R");
        pieces[0][1] = new Knight(PieceColor.WHITE, "N");
        pieces[0][2] = new Bishop(PieceColor.WHITE, "B");
        pieces[0][3] = new Queen(PieceColor.WHITE, "Q");
        pieces[0][4] = new King(PieceColor.WHITE, "K");
        pieces[0][5] = new Bishop(PieceColor.WHITE, "B");
        pieces[0][6] = new Knight(PieceColor.WHITE, "N");
        pieces[0][7] = new Rook(PieceColor.WHITE, "R");

        pieces[7][0] = new Rook(PieceColor.BLACK, "R^");
        pieces[7][1] = new Knight(PieceColor.BLACK, "N^");
        pieces[7][2] = new Bishop(PieceColor.BLACK, "B^");
        pieces[7][3] = new Queen(PieceColor.BLACK, "Q^");
        pieces[7][4] = new King(PieceColor.BLACK, "K^");
        pieces[7][5] = new Bishop(PieceColor.BLACK, "B^");
        pieces[7][6] = new Knight(PieceColor.BLACK, "N^");
        pieces[7][7] = new Rook(PieceColor.BLACK, "R^");

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++){
                pieces[i][j] = null;
            }
        }
    }
    public Piece getPiece(int x, int y) {
        return pieces[x][y];
    }
    public void makeMove(Move move) {
        int startX = move.getStartX();
        int startY = move.getStartY();
        int endX = move.getEndX();
        int endY = move.getEndY();

        Piece piece = pieces[startX][startY];
        pieces[startX][startY] = null;
        pieces[endX][endY] = piece;
    }
}
