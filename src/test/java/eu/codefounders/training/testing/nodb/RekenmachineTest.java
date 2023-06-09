package eu.codefounders.training.testing.nodb;

import static org.junit.jupiter.api.Assertions.assertEquals;

// !!!!!!!!! Important. Use jupiter junit tests
import org.junit.jupiter.api.Test;

import eu.codefounders.training.testing.nondb.Rekenmachine;

// @RunWith(SpringRunner.class)
public class RekenmachineTest {

	@Test
	public void test_add() {
		assertEquals(7, Rekenmachine.add(2, 5));
		assertEquals(12, Rekenmachine.add(6, 6));
		assertEquals(4, Rekenmachine.add(103, -99));
	}

	@Test
	public void test_multiply() {
		assertEquals(4, Rekenmachine.multiply(2, 2));
		assertEquals(0, Rekenmachine.multiply(2, 0));
		assertEquals(495, Rekenmachine.multiply(99, 5));
	}
	
	@Test
	public void test_divide() {
		assertEquals(2, Rekenmachine.divide(4, 2));
		assertEquals(-4, Rekenmachine.divide(16, -4));
		assertEquals(1.5, Rekenmachine.divide(6, 4));
		assertEquals(0, Rekenmachine.divide(6, 0));
	}

}
