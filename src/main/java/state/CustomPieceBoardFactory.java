package state;

import pieces.CustomBishop;
import pieces.King;
import pieces.Knight;
import pieces.Queen;
import pieces.Rook;
import util.Color;

public class CustomPieceBoardFactory extends ConventionalBoardFactory {
    
    public static Board createCustom() {
        var board = new Board(8,8);
        addCustomPieces(Color.WHITE, 0, board);
        addCustomPieces(Color.BLACK, 7, board);
        addPawns(Color.WHITE, 1, board);
        addPawns(Color.BLACK, 6, board);
        return board;
    }

    private static void addCustomPieces(Color color, int rank, Board board) {
        CustomBishop cBishop1 = new CustomBishop(color);
        CustomBishop cBishop2 = new CustomBishop(color);
        cBishop1.setPartner(cBishop2);
        cBishop2.setPartner(cBishop1);

        board.getSquare(rank,0).setPiece(new Rook(color));
        board.getSquare(rank,7).setPiece(new Rook(color));
        board.getSquare(rank,1).setPiece(new Knight(color));
        board.getSquare(rank,6).setPiece(new Knight(color));
        board.getSquare(rank,2).setPiece(cBishop1);
        board.getSquare(rank,5).setPiece(cBishop2);
        board.getSquare(rank,3).setPiece(new Queen(color));
        board.getSquare(rank,4).setPiece(new King(color));
    }
}
