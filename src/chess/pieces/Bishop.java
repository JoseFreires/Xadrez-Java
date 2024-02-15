package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece{
	
	public Bishop(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "B";
	} 
	
	@Override
	public boolean[][] possibleMoves(){
		boolean[][] matriz = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position piecePosition = new Position(0,0);
		
		// NW
		piecePosition.setValues(position.getRow() - 1, position.getColumn() -1);
		while(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			piecePosition.setValues(piecePosition.getRow() - 1, piecePosition.getColumn() - 1);
			
		} if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
		}
		
		// NE
		piecePosition.setValues(position.getRow() - 1, position.getColumn() + 1);
		while(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			piecePosition.setValues(piecePosition.getRow() - 1, piecePosition.getColumn() + 1);
			
		} if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
		}
		
		// SE
		piecePosition.setValues(position.getRow() + 1, position.getColumn() + 1);
		while(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			piecePosition.setValues(piecePosition.getRow() + 1, piecePosition.getColumn() + 1);
			
		} if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
		}
		
		// SO
		piecePosition.setValues(position.getRow() + 1, position.getColumn() - 1);
		while(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			piecePosition.setValues(piecePosition.getRow() + 1, piecePosition.getColumn() - 1);
			
		} if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
		}
	
		
		return matriz;	
	}

}
