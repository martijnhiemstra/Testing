package eu.codefounders.training.testing.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PersonTest {

	@Test
	public void test_gettersAndSetters() {
		Person p = new Person();
		p.setAge(1);
		p.setFirstName("Frans");
		p.setLastName("L");
		p.setId(10);
		
		assertEquals(1, p.getAge());
		assertEquals("Frans", p.getFirstName());
		assertEquals("L", p.getLastName());
		assertEquals(10, p.getId());
	}
	
}
