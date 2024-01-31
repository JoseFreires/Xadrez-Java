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
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.BLACK), new Position(0,0));
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
	}
	
}
