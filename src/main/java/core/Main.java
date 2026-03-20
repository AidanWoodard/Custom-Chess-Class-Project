package core;

import game.HumanPlayer;
import game.Match;
// import state.ConventionalBoardFactory;
// import ui.Console;
import state.CustomPieceBoardFactory;
import ui.CustomPieceConsole;
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
     * CUSTOM PIECE: we create an object using CustomPieceBoardFactory rather than the conventional 
     * board. Also, we use createCustom instead of create so that both create and createCustom can
     * be static. The only difference is that createCustom places our custom bishop pieces.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // var board = ConventionalBoardFactory.create();
        var board = CustomPieceBoardFactory.createCustom();
        var player1 = new HumanPlayer(Color.WHITE, board);
        var player2 = new HumanPlayer(Color.BLACK, board);
        var console = new CustomPieceConsole();
        var match = new Match(player1, player2, board, new rules.Rulebook(), console);
        match.start();
    }
}
