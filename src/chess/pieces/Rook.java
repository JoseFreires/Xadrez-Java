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
		
		Position piecePosition = new Position(0,0);
		
		// up
		piecePosition.setValues(position.getRow() - 1, position.getColumn());
		while(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			piecePosition.setRow(piecePosition.getRow() - 1);
		} if (getBoard().positionExists(piecePosition) && getBoard().thereIsAPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
		}
		
		// left
		piecePosition.setValues(position.getRow(), position.getColumn() - 1);
		while(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			piecePosition.setColumn(piecePosition.getColumn() - 1);
		} if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
		}
		
		// right
		piecePosition.setValues(position.getRow(), position.getColumn() + 1);
		while(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			piecePosition.setColumn(piecePosition.getColumn() + 1);
		} if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
		}
		
		// down
		piecePosition.setValues(position.getRow() + 1, position.getColumn());
		while(getBoard().positionExists(piecePosition) && !getBoard().thereIsAPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
			piecePosition.setRow(piecePosition.getRow() + 1);
		} if (getBoard().positionExists(piecePosition) && isThereOpponentPiece(piecePosition)) {
			matriz[piecePosition.getRow()][piecePosition.getColumn()] = true;
		}
	
		
		return matriz;	
	}
	
	
	
}
