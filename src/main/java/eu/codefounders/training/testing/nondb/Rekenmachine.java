package eu.codefounders.training.testing.nondb;

public class Rekenmachine {

	public final static int add(int a, int b) {
		return a + b;
	}

	public final static int multiply(int a, int b) {
		return a * b;
	}
	
	public final static double divide(int a, int b) {
		if (b == 0) {
			return 0;
		}

		return a / (double)b;
	}
	
}
