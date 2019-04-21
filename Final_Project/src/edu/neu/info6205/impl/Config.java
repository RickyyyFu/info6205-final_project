package edu.neu.info6205.impl;

/**
 * The Class Config.
 */
public class Config {

	/** The POPULATION SIZE. */
	public static int POPULATION_SIZE = 1000;
	
	/** The MAXIMUM NUMBER OF GENERATIONS. */
	public static int MAX_GENERATION_COUNT = 10000;
	
	/** The BOARD WIDTH. */
	public static int BOARD_WIDTH = 3;

	/** The BOARD HEIGHT. */
	public static int BOARD_HEIGHT = BOARD_WIDTH;

	/** The number of generations after a population that has a constant best fitness is reseted. */
	public static int ENVIRONMENT_RESET_GENERATION_COUNT = 200;

	/** The MUTATION RATIO. */
	public static float MUTATION_RATIO = 0.5f;

	/** The CROSSOVER RATIO. */
	public static float CROSSOVER_RATIO = 0.4f;

	/** The SELECTION RATIO. */
	public static float SELECTION_RATIO = 0.5f;

	/** The Constant SORTING_ENABLED. */
	public static boolean SORTING_ENABLED = true;

	/** The Constant ELITISM_RATION. */
	public static float ELITISM_RATIO = 0.01f;

	public static boolean PRINTING = true;

}
