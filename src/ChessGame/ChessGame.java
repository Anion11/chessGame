package ChessGame;

import Board.ClassicBoard;
import Board.FisherBoard;
import Board.Board;
import Piece.*;
import Player.Player;
import Move.Move;

import java.util.Objects;

public class ChessGame {
    private Board chessBoard;
    private Player[] players;
    private int currentPlayerIndex = 0;
    public ChessGame(String game) {
        if (Objects.equals(game, "Classic")) initClassicGame();
        else if (Objects.equals(game, "Fisher")) initFisherGame();
    }

    private void initClassicGame() {
        chessBoard = new ClassicBoard();
        System.out.println(chessBoard);
        players = new Player[2];
        players[0] = new Player("Player.Player 1", PieceColor.WHITE);
        players[1] = new Player("Player.Player 2", PieceColor.BLACK);
    }
    private void initFisherGame() {
        chessBoard = new FisherBoard();
        players = new Player[2];
        players[0] = new Player("Player.Player 1", PieceColor.WHITE);
        players[1] = new Player("Player.Player 2", PieceColor.BLACK);
    }
    public void startGame() {
        Player currentPlayer = getCurrentPlayer();
        while (!isGameEnd()) {
            printChessBoard();
            currentPlayer = getCurrentPlayer();
            Move move = currentPlayer.getMove(chessBoard);
            if (move.getEndGame()) {
                switchPlayers();
                currentPlayer = getCurrentPlayer();
                break;
            };
            chessBoard.makeMove(move);
            switchPlayers();
        }
        displayGameResult(currentPlayer);
    }
    public void printChessBoard() {
        System.out.printf("   %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s", "A", "B", "C", "D", "E", "F", "G", "H");
        System.out.println();
        for (int row = 7; row >= 0; row--) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < 8; col++) {
                if (chessBoard.getPiece(row, col) != null) System.out.print("\u001B[32m");
                else System.out.print("\u001B[0m");
                System.out.printf(" %-3s", chessBoard.getPiece(row, col) != null ? chessBoard.getPiece(row, col).getChar() : (row + col) % 2 == 0 ? "■" : "□");
            }
            System.out.print("\u001B[0m");
            System.out.print(" " + (row + 1));
            System.out.println();
        }
        System.out.printf("   %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s", "A", "B", "C", "D", "E", "F", "G", "H");
        System.out.println();
    }
    private void displayGameResult(Player winner) {
        if (winner != null) {
            System.out.println("Поздравляем, " + winner.getName() + " выиграл!");
        } else {
            System.out.println("Ничья");
        }
    }
    private Player getWinner() {
        return new Player("Никита", PieceColor.WHITE);
    }
    private boolean isGameEnd() {
        // Логика проверки окончания игры (например, шах-мат, пат и т.д.)
        return false;
    }

    private Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }
    private void switchPlayers() {
        if (currentPlayerIndex == 1) currentPlayerIndex--;
        else currentPlayerIndex++;
    }
}
