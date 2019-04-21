package edu.neu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.neu.info6205.abs.Chromosome;
import edu.neu.info6205.impl.Board;
import edu.neu.info6205.impl.SlideChromosome;

class SlideChromosomeTest {

	@Test
	void test_SlideChromosome() {
		SlideChromosome s = new SlideChromosome();
		assertEquals(null,s.board);	
	}
	
	@Test
	void test_SlideChromosome1() {
		Board a = new Board();
		SlideChromosome s = new SlideChromosome(a);
		assertEquals(a,s.board);	
	}
	
	@Test
	void test_getCopy() {
		Board a = new Board();
		SlideChromosome s1 = new SlideChromosome(a);
		Chromosome s2 = s1.getCopy();
		assertEquals(s1.toString(),s2.toString());	
	}
	
	@Test
	void test_compareTo() {
		Board a = new Board();
		SlideChromosome s1 = new SlideChromosome(a);
		Chromosome s2 = s1.getCopy();
		assertEquals(0, s1.compareTo(s2));	
	}
	
	
	@Test
	void test_updateFitness() {
		Board a = new Board();
		a.initRandom();
		SlideChromosome s = new SlideChromosome(a);
		s.updateFitness();
	}
}
