package pieces;

import java.util.ArrayList;

import movesets.DiagonalMoveset;
import movesets.HorizontalMoveset;
import movesets.HorizontalMovesetNoCapture;
import state.Board;
import state.Square;
import util.Color;

public class CustomBishop extends Bishop {
    private Piece partner;

    /**
     * The custom bishop has the ability to move left or right one square only
     * to effectively switch the color of squares that it can attack on. However,
     * BOTH pieces must be able to do so, and if only one bishop is remaining, it
     * is not limited and can move horizontally at will. 
     * 
     * When one switches in one direction, the other does so too (moving a bishop left one causes
     * other to do so as well). I chose to only allow horizontal motion to prevent the
     * piece from being too powerful.
     * 
     * In game, this makes capturing only one bishop very dangerous. When together,
     * they can be used to shift into check (or possibly checkmate), and only capturing
     * one of the two extends its abilities to change colors, making it quite an
     * interesting new game mechanic to chess.
     * @param color
     */
    public CustomBishop(Color color) {
        super(color);
    }

    /**
     * Value for a custom bishop is two points higher than a normal bishop, given the
     * pieces strength in the game and difficulty of capture.
     */
    @Override
    public int getValue() {
        return 5;
    }

    /**
     * This single-line function 'marries' the two pieces. They must be able to check
     * if the other can move, so upon instantiation in CustomPieceBoardFactory.java, they
     * are given references to each other.
     * @param cBishop
     */
    public void setPartner(CustomBishop cBishop) {
        partner = cBishop;
    }

    /**
     * Very similar to the original bishop possible move class. However, we include a
     * check on the partner piece, checking for available moves before allowing hroizontal
     * motion using the HorizontalMovesetNoCapture.java moveset child class (as well as
     * making sure the piece is still alive by checking if its square is null).
     * @param board the current game board
     */
    @Override
    public ArrayList<Square> possibleMoves(Board board) {
        ArrayList<Square> moves = new ArrayList<Square>();
        ArrayList<Square> partnerMoves = new ArrayList<>();
        moves.addAll(new DiagonalMoveset(board, board.getSize()).getPossibleMoves(this));
        partnerMoves.addAll(new HorizontalMovesetNoCapture(board, 1).getPossibleMoves(partner));

        if (!partnerMoves.isEmpty() || board.getSquare(partner) == null) {
            moves.addAll(new HorizontalMovesetNoCapture(board, 1).getPossibleMoves(this));
        }
        return moves;
    }
}
