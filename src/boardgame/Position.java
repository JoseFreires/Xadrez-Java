package boardgame;

public class Position {
	
	private Integer column;
	private Integer row;
	
	public Position(Integer row, Integer column) {
		this.row = row;
		this.column = column;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + column + ", " + row + ")";
	}


	
	
	

}
