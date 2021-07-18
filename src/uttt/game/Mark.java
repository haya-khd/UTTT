package uttt.game;


import uttt.utils.Symbol;

public class Mark implements MarkInterface {
	
	private int Index;
	private Symbol symbol;
	
	public Mark(Symbol symbol, int Index) {
		// TODO Auto-generated constructor stub
		if(Index<0 || Index> 8|| symbol != Symbol.EMPTY&& symbol!= Symbol.CIRCLE && symbol != Symbol.CROSS) {
			throw new IllegalArgumentException();
		}
		this.symbol=symbol;
		this.Index= Index;
		
	}

	@Override
	public Symbol getSymbol() {
		// TODO Auto-generated method stub
		return this.symbol;
	}

	@Override
	public int getPosition() {
		// TODO Auto-generated method stub
		return this.Index;
	}

	@Override
	public void setSymbol(Symbol symbol) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(symbol != Symbol.CIRCLE&& symbol != Symbol.CROSS&& symbol != Symbol.EMPTY) {
			throw new IllegalArgumentException();
		}
		this.symbol=symbol;
		
	}

}
