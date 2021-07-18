package uttt.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
//import org.junit.Rule;

import uttt.UTTTFactory;
import uttt.game.*;
import uttt.utils.*;

public class MySimulator {

	// @Rule

	SimulatorInterface SI;
	SimulatorInterface SI_2;
	SimulatorInterface SI_3;
	SimulatorInterface SI_4;
	SimulatorInterface SI_5;

	MarkInterface mark_fN;
	MarkInterface mark_fP;
	MarkInterface mark_null;

	// The Circle win in this Board
	BoardInterface[] BI = new BoardInterface[9];

	// No one Win in this Board "Tie"
	BoardInterface[] BI_2 = new BoardInterface[9];

	// there are some moves left
	BoardInterface[] BI_3 = new BoardInterface[9];

	//
	BoardInterface[] BI_4 = new BoardInterface[10];
	BoardInterface[] BI_5 = new BoardInterface[10];
	BoardInterface[] BI_6= new BoardInterface[9];

	MarkInterface[] M_1 = new MarkInterface[9];
	MarkInterface[] M_2 = new MarkInterface[9];
	MarkInterface[] M_3 = new MarkInterface[9];
	MarkInterface[] M_4 = new MarkInterface[9];
	MarkInterface[] M_5 = new MarkInterface[9];
	MarkInterface[] M_6 = new MarkInterface[9];
	MarkInterface[] M_7 = new MarkInterface[9];
	MarkInterface[] M_8 = new MarkInterface[9];
	MarkInterface[] M_9 = new MarkInterface[9];

	MarkInterface[] M_10 = new MarkInterface[10];
	MarkInterface[] M_11 = new MarkInterface[9];

	BoardInterface B;
	//B_2 for null tests
	BoardInterface B_2;

