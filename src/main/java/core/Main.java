package core;

import java.beans.Customizer;

import game.HumanPlayer;
import game.Match;
import state.ConventionalBoardFactory;
import state.CustomPieceBoardFactory;
import ui.Console;
import util.Color;

/**
 * Main entry point for the Chess application.
 * Initializes a chess game between two human players on a conventional chess board.
 */
public class Main {
    /**
     * Main method that starts a chess game.
     * Creates a standard 8x8 chess board, initializes two human players,
     * and starts a match between them.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // var board = ConventionalBoardFactory.create();
        var board = CustomPieceBoardFactory.createCustom();
        var player1 = new HumanPlayer(Color.WHITE, board);
        var player2 = new HumanPlayer(Color.BLACK, board);
        var console = new Console();
        var match = new Match(player1, player2, board, new rules.Rulebook(), console);
        match.start();
    }
}
