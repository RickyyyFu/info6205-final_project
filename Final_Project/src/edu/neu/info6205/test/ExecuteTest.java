package edu.neu.info6205.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.neu.info6205.impl.Execute;

class ExecuteTest {

	@Test
	void test_run() {
		Thread e = new Execute();
		e.start();
	}
	
}
