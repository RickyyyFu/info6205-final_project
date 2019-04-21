package edu.neu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.neu.info6205.abs.Chromosome;
import edu.neu.info6205.abs.CrossoverHandler;
import edu.neu.info6205.abs.GeneticAlgorithm;
import edu.neu.info6205.abs.GeneticAlgorithm.Status;
import edu.neu.info6205.impl.Board;
import edu.neu.info6205.impl.RouletteWheelSelectionHandler;
import edu.neu.info6205.impl.SlideCrossoverHandler;
import edu.neu.info6205.impl.SlideMutationHandler;
import edu.neu.info6205.impl.SlidePuzzleGA;
import edu.neu.info6205.abs.MutationHandler;
import edu.neu.info6205.abs.SelectionHandler;

class SlidePuzzleGATest {

	SelectionHandler selectionH = new RouletteWheelSelectionHandler(0.5f);
	MutationHandler mutationH = new SlideMutationHandler(0.5f); 
	CrossoverHandler crossoverH = new SlideCrossoverHandler(0.5f);
	Board board = new Board();
	
	@Test
	void testGenerate() {
		board.initRandom();
		SlidePuzzleGA sg = new SlidePuzzleGA(selectionH,mutationH,crossoverH,board);
		ArrayList<Chromosome> list = sg.generate(5);
		assertEquals(5,list.size());
	}

//	@Test
//	void testUpdateStatus() {
//		board.initRandom();
//		SlidePuzzleGA sg = new SlidePuzzleGA(selectionH,mutationH,crossoverH,board);
//		
//		assertEquals(Status.PROCESSING,sg.updateStatus());
//		
//	}

	@Test
	void testBeginGenerationCallback() {
		board.initRandom();
		SlidePuzzleGA sg = new SlidePuzzleGA(selectionH,mutationH,crossoverH,board);
		sg.beginGenerationCallback();
		
		assertEquals(1,sg.generation);
	}

	@Test
	void testEndGenerationCallback() {
		board.initRandom();
		SlidePuzzleGA sg = new SlidePuzzleGA(selectionH,mutationH,crossoverH,board);
		sg.endGenerationCallback();

	}

//	@Test
//	void testResetEnvironment() {
//		board.initRandom();
//		SlidePuzzleGA sg = new SlidePuzzleGA(selectionH,mutationH,crossoverH,board);
////		Chromosome c1 = new SlideChromosome();		
//		Chromosome c2 = new SlideChromosome(board);
//		
////		assertFailure(sg.resetEnvironment(c1);
//		sg.resetEnvironment(c2);
//	}

	@Test
	void testAlgorithmCompleteCallBack() {
		board.initRandom();
		SlidePuzzleGA sg = new SlidePuzzleGA(selectionH,mutationH,crossoverH,board);
		Status s1 = Status.PROCESSING;
		Status s2 = Status.SUCCESSFULL;
		Status s3 = Status.TIMEOUT;
		sg.algorithmCompleteCallBack(s1);
		sg.algorithmCompleteCallBack(s2);
		sg.algorithmCompleteCallBack(s3);
	}


}