	@Before
	public void SetUpSimulator() {
		SI = UTTTFactory.createSimulator();
		SI_2 = UTTTFactory.createSimulator();
		SI_3 = UTTTFactory.createSimulator();
		SI_4 = UTTTFactory.createSimulator();
		SI_5 = UTTTFactory.createSimulator();

		B = UTTTFactory.createBoard();
		B_2 = UTTTFactory.createBoard();

		// To test Marks with an invalid Index

		for (int i = 0; i < 9; i++) {
			M_1[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_2[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_3[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_4[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_5[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_6[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_7[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_8[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_9[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
			M_10[i] = UTTTFactory.createMark(Symbol.EMPTY, i);

			BI[i] = UTTTFactory.createBoard();
			BI_2[i] = UTTTFactory.createBoard();
			BI_3[i] = UTTTFactory.createBoard();
			BI_4[i] = UTTTFactory.createBoard();
			BI_5[i] = UTTTFactory.createBoard();

		}
		// Fell the First Board
		M_1[1].setSymbol(Symbol.CROSS);
		M_1[2].setSymbol(Symbol.CIRCLE);
		M_1[4].setSymbol(Symbol.CIRCLE);
		M_1[6].setSymbol(Symbol.CIRCLE);

		BI[0].setMarks(M_1);

		// Fell the Second Board
		M_2[0].setSymbol(Symbol.CIRCLE);
		M_2[4].setSymbol(Symbol.CROSS);
		M_2[5].setSymbol(Symbol.CIRCLE);
		M_2[8].setSymbol(Symbol.CIRCLE);

		BI[1].setMarks(M_2);

		// Fell the Third Board
		M_3[1].setSymbol(Symbol.CROSS);
		M_3[4].setSymbol(Symbol.CROSS);
		M_3[7].setSymbol(Symbol.CROSS);
		BI[2].setMarks(M_3);

		// Fell the Fourth Board
		M_4[0].setSymbol(Symbol.CIRCLE);
		M_4[1].setSymbol(Symbol.CROSS);
		M_4[2].setSymbol(Symbol.CIRCLE);
		M_4[3].setSymbol(Symbol.CROSS);
		M_4[4].setSymbol(Symbol.CROSS);
		M_4[5].setSymbol(Symbol.CIRCLE);
		M_4[6].setSymbol(Symbol.CROSS);
		M_4[7].setSymbol(Symbol.CIRCLE);
		M_4[8].setSymbol(Symbol.CROSS);
		BI[3].setMarks(M_4);

		// Fell the Fifth Board
		M_5[0].setSymbol(Symbol.CROSS);
		M_5[1].setSymbol(Symbol.CIRCLE);
		M_5[2].setSymbol(Symbol.CIRCLE);
		M_5[3].setSymbol(Symbol.CIRCLE);
		M_5[4].setSymbol(Symbol.CROSS);
		M_5[5].setSymbol(Symbol.CIRCLE);
		M_5[6].setSymbol(Symbol.CIRCLE);
		M_5[7].setSymbol(Symbol.CIRCLE);
		M_5[8].setSymbol(Symbol.CIRCLE);
		BI[4].setMarks(M_5);

		// Fell the sixth Board
		M_6[3].setSymbol(Symbol.CIRCLE);
		M_6[4].setSymbol(Symbol.CROSS);
		M_6[5].setSymbol(Symbol.CROSS);
		BI[5].setMarks(M_6);

		// Fell the seventh Board
		M_7[4].setSymbol(Symbol.CROSS);
		M_7[8].setSymbol(Symbol.CROSS);
		BI[6].setMarks(M_7);

		// Fell the eighth Board
		M_8[0].setSymbol(Symbol.CROSS);
		M_8[4].setSymbol(Symbol.CIRCLE);
		M_8[8].setSymbol(Symbol.CROSS);
		BI[7].setMarks(M_8);

		// Fell the ninth Board
		M_9[0].setSymbol(Symbol.CROSS);
		M_9[1].setSymbol(Symbol.CROSS);
		M_9[4].setSymbol(Symbol.CROSS);
		M_9[6].setSymbol(Symbol.CIRCLE);
		M_9[7].setSymbol(Symbol.CIRCLE);
		M_9[8].setSymbol(Symbol.CIRCLE);
		BI[8].setMarks(M_9);

		// Fell the Board, no one Win in this Simulator
		BI_2[0].setMarks(M_4);
		BI_2[1].setMarks(M_4);
		BI_2[2].setMarks(M_5);
		BI_2[3].setMarks(M_5);
		BI_2[4].setMarks(M_4);
		BI_2[5].setMarks(M_5);
		BI_2[6].setMarks(M_4);
		BI_2[7].setMarks(M_5);
		BI_2[8].setMarks(M_4);

		// Fell the third Board, with a not finished Game
		BI_3[0].setMarks(M_3);
		BI_3[1].setMarks(M_6);
		BI_3[2].setMarks(M_3);
		BI_3[3].setMarks(M_7);
		BI_3[4].setMarks(M_6);
		BI_3[5].setMarks(M_4);
		BI_3[6].setMarks(M_5);
		BI_3[7].setMarks(M_7);
		BI_3[8].setMarks(M_7);

		BI_4[9] = UTTTFactory.createBoard();

		BI_4[1].setMarks(M_1);
		BI_4[2].setMarks(M_1);
		BI_4[3].setMarks(M_1);
		BI_4[4].setMarks(M_1);
		BI_4[5].setMarks(M_1);
		BI_4[6].setMarks(M_1);
		BI_4[7].setMarks(M_1);
		BI_4[8].setMarks(M_1);
		BI_4[9].setMarks(M_1);

		BI_5[9] = UTTTFactory.createBoard();

		BI_5[0].setMarks(M_1);
		BI_5[1].setMarks(M_1);
		BI_5[2].setMarks(M_1);
		BI_5[3].setMarks(M_1);
		BI_5[4].setMarks(M_1);
		BI_5[5].setMarks(M_1);
		BI_5[6].setMarks(M_1);
		BI_5[7].setMarks(M_1);
		BI_5[8].setMarks(M_1);
		BI_5[9].setMarks(M_1);

		SI.setBoards(BI);
		SI.setIndexNextBoard(-1);
		SI.setCurrentPlayerSymbol(Symbol.CROSS);

		SI_2.setBoards(BI_2);

		SI_3.setBoards(BI_3);
		SI_3.setIndexNextBoard(1);
		SI_3.setCurrentPlayerSymbol(Symbol.CIRCLE);

	}

//	/* Test Mark Constructor */
	@Test(expected = IllegalArgumentException.class)
	public void setMarkTestNegF() {
		mark_fN = UTTTFactory.createMark(Symbol.CIRCLE, -5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getNullSymbol() {
		mark_null = UTTTFactory.createMark(null, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void setMarkTestPosF() {
		mark_fP = UTTTFactory.createMark(Symbol.CIRCLE, 30);
	}

	/* MarkInterface: Test for the set Method */
	@Test
	public void setMarkTestT() {
		assertTrue(Symbol.CROSS == M_1[1].getSymbol());
	}

	@Test
	public void setPositionTestT() {
		assertTrue(1 == M_1[1].getPosition());
	}

	@Test
	public void setPositionTestF() {
		assertFalse(4 == M_1[1].getPosition());
	}
	

	/* BoardInterface: Test for set Method */
	@Test
	public void setBoardsnull() {
		assertNotNull(B_2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setMarksnull() {
		B.setMarks(M_11);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void setMarksTestF() {
		M_10[9] = UTTTFactory.createMark(Symbol.EMPTY, 9);

		B.setMarks(M_10);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void createMarksTestF() {
		M_10[9] = UTTTFactory.createMark(null, 2);

		//B.setMarks(M_10);
	}
	@Test
	public void setBoardTestT() {

		assertArrayEquals(M_1, BI[0].getMarks());
	}

	@Test
	public void setBoardTestF() {
		assertFalse(Arrays.equals(M_3,BI[3].getMarks()));

	}

	/* BoardInterface: Test For SetMarkAt in BoardInterface */

	// Set the Mark an Empty position
	@Test
	public void SetMarkT() {
		assertTrue(BI[1].setMarkAt(Symbol.CROSS, 1));
	}
	
	
	// Set The Mark at an incorrect position -3
	@Test(expected = IllegalArgumentException.class)
	public void SetMarkAtNegP() {
		BI[0].setMarkAt(Symbol.CIRCLE, -3);
	}
	

	// Set The Mark at an incorrect position 10
	@Test(expected = IllegalArgumentException.class)
	public void SetMarkAtPosP() {
		BI[8].setMarkAt(Symbol.CIRCLE, 10);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void SetMarkAtNull() {
		BI[6].setMarkAt(null,1 );
	}

	// Set the Mark at a non empty position
	@Test
	public void SetMarkAtNonEmpty() {
		assertFalse(BI[0].setMarkAt(Symbol.CIRCLE, 1));
	}
	

	/* BoardInterface: Test for IsClosed in BoardInterface */
	// O Win
	@Test
	public void isClosedOWin() {
		assertTrue(BI[4].isClosed());
	}

	@Test
	public void isClosedOWinDiagonal() {
		assertTrue(BI[0].isClosed());
	}
	@Test
	public void isClosedOWinline() {
		assertTrue(BI[8].isClosed());
	}
	
	// X Win
	@Test
	public void isClosedXWin() {
		assertTrue(BI[2].isClosed());
	}

	@Test
	public void isClosedNotFinisched() {
		assertFalse(BI[5].isClosed());
	}

	@Test
	public void isClosedTie() {
		assertTrue(BI[3].isClosed());
	}

	/* BoardInterface: Test if the Move is possible */

	@Test
	public void isMovePosT() {
		assertTrue(BI[1].isMovePossible(2));
	}

	@Test
	public void isMovePosF() {
		assertFalse(BI[2].isMovePossible(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void isMovePosNegP() throws Exception {
		BI[0].isMovePossible(-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void isMovePosPP() throws Exception {
		BI[8].isMovePossible(10);
	}

	
	
	/* SimulatorInterface: Test set for the Board */
	@Test(expected = IllegalArgumentException.class)
	public void setBoardInvalid() {
		SI_4.setBoards(BI_5);
	}

	@Test
	public void setBoardT() {
		assertArrayEquals(BI, SI.getBoards());
	}

	@Test
	public void setBoardF() {
		assertFalse(Arrays.equals(BI , SI_2.getBoards()));
	}

	/* Test for current player Symbol */

	@Test

	public void setCurrentPlayerSymbolT() {
		assertTrue(SI.getCurrentPlayerSymbol() == Symbol.CROSS);
	}

	@Test

	public void setCurrentPlayerSymbolF() {
		assertFalse(SI.getCurrentPlayerSymbol() == Symbol.CIRCLE);
	}

	/*
	 * SimulatorInterface: Test for Set Mark at a correct Position in the Board and
	 * Mark
	 */
	
	@Test (expected = IllegalArgumentException.class)
	public void setBoardnull() {
		SI_5.setBoards(BI_6);
	}
	@Test
	public void setMarkAtSimT() throws Exception {
		assertTrue(SI_3.setMarkAt(SI_3.getCurrentPlayerSymbol(), 1, 1));
	}

	// a non Empty Board place
	@Test
	public void setMarkAtSimF(){
		assertFalse(SI.setMarkAt(SI.getCurrentPlayerSymbol(), 4, 1));
	}

	// invalid board index
	@Test(expected = IllegalArgumentException.class)
	public void setMarkAtSimBoardP() throws Exception {
		SI.setMarkAt(SI.getCurrentPlayerSymbol(), 10, 1);
	}

	// invalid board index
	@Test(expected = IllegalArgumentException.class)
	public void setMarkAtSimBoardN() throws Exception {
		SI.setMarkAt(SI.getCurrentPlayerSymbol(), -5, 1);
	}

	// invalid Mark index Positive
	@Test(expected = IllegalArgumentException.class)
	public void setMarkAtSimMarkP() throws Exception {
		SI.setMarkAt(SI.getCurrentPlayerSymbol(), 4, 11);
	}

	// invalid Mark Index Negative
	@Test(expected = IllegalArgumentException.class)
	public void setMarkAtSimMarkN() throws Exception {
		SI.setMarkAt(SI.getCurrentPlayerSymbol(), 4, -11);
	}
	@Test(expected = IllegalArgumentException.class)
	public void setMarkAtSimMarkNull() throws Exception {
		SI_3.setMarkAt(null, 1, 8);
	}

	/* SimulatorInterface: test isMovePossible according to the Board Index */

	// Test if it is possible to move at the Second Board return true
	@Test
	public void IsMovePossibleT() {
		assertTrue(SI_3.isMovePossible(1));
	}

	// False: the Board is full
	@Test
	public void IsMovePossibleBoardF() {
		assertFalse(SI.isMovePossible(4));
	}

	// False: At a negative Board Index
	@Test(expected = IllegalArgumentException.class)
	public void IsMovePossibleNegBoard() {
		SI.isMovePossible(-4);
	}

	// False: At a board Index > 9
	@Test(expected = IllegalArgumentException.class)
	public void IsMovePossiblePosBoard() {
		SI.isMovePossible(11);
	}

	/*
	 * SimulatorInterface: test isMovePossible according to the Board and Mark Index
	 */

	// Test if it is possible to move at the Sixth Board, and first Mark
	@Test
	public void IsMovePossibleMarkBoardT() {
		assertTrue(SI_3.isMovePossible(1, 1));
	}

	// False: the Position in not Empty
	@Test
	public void IsMovePossibleMarkBoardF() {
		assertFalse(SI.isMovePossible(7, 0));
	}

	// False: invalid Mark position "Negative"
	@Test(expected = IllegalArgumentException.class)
	public void IsMovePossibleNegMarkBoard() {
		SI.isMovePossible(6, -3);
	}

	// False: invalid Mark position "> 9"
	@Test(expected = IllegalArgumentException.class)
	public void IsMovePossiblePosMarkBoard() {
		SI.isMovePossible(6, 10);
	}

	// False: invalid Board Index
	@Test(expected = IllegalArgumentException.class)
	public void IsMovePossibleMarkNegBoard() {
		SI.isMovePossible(-3, 2);
	}

	// False: invalid Board Index
	@Test(expected = IllegalArgumentException.class)
	public void IsMovePossibleMarkPosBoard() {
		SI.isMovePossible(11, 2);
	}

	// False: invalid Board and Mark Index
	@Test(expected = IllegalArgumentException.class)
	public void IsMovePossibleNegMarkNegBoard() {
		SI.isMovePossible(-3, -2);
	}

	@Test
	public void isGameOver() {
		assertTrue(SI.isGameOver());
	}

	@Test
	public void isGameOverTie() {
		assertTrue(SI_2.isGameOver());
	}

	@Test
	public void isGameOverUnfinisched() {
		assertFalse(SI_3.isGameOver());
	}

	@Test
	public void TestgetSymbol() {
		assertTrue(Symbol.CIRCLE == SI.getWinner());
	}

	@Test
	public void setIndexNextBoardT() {
		assertTrue(1 == SI_3.getIndexNextBoard());
	}

	@Test
	public void setIndexNextBoardNotFixedT() {
		assertTrue(-1 == SI.getIndexNextBoard());
	}

	@Test
	public void setIndexNextBoardF() {
		assertFalse(2 == SI_3.getIndexNextBoard());
	}

	@Test
	public void setIndexNextBoardNotFixedF() {
		assertFalse(5 == SI.getIndexNextBoard());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setIndexNextBoardNeg() {
		SI_3.setIndexNextBoard(-4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setIndexNextBoardPos() {
		SI_3.setIndexNextBoard(9);
	}
}
