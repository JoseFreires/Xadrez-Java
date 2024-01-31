package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;

	public ChessMatch() {
		board = new Board(8,8);
		initialSetup();
	}

	public ChessPiece[][] getPieces(){
		ChessPiece[][] match = new ChessPiece[board.getRows()][board.getColumns()];
		for(int row = 0; row < board.getRows(); row++) {
			for(int column = 0; column < board.getColumns(); column++) {
				match[row][column] = (ChessPiece) board.piece(row, column);
			}
		}
		return match;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('d', 8, new King(board, Color.BLACK));
		placeNewPiece('d', 1, new King(board, Color.WHITE));
		placeNewPiece('a', 8, new Rook(board, Color.BLACK));
	}
	
}
