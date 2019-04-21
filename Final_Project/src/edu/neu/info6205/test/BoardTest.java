package edu.neu.info6205.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.neu.info6205.impl.Board;
import edu.neu.info6205.impl.MoveElement;
import edu.neu.info6205.impl.Step;

class BoardTest {
	
	@Test
	void test_initRandom() {
		Board b = new Board();
		b.initRandom();
	}

	@Test
	void test_getCopy() {
		Board a = new Board();
		a.initRandom();
		assertEquals(a.toString(),a.getCopy().toString());	
	}
	
	@Test
	void test_isValid() {
		Board a = new Board();
		a.initRandom();
		assertTrue(a.isValid());	
	}
	
	@Test
	void test_doStep() {
		Board a = new Board();
		a.initRandom();
		a.doStep(Step.Up);	
		a.doStep(Step.Down);
		a.doStep(Step.Left);
		a.doStep(Step.Right);
	}
	
	@Test
	void test_doMoveElement() {
		Board a = new Board();
		a.initRandom();
		Board b = a.getCopy();
		
		a.doStep(Step.Up);	
		a.doStep(Step.Down);
		a.doStep(Step.Left);
		a.doStep(Step.Right);
		
		Step[] moves = {Step.Up, Step.Down, Step.Left, Step.Right};
		MoveElement move = new MoveElement(moves);
		b.doMoveElement(move);
		
		assertEquals(a.toString(),b.toString());	
		
	}
}
