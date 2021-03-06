package edu.neu.info6205.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import edu.neu.info6205.abs.Chromosome;
import edu.neu.info6205.abs.CrossoverHandler;
import edu.neu.info6205.abs.GeneticAlgorithm;
import edu.neu.info6205.abs.MutationHandler;
import edu.neu.info6205.abs.SelectionHandler;

/**
 * The Class SlidePuzzleGA.
 */
public class SlidePuzzleGA extends GeneticAlgorithm {

	/** The Constant MAX_ITERATION_COUNT. */
	private static final int MAX_GENERATION_COUNT = Config.MAX_GENERATION_COUNT;

	/** The board. */
	Board board;

	/** The start board. */
	Board startBoard;

	/** The rand. */
	Random rand = new Random();

	/** The generation. */
	public int generation = 0;

	protected ArrayList<MoveElement> globalMoves;

	public SlidePuzzleGA(SelectionHandler selectionH, MutationHandler mutationH, CrossoverHandler crossoverH,
			Board board) {
		super(selectionH, mutationH, crossoverH);
		this.board = board;
		this.startBoard = board.getCopy();
		this.globalMoves = new ArrayList<MoveElement>();
	}

	@Override
	public ArrayList<Chromosome> generate(int count) {
		ArrayList<Chromosome> chromos = new ArrayList<Chromosome>();
		log.warn("Generating a new population of size " + count);

		for (int i = 0; i < count; i++) {
			// Create a new chromosome of variable size
			SlideChromosome chrom = new SlideChromosome(board);
			int size = rand.nextInt(SlideChromosome.MAX_CHROM_SIZE - SlideChromosome.MIN_CHROM_SIZE);
			ArrayList<MoveElement> possibleMoves = MoveElement.getAllPossibleMoves();

			for (int j = 0; j < size + SlideChromosome.MIN_CHROM_SIZE; j++)
				chrom.moves.add(possibleMoves.get(rand.nextInt(possibleMoves.size())));
			log.debug("Generated Chromosome: " + chrom);

			// Add the chromosome to the list
			chromos.add(chrom);
		}
		log.info("Generation of population successful.");
		return chromos;
	}

	protected Status updateStatus() {
		// If the maximum generation count was reached
		if (generation > MAX_GENERATION_COUNT) {
			log.warn("Timeout reached");
			return Status.TIMEOUT;
		}

		// If any of the chromosomes is a solution (i.e. the fitness equals 0)
		for (Chromosome chrom : population)
			if (chrom.getFitness() == 0) {
				SlideChromosome sChrom = (SlideChromosome) chrom;
				globalMoves.addAll(sChrom.moves);
				log.warn("Solution found in generation " + generation + ": " + globalMoves);
				return Status.SUCCESSFULL;
			}

		return Status.PROCESSING;
	}

	@Override
	public void beginGenerationCallback() {
		generation++;
		log.warn("New generation starting: " + generation);
	}

	@Override
	public void endGenerationCallback() {
		log.warn("Generation ended. Best fitness: " + this.bestFitness);
	}

	@Override
	protected void resetEnvironment(Chromosome bestChromosome) {
		log.warn("Resetting population based on the best chromosome: " + bestChromosome);

		// Update the board according to the moves in the best chromosome
		SlideChromosome chrom = (SlideChromosome) bestChromosome;
		for (MoveElement move : chrom.moves)
			board.doMoveElement(move);

		// Save the moves
		globalMoves.addAll(chrom.moves);

		// Reset the population
		population = generate(POPULATION_SIZE);
		for (Chromosome chromos : population)
			chromos.updateFitness();
	}

	@Override
	public void algorithmCompleteCallBack(Status status) {

		if (Config.PRINTING) {
			// Print the solution
			System.out.println("A solution was found in " + generation + " generations: ");
			StringBuffer out = new StringBuffer();
			for (MoveElement move : globalMoves)
				for (Step step : move.steps)
					out.append(step + ", ");
			System.out.println(out.toString());

			// Make and print the moves
			System.out.println(startBoard);
			for (MoveElement move : globalMoves) {
				System.out.println("Making moves: " + Arrays.toString(move.steps));
				startBoard.doMoveElement(move);
				System.out.println(startBoard);
			}
		}
		
		// Hack for evaluation
		Execute.finishedGenerationsCount=generation;
	}

}
