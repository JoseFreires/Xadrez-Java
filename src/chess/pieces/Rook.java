package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	} 
	
	@Override
	public boolean[][] possibleMoves(){
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position piece = new Position(0,0);
		
		// up
		piece.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
			piece.setRow(piece.getRow() - 1);
		} if (getBoard().positionExists(piece) && getBoard().thereIsAPiece(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// left
		piece.setValues(position.getRow(), position.getColumn() - 1);
		while(getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
			piece.setColumn(piece.getColumn() - 1);
		} if (getBoard().positionExists(piece) && isThereOpponentPiece(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// right
		piece.setValues(position.getRow(), position.getColumn() + 1);
		while(getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
			piece.setColumn(piece.getColumn() + 1);
		} if (getBoard().positionExists(piece) && isThereOpponentPiece(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// down
		piece.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExists(piece) && !getBoard().thereIsAPiece(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
			piece.setRow(piece.getRow() + 1);
		} if (getBoard().positionExists(piece) && isThereOpponentPiece(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
	
		
		return matriz;	
	}
	
	
	
}
