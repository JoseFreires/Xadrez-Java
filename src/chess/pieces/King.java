package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves(){
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position piece = new Position(0, 0);
		
		// up
		piece.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(piece) && canMove(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// down
		piece.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().positionExists(piece) && canMove(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// left
		piece.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(piece) && canMove(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// right
		piece.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExists(piece) && canMove(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// (NE)
		piece.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExists(piece) && canMove(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// (NO)
		piece.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().positionExists(piece) && canMove(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// (SE)
		piece.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExists(piece) && canMove(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// (SE)
		piece.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(piece) && canMove(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
				
				
		
		return matriz;
	}

}
