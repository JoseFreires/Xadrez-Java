package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color,  ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
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
			
			// Specialmove: En Passant (White)
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matriz[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matriz[right.getRow() - 1][right.getColumn()] = true;
				}
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
			
			// Specialmove: En Passant (White)
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matriz[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matriz[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		
		return matriz;
	}

	
}
