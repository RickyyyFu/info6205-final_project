package edu.neu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.neu.info6205.abs.Chromosome;
import edu.neu.info6205.impl.Board;
import edu.neu.info6205.impl.SlideChromosome;
import edu.neu.info6205.impl.SlideCrossoverHandler;

class SlideCrossoverHandlerTest {

	@Test
	void test_SlideCrossoverHandler() {
		SlideCrossoverHandler s = new SlideCrossoverHandler(0.5f);
		assertEquals(0.5f,s.CROSSOVER_RATE);
	}
	
	@Test
	void test_crossover() {
		SlideCrossoverHandler s = new SlideCrossoverHandler(0.5f);
		Board a = new Board();
		a.initRandom();
		Board b = new Board();
		b.initRandom();
		
		Chromosome chrom1 = new SlideChromosome(a);
		Chromosome chrom2 = new SlideChromosome(b);
		s.crossover(chrom1, chrom2);
	}


}
