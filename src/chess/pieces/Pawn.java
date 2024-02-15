package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "P";
	} 

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position piecePosition = new Position(0,0);
		
		if(getColor() == Color.WHITE) {
			
			// Move usual
			piecePosition.setValues(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
				matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			// First Move
			piecePosition.setValues(position.getRow() - 2, position.getColumn());
			Position positionMiddle = new Position(position.getRow() - 1, position.getColumn());
			if(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition) && 
			getBoard().positionExists(positionMiddle) && !getBoard().thereIsAPiece(positionMiddle) && getMoveCount() == 0) {
				matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			// (NE) to defeat opponent
			piecePosition.setValues(position.getRow() - 1, position.getColumn() - 1);
			if(getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
				matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			// (NO) to defeat opponent
			piecePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
			if(getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
				matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
		} else {
			// Move usual
			piecePosition.setValues(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
				matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			// First Move
			piecePosition.setValues(position.getRow() + 2, position.getColumn());
			Position positionMiddle = new Position(position.getRow() + 1, position.getColumn());
			if(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition) && 
			getBoard().positionExists(positionMiddle) && !getBoard().thereIsAPiece(positionMiddle) && getMoveCount() == 0) {
				matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			// (NE) to defeat opponent
			piecePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
			if(getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
				matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
			
			// (NO) to defeat opponent
			piecePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
			if(getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
				matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			}
		}
		
		return matriz;
	}

	
}
