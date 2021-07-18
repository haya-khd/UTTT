package uttt.game;

import uttt.utils.Move;
import uttt.utils.Symbol;

public class Simulator implements SimulatorInterface {
	private BoardInterface[] boards;
	private Symbol symbol;
	private int index;

	private Move move = null;
	private Symbol win = null;
	
	
	public Simulator() {
		// TODO Auto-generated constructor stub
		this.boards= new BoardInterface[9];
		for(int i=0; i<9; i++) {
			this.boards[i]= new Board();
		}
		this.index= -1;
		
	}

	@Override
	public BoardInterface[] getBoards() {
		// TODO Auto-generated method stub
		return this.boards;
	}

	@Override
	public void setBoards(BoardInterface[] boards) throws IllegalArgumentException {
		
		// TODO Auto-generated method stub
		for(int i=0; i<9; i++) {
			if(boards[i]== null) {
				throw new IllegalArgumentException();

			}
		}
		if (boards.length > 9) {
			throw new IllegalArgumentException();
		}
	
		this.boards = boards;

	}

	@Override
	public Symbol getCurrentPlayerSymbol() {
		// TODO Auto-generated method stub
		return this.symbol;
	}

	@Override
	public void setCurrentPlayerSymbol(Symbol symbol) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (symbol != Symbol.CIRCLE && symbol != Symbol.CROSS) {
			throw new IllegalArgumentException();
		}

		this.symbol = symbol;

	}

	@Override
	public boolean setMarkAt(Symbol symbol, int boardIndex, int markIndex) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (boardIndex < 0 || boardIndex > 8 || markIndex < 0 || markIndex > 8|| symbol == null) {
			throw new IllegalArgumentException();
		}

		BoardInterface B = this.boards[boardIndex];
		MarkInterface M = B.getMarks()[markIndex];
		if (M.getSymbol() == Symbol.EMPTY) {
			M.setSymbol(symbol);
			return true;
		}

		return false;
	}

	@Override
	public int getIndexNextBoard() {
		// TODO Auto-generated method stub
		return this.index;
	}

	@Override
	public void setIndexNextBoard(int index) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (index > 8 || index < -1) {
			throw new IllegalArgumentException();
		}
		this.index = index;
	}

	public int checkIsGameOver() {
		Symbol[] sym = new Symbol[9];
		for (int i = 0; i < 9; i++) {

			sym[i] = this.boards[i].getWinner();


		}
		for (int i = 0; i < 9; i += 3) {
			if (sym[i] != Symbol.EMPTY && sym[i + 1] != Symbol.EMPTY && sym[i + 2] != Symbol.EMPTY) {
				if (sym[i] == sym[i + 1] && sym[i + 1] == sym[i + 2]) {
					if (sym[i] == Symbol.CIRCLE) {
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (sym[i] != Symbol.EMPTY && sym[i + 3] != Symbol.EMPTY && sym[i + 6] != Symbol.EMPTY) {
				if (sym[i] == sym[i + 3] && sym[i + 3] == sym[i + 6]) {
					if (sym[i] == Symbol.CIRCLE) {
						return 1;
					} else {
						return 2;
					}
				}
			}

		}

		if (sym[0] != Symbol.EMPTY && sym[4] != Symbol.EMPTY && sym[8] != Symbol.EMPTY) {
			if (sym[0] == sym[4] && sym[4] == sym[8]) {
				if (sym[0] == Symbol.CIRCLE) {
					return 1;
				} else {
					return 2;
				}		
				}
			
		}
		if (sym[2] != Symbol.EMPTY && sym[4] != Symbol.EMPTY && sym[6] != Symbol.EMPTY) {
			if (sym[2] == sym[4] && sym[4] == sym[6]) {
				if (sym[2] == Symbol.CIRCLE) {
					return 1;
				} else {
					return 2;
				}			
				}
			
		}
		for(int i=0; i< 9; i++) {
			if(!this.boards[i].isClosed()) {
				
				return 3;
			}
		}
		
		return 4;
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		int x = checkIsGameOver();
		if(x == 1|| x==2|| x==4) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isMovePossible(int boardIndex) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (boardIndex > 8 || boardIndex < 0) {
			throw new IllegalArgumentException();
		}
		BoardInterface B = this.boards[boardIndex];
		if (B.isClosed()) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isMovePossible(int boardIndex, int markIndex) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (boardIndex < 0 || boardIndex > 8 || markIndex < 0 || markIndex > 8) {
			throw new IllegalArgumentException();
		}
		BoardInterface B = this.boards[boardIndex];
		MarkInterface M = B.getMarks()[markIndex];
		if(isMovePossible(boardIndex)) {
			if (M.getSymbol() == Symbol.EMPTY) {
				return true;
			}
		}
	
		return false;
	}

	@Override
	public Symbol getWinner() {
		// TODO Auto-generated method stub
	int x = checkIsGameOver();
	if(x == 3 || x== 4 ) {
		return Symbol.EMPTY;
	}
	if(x == 1) {
		return Symbol.CIRCLE;
				
	}
	return Symbol.CROSS;
	}

	@Override
	public void run(PlayerInterface playerOne, PlayerInterface playerTwo, UserInterface ui)
			throws IllegalArgumentException {
		
		if(playerOne.getSymbol()== null || playerTwo.getSymbol()== null|| ui == null)
			throw new IllegalArgumentException();
		move = playerOne.getPlayerMove(this, ui);

		
		this.setMarkAt(playerOne.getSymbol(), move.getBoardIndex(), move.getMarkIndex());
		this.setIndexNextBoard(move.getMarkIndex());
		ui.updateScreen(this);

		boolean currPlayer= true;  // if the curr Player is X
		while(!this.isGameOver()) {
			move = playerOne.getPlayerMove(this, ui);
		
				while(move.getBoardIndex() != this.getIndexNextBoard() && this.getIndexNextBoard()!= -1) {
					move = playerOne.getPlayerMove(this, ui);					}
			
			

			if(currPlayer) {
				if(this.isMovePossible(move.getBoardIndex(), move.getMarkIndex())) {
					this.setMarkAt(playerTwo.getSymbol(), move.getBoardIndex(), move.getMarkIndex());
					if(this.getBoards()[move.getMarkIndex()].isClosed()) {
						this.setIndexNextBoard(-1);
						ui.updateScreen(this);
						currPlayer= false;
						
				
						
					}else {
						this.setIndexNextBoard(move.getMarkIndex());
						ui.updateScreen(this);
						currPlayer= false;
					}
				
					
					
				}
				}else {
					if(this.isMovePossible(move.getBoardIndex(), move.getMarkIndex())) {
						this.setMarkAt(playerOne.getSymbol(), move.getBoardIndex(), move.getMarkIndex());
						if(this.getBoards()[move.getMarkIndex()].isClosed()) {
							this.setIndexNextBoard(-1);
							ui.updateScreen(this);
							currPlayer= true;
							
							
						}else {
							this.setIndexNextBoard(move.getMarkIndex());
							ui.updateScreen(this);
							currPlayer= true;
						}
					
				}
			
			}

		}	
			
		
		win= this.getWinner();
		ui.showGameOverScreen(this);
		
	
		
		

	}

}
