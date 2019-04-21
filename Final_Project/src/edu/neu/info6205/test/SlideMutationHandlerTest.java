package edu.neu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.neu.info6205.abs.Chromosome;
import edu.neu.info6205.impl.Board;
import edu.neu.info6205.impl.SlideChromosome;
import edu.neu.info6205.impl.SlideMutationHandler;

class SlideMutationHandlerTest {

	@Test
	void test_SlideMutationHandler() {
		SlideMutationHandler s = new SlideMutationHandler(0.5f);
		assertEquals(0.5f,s.MUTATION_RATE);
	}
	

	@Test
	void test_mutate() {
		SlideMutationHandler s = new SlideMutationHandler(1.0f);
		Board b = new Board();
		
		Chromosome chrom = new SlideChromosome(b);
		s.mutate(chrom);
	}
}
