package uttt.tests;


import uttt.game.*;
import uttt.utils.Symbol;
import uttt.*;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class MyBoard {
	
	SimulatorInterface SI;
	BoardInterface[] BI = new BoardInterface[9];

	
	MarkInterface[] M_1 = new MarkInterface[9];
	MarkInterface[] M_2 = new MarkInterface[9];
	MarkInterface[] M_3 = new MarkInterface[9];
	MarkInterface[] M_4 = new MarkInterface[9];
	MarkInterface[] M_5 = new MarkInterface[9];
	MarkInterface[] M_6 = new MarkInterface[9];
	MarkInterface[] M_7 = new MarkInterface[9];
	MarkInterface[] M_8 = new MarkInterface[9];
	MarkInterface[] M_9 = new MarkInterface[9];
	
	SimulatorInterface SI_2;
	BoardInterface[] BI_2= new BoardInterface[9];
	
	MarkInterface[] M_11 = new MarkInterface[9];
	MarkInterface[] M_22 = new MarkInterface[9];
	MarkInterface[] M_33 = new MarkInterface[9];
	MarkInterface[] M_44 = new MarkInterface[9];
	MarkInterface[] M_55 = new MarkInterface[9];
	MarkInterface[] M_66 = new MarkInterface[9];
	MarkInterface[] M_77 = new MarkInterface[9];
	MarkInterface[] M_88 = new MarkInterface[9];
	MarkInterface[] M_99 = new MarkInterface[9];
	
	
	@Before
	public void SetUpSimulator() {
		SI = UTTTFactory.createSimulator();
		SI_2 = UTTTFactory.createSimulator();
		
		for(int i=0; i< 9; i++) {
			BI[i] = UTTTFactory.createBoard();

			M_1[i]= UTTTFactory.createMark(Symbol.EMPTY, i);
			M_2[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_3[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_4[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_5[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_6[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_7[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_8[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_9[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			
			BI_2[i] = UTTTFactory.createBoard();
			
			M_11[i]= UTTTFactory.createMark(Symbol.EMPTY, i);
			M_22[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_33[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_44[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_55[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_66[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_77[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_88[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_99[i] = UTTTFactory.createMark(Symbol.EMPTY, i);


		}
		
		M_1[0].setSymbol(Symbol.CIRCLE);
		M_1[1].setSymbol(Symbol.CIRCLE);
		M_1[2].setSymbol(Symbol.CIRCLE);
		
		M_2[3].setSymbol(Symbol.CIRCLE);
		M_2[4].setSymbol(Symbol.CIRCLE);
		M_2[5].setSymbol(Symbol.CIRCLE);
		
		M_3[6].setSymbol(Symbol.CIRCLE);
		M_3[7].setSymbol(Symbol.CIRCLE);
		M_3[8].setSymbol(Symbol.CIRCLE);
		
		M_4[0].setSymbol(Symbol.CIRCLE);
		M_4[3].setSymbol(Symbol.CIRCLE);
		M_4[6].setSymbol(Symbol.CIRCLE);

		M_5[1].setSymbol(Symbol.CIRCLE);
		M_5[4].setSymbol(Symbol.CIRCLE);
		M_5[7].setSymbol(Symbol.CIRCLE);
		
		M_6[2].setSymbol(Symbol.CIRCLE);
		M_6[5].setSymbol(Symbol.CIRCLE);
		M_6[8].setSymbol(Symbol.CIRCLE);
		
		M_7[0].setSymbol(Symbol.CIRCLE);
		M_7[4].setSymbol(Symbol.CIRCLE);
		M_7[8].setSymbol(Symbol.CIRCLE);
		
		M_8[2].setSymbol(Symbol.CIRCLE);
		M_8[4].setSymbol(Symbol.CIRCLE);
		M_8[6].setSymbol(Symbol.CIRCLE);
		
		BI[0].setMarks(M_1);
		BI[1].setMarks(M_2);
		BI[2].setMarks(M_3);
		BI[3].setMarks(M_4);
		BI[4].setMarks(M_5);
		BI[5].setMarks(M_6);
		BI[6].setMarks(M_7);
		BI[7].setMarks(M_8);
		
		SI.setBoards(BI);
		
		M_11[0].setSymbol(Symbol.CROSS);
		M_11[1].setSymbol(Symbol.CROSS);
		M_11[2].setSymbol(Symbol.CROSS);
		
		M_22[3].setSymbol(Symbol.CROSS);
		M_22[4].setSymbol(Symbol.CROSS);
		M_22[5].setSymbol(Symbol.CROSS);
		
		M_33[6].setSymbol(Symbol.CROSS);
		M_33[7].setSymbol(Symbol.CROSS);
		M_33[8].setSymbol(Symbol.CROSS);
		
		M_44[0].setSymbol(Symbol.CROSS);
		M_44[3].setSymbol(Symbol.CROSS);
		M_44[6].setSymbol(Symbol.CROSS);

		M_55[1].setSymbol(Symbol.CROSS);
		M_55[4].setSymbol(Symbol.CROSS);
		M_55[7].setSymbol(Symbol.CROSS);
		
		M_66[2].setSymbol(Symbol.CROSS);
		M_66[5].setSymbol(Symbol.CROSS);
		M_66[8].setSymbol(Symbol.CROSS);
		
		M_77[0].setSymbol(Symbol.CROSS);
		M_77[4].setSymbol(Symbol.CROSS);
		M_77[8].setSymbol(Symbol.CROSS);
		
		M_88[2].setSymbol(Symbol.CROSS);
		M_88[4].setSymbol(Symbol.CROSS);
		M_88[6].setSymbol(Symbol.CROSS);
		
		BI_2[0].setMarks(M_11);
		BI_2[1].setMarks(M_22);
		BI_2[2].setMarks(M_33);
		BI_2[3].setMarks(M_44);
		BI_2[4].setMarks(M_55);
		BI_2[5].setMarks(M_66);
		BI_2[6].setMarks(M_77);
		BI_2[7].setMarks(M_88);
		
		SI_2.setBoards(BI_2);
		
		
		
	}
	
	@Test
	public void setMarkCircle() {
		assertTrue(BI[0].isClosed());
		assertTrue(BI[1].isClosed());
		assertTrue(BI[2].isClosed());
		assertTrue(BI[3].isClosed());
		assertTrue(BI[4].isClosed());
		assertTrue(BI[5].isClosed());
		assertTrue(BI[6].isClosed());
		assertTrue(BI[7].isClosed());
		assertTrue(!BI[8].isClosed());
		
	}
	
	@Test
	public void setMarkCross() {
		assertTrue(BI_2[0].isClosed());
		assertTrue(BI_2[1].isClosed());
		assertTrue(BI_2[2].isClosed());
		assertTrue(BI_2[3].isClosed());
		assertTrue(BI_2[4].isClosed());
		assertTrue(BI_2[5].isClosed());
		assertTrue(BI_2[6].isClosed());
		assertTrue(BI_2[7].isClosed());
		assertTrue(!BI_2[8].isClosed());
		
	}
	
	@Test
	public void setBoardCircle() {
		assertTrue(SI.isGameOver());
	}
	
	@Test
	public void setBoardCross() {
		assertTrue(SI_2.isGameOver());
	}
}
