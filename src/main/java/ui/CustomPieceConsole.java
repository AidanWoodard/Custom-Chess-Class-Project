package ui;

import java.util.ArrayList;
import java.util.Scanner;

import game.Player;
import pieces.CustomBishop;
import pieces.Piece;
import rules.Move;
import state.Board;
import util.Color;

public class CustomPieceConsole extends Console {
    // make sure to keep this reference
    private ArrayList<Piece> bishops;
    private Piece partner;

        /**
     * The custom console helps handle the dual-piece motion of the custom bishop piece.
     * When one bishop is moved left one space (and is able), the other should. No capture
     * is allowed (full rules in CustomBishop.java constructor).
     * 
     * We can also use the board classes getPieces overloaded constructor to get an array
     * of our custom bishops by looking for a piece type. Thank you professor, this was randomly very helpful.
     * 
     * @param player The current player
     * @param board The current board state
     */
    @Override
    public void start(Player player, Board board) {
        while(true){
            show(board);
            var moves = getMoves(player, board);
            print(moves);
            print("Enter the number of your next move:");
            var move = getMove(board);

            // find our bishops, and from that array find which one is being moved by the player and
            // which is being moved by the other bishop (the one in our current chosen move).
            bishops = board.getPieces(player.getColor(), CustomBishop.class);
            partner = (moves.get(move-1).getPiece().equals(bishops.get(0))) ? bishops.get(1) : bishops.get(0);

            // the big gross middle here moves the partner bishop if necessary
            if(move > 0 && move <= moves.size()) {
                if (handleDualBishop(board, moves.get(move-1))) {
                    Move partnerMove;
                    if (movingLeft(moves.get(move-1))) {
                        partnerMove = new Move(board.getSquare(partner), 
                                               board.getSquare(partner.getRank(), 
                                                    partner.getFile() - 1)); // left 
                        partnerMove.execute();
                        print("Move executed: " + partnerMove.toString());
                    } else {
                        partnerMove = new Move(board.getSquare(partner), 
                                               board.getSquare(partner.getRank(), 
                                                   partner.getFile() + 1));  // right
                        partnerMove.execute();
                        print("Move executed: " + partnerMove.toString());
                    }
                }
                moves.get(move-1).execute();
                print("Move executed: " + moves.get(move-1).toString());
                return;
            } else {
                print("Illegal move: " + move);
            }
        }
    }
    /**
     * This is just a helper function. We only want to check for dual motion if both bishops are
     * alive and most importantly actually being moved.
     * 
     * @param board
     * @param moves
     * @param move
     * @return
     */
    private boolean handleDualBishop(Board board, Move move) {
        return (bishops.size() == 2 && move.getCurrent().getRank() - move.getTarget().getRank() == 0 &&
                (move.getCurrent().getPiece().equals(bishops.get(0)) || move.getCurrent().getPiece().equals(bishops.get(1))));
    }

    /**
     * Another helper function, also just for readability sake. We use this to find the
     * correct partner move to execute. We don't want to accidentally move one left and
     * the other right, it should be in the same direction.
     * 
     * @param move
     * @return
     */
    private boolean movingLeft(Move move) {
        return ((move.getTarget().getFile() - move.getCurrent().getFile()) < 0);
    }
}
