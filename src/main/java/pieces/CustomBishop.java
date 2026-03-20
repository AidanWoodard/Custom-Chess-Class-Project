package pieces;

import java.util.ArrayList;

import movesets.DiagonalMoveset;
import state.Board;
import state.CustomPieceBoardFactory;
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
        return null;
    }
}
