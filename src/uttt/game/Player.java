package uttt.game;

import uttt.utils.Move;
import uttt.utils.Symbol;

public class Player implements PlayerInterface {

	
	private Symbol symbol;

	
	public Player(Symbol symbol) {
		// TODO Auto-generated constructor stub
		this.symbol= symbol;
	}
	@Override
	public Symbol getSymbol() {
		// TODO Auto-generated method stub
		return this.symbol;
	}

	@Override
	public Move getPlayerMove(SimulatorInterface game, UserInterface ui) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Move m= ui.getUserMove();
		
		return m;
	}

}
