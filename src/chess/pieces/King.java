package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
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
		
		// (NW)
		piece.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExists(piece) && canMove(piece)) {
			matriz[piece.getRow()][piece.getColumn()] = true;
		}
		
		// (NE)
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
		
		// SpecialMove: Castling
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			// Kingside
			Position positionTestOne = new Position(position.getRow(), position.getColumn() + 3);
			if(testRookCastling(positionTestOne)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					matriz[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			
			// Queenside
			Position positionTestTwo = new Position(position.getRow(), position.getColumn() - 4);
			if(testRookCastling(positionTestTwo)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					matriz[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}
				
		
		return matriz;
	}

}
