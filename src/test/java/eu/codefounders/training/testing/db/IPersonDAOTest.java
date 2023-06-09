package eu.codefounders.training.testing.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class IPersonDAOTest {

	@Autowired
	private IPersonDAO iPersonDAO;

	@Test
	public void test_findById() {
		// Input
		int input = 1;

		// Actie + Output
		Optional<Person> optional = this.iPersonDAO.findById(input);

		// Test
		assertEquals(true, optional.isPresent());
		assertEquals("Martijn", optional.get().getFirstName());
		assertEquals("Hiemstra", optional.get().getLastName());
	}
	
	@Test
	public void test_findAll_empty() {
		List<Person> persons = this.iPersonDAO.findByFirstName("ZZZZZZ");
		
		assertEquals(0, persons.size());
		assertEquals(true, persons.isEmpty());
	}

	@Test
	public void test_findAll_validname() {
		List<Person> persons = this.iPersonDAO.findByFirstName("Martijn");
		
		assertEquals(1, persons.size());
		assertEquals(false, persons.isEmpty());
		assertEquals("Hiemstra", persons.get(0).getLastName());
	}

}
