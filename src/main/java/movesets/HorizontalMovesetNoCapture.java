package movesets;

import java.util.ArrayList;

import pieces.Piece;
import state.Board;
import state.Square;

public class HorizontalMovesetNoCapture extends HorizontalMoveset {
    private final int maxSquares;

    /**
     * This extends the horizontal moveset to hamper a pieces ability to capture.
     * The custom bishop CANNOT CAPTURE WHEN SWITCHING COLORS, so we limit it's ability
     * to do so when moving horizontall (effectively switching colors).
     * @param board current board
     * @param maxSquares max squares possible for board (used in parent)
     */
    public HorizontalMovesetNoCapture(Board board, int maxSquares) {
        super(board, maxSquares);
        this.maxSquares = maxSquares;
    }

    /**
    * Exact same as getPossibleMoves(Piece piece) of parent class, except
    * for inability to capture. This is currently used by the CustomBishop
    * class to enable sideways motion but NOT sideways capture
    * @param piece the piece to move
    * @return list of possible moves
    */
    @Override
    public ArrayList<Square> getPossibleMoves(Piece piece) {
        var moves = new ArrayList<Square>();
        var square = board.getSquare(piece.getRank(), piece.getFile());
        moves.addAll(HorizontallyRightNoCapture(square, board));
        moves.addAll(HorizontallyLeftNoCapture(square, board));
        return moves;
    }

    /**
    * Do not return moves that will capture a separate piece. The difference is removing
    * the || statement that checks for possible captures
    * @param square the current square
    * @param board the game board
    * @return list of possible moves to the left
    */
    private ArrayList<Square> HorizontallyLeftNoCapture(Square square, Board board) {
        var moves = new ArrayList<Square>();
        var limit = Math.max(square.getFile() - maxSquares, 0);
        for (int f = square.getFile() - 1; f >= limit; f--) {
            var nextSquare = board.getSquare(square.getRank(), f);
            var piece = nextSquare.getPiece();
            if(!nextSquare.hasPiece())          // exclude capture abilities
                moves.add(nextSquare);
            if(piece!=null) {
                break;
            }
        }
        return moves;
    }
    /**
    * Same as HorizontallyLeftNoCapture but now checking in opposite direction
    * @param square the current square
    * @param board the game board
    * @return list of possible moves to the left
    */
    private ArrayList<Square> HorizontallyRightNoCapture(Square square, Board board) {
        var moves = new ArrayList<Square>();
        var limit = Math.min(square.getFile() + maxSquares, board.getSize() - 1);
        for (int f = square.getFile() + 1; f <= limit; f++) {
            var nextSquare = board.getSquare(square.getRank(), f);
            var piece = nextSquare.getPiece();
            if(!nextSquare.hasPiece())          // exclude capture abilities
                moves.add(nextSquare);
            if(piece!=null) {
                break;
            }
        }
        return moves;
    }
}
