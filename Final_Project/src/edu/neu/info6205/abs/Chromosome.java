package edu.neu.info6205.abs;

/**
 * The Class Chromosome.
 */
public abstract class Chromosome implements Comparable<Chromosome>{

	/** The fitness. */
	protected float fitness;
	
	/**
	 * Updates the fitness of the chromosome.
	 */
	public abstract void updateFitness();
	
	public abstract Chromosome getCopy();

	public float getFitness() {
		return fitness;
	}
	
	
}
