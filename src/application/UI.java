package application;

import chess.ChessPiece;

public class UI {
	public static void printBoard(ChessPiece[][] pieces) {
		for(int rowsBoard = 0; rowsBoard < pieces.length; rowsBoard++) {
			System.out.print((8 - rowsBoard) + " ");
			for(int columnsBoard = 0; columnsBoard < pieces.length; columnsBoard++) {
				printPiece(pieces[rowsBoard][columnsBoard]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void printPiece(ChessPiece piece) {
		if(piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}
