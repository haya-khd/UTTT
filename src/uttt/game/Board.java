package uttt.game;

import uttt.utils.Symbol;

public class Board implements BoardInterface {
	private MarkInterface[] marks;

	public Board() {
		// TODO Auto-generated constructor stub
		this.marks= new MarkInterface[9];

		for(int i=0; i<9; i++) {
			this.marks[i]= new Mark(Symbol.EMPTY, i);
		}
	}
	
	
	
	@Override
	public MarkInterface[] getMarks() {
		// TODO Auto-generated method stub
		return this.marks;
	}

	@Override
	public void setMarks(MarkInterface[] marks) throws IllegalArgumentException {
		// TODO Auto-generated method stub
	for(int i =0; i<9; i++) {
			
			if(marks[i]== null) {
				throw new IllegalArgumentException();

			}
		}
		if (marks.length > 9) {
			throw new IllegalArgumentException();
		}
	
		this.marks = marks;

	}

	@Override
	public boolean setMarkAt(Symbol symbol, int markIndex) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (markIndex < 0 || markIndex > 8
				|| symbol ==null) {
			throw new IllegalArgumentException();
		}

//		MarkInterface M = this.marks[markIndex];
		if (isMovePossible(markIndex)) {
			this.marks[markIndex].setSymbol(symbol);
			return true;
		}

		return false;
	}

	public int checkIsClosed(MarkInterface[] marks) {

		// check lines

		for (int i = 0; i < 9; i += 3) {

			if (marks[i].getSymbol() != Symbol.EMPTY && marks[i + 1].getSymbol() != Symbol.EMPTY
					&& marks[i + 2].getSymbol() != Symbol.EMPTY) {

				if (marks[i].getSymbol() == marks[i + 1].getSymbol()
						&& marks[i + 1].getSymbol() == marks[i + 2].getSymbol()) {
					if (marks[i].getSymbol() == Symbol.CIRCLE) {
						return 1;
					} else {
						return 2;
					}
				}
			}

		}
		// check Columns

		for (int i = 0; i < 3; i++) {

			if (marks[i].getSymbol() != Symbol.EMPTY && marks[i + 3].getSymbol() != Symbol.EMPTY
					&& marks[i + 6].getSymbol() != Symbol.EMPTY) {

				if (marks[i].getSymbol() == marks[i + 3].getSymbol()
						&& marks[i + 3].getSymbol() == marks[i + 6].getSymbol()) {

					if (marks[i].getSymbol() == Symbol.CIRCLE) {
						return 1;
					} else {
						return 2;
					}
				}
			}
		}

		// check for diagonal 0 4 8

		if (marks[0].getSymbol() != Symbol.EMPTY && marks[4].getSymbol() != Symbol.EMPTY
				&& marks[8].getSymbol() != Symbol.EMPTY) {

			if (marks[0].getSymbol() == marks[4].getSymbol()
					&& marks[4].getSymbol() == marks[8].getSymbol()) {
				if (marks[0].getSymbol() == Symbol.CIRCLE) {
					return 1;
				} else {
					return 2;

				}
			}
		}
		
		
		// Check for diagonal  2 , 4, 6
		
		if (marks[2].getSymbol() != Symbol.EMPTY && marks[4].getSymbol() != Symbol.EMPTY
				&& marks[6].getSymbol() != Symbol.EMPTY) {

			if (marks[2].getSymbol() == marks[4].getSymbol()
					&& marks[4].getSymbol() == marks[6].getSymbol()) {
				if (marks[2].getSymbol() == Symbol.CIRCLE) {
					return 1;
				} else {
					return 2;

				
			}
		}       
		}
		for(int i=0; i<9; i++) {
			if(marks[i].getSymbol()== Symbol.EMPTY) {
				return 3;
			}
		}
		return 4;
	}

	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		int x = checkIsClosed(this.marks);
		if(x== 1 || x == 2 || x==4) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isMovePossible(int markIndex) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (markIndex < 0 || markIndex > 8) {
			throw new IllegalArgumentException();
		}
		MarkInterface M = this.marks[markIndex];
		if(!isClosed()) {
			if (M.getSymbol() == Symbol.EMPTY ) {
				return true;
		}
		}
		return false;
	}

	@Override
	public Symbol getWinner() {
		// TODO Auto-generated method stub
		int x = checkIsClosed(this.marks);
		if(x == 3 || x == 4) {
			return Symbol.EMPTY;

		}
		if(x == 1) {
			return Symbol.CIRCLE;
		}
		return Symbol.CROSS;
	
	}

}
