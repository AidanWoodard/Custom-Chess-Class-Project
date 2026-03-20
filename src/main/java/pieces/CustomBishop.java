package pieces;

import java.util.ArrayList;

import movesets.DiagonalMoveset;
import movesets.HorizontalMoveset;
import state.Board;
import state.Square;
import util.Color;

public class CustomBishop extends Bishop {
    private Piece partner;

    public CustomBishop(Color color) {
        super(color);
    }

    public void setPartner(CustomBishop cBishop) {
        partner = cBishop;
    }

    @Override
    public ArrayList<Square> possibleMoves(Board board) {
        // include diagonal moveset, check if partner still alive
        // if other piece includes at least one horizontal square, add
        // left and right squares
        ArrayList<Square> moves = new ArrayList<Square>();
        ArrayList<Square> partnerMoves = new ArrayList<>();
        moves.addAll(new DiagonalMoveset(board, board.getSize()).getPossibleMoves(this));
        partnerMoves.addAll(new HorizontalMoveset(board, 1).getPossibleMoves(partner));

        // allow horizontal motion only if both pieces can be moved
        if (!partnerMoves.isEmpty()) {
            moves.addAll(new HorizontalMoveset(board, 1).getPossibleMoves(this));
        }

        // TOOD: do not include horizontal captures for the bishop
        // TODO: access horizontal movements of partner and access additional player input
        
        return moves;
    }
}
