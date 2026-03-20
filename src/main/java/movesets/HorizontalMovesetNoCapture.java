package movesets;

import java.util.ArrayList;

import pieces.Piece;
import state.Board;
import state.Square;

public class HorizontalMovesetNoCapture extends HorizontalMoveset {
    private final int maxSquares;

    public HorizontalMovesetNoCapture(Board board, int maxSquares) {
        super(board, maxSquares);
        this.maxSquares = maxSquares;
    }

    @Override
    public ArrayList<Square> getPossibleMoves(Piece piece) {
        var moves = new ArrayList<Square>();
        var square = board.getSquare(piece.getRank(), piece.getFile());
        moves.addAll(HorizontallyRightNoCapture(square, board));
        moves.addAll(HorizontallyLeftNoCapture(square, board));
        return moves;
    }

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
