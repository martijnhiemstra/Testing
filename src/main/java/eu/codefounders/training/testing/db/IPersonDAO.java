package eu.codefounders.training.testing.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonDAO extends JpaRepository<Person, Integer> {
	
	List<Person> findByFirstName(String firstName);
	
	List<Person> findByAgeBetween(int a, int b);

}
