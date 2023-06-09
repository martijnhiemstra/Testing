package eu.codefounders.training.testing.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private IPersonDAO iPersonDAO;

	public Optional<Person> findById(final int id) {
		return this.iPersonDAO.findById(id);
	}
	
	public List<Person> findByAgeBetween(int a, int b) {
		return iPersonDAO.findByAgeBetween(a, b);
	}
	
	public int countByAge(int a, int b) {
		List<Person> persons = iPersonDAO.findByAgeBetween(a, b);

		int total = 0;
		for (Person p : persons) {
			total += p.getAge();
		}

		return total;
	}

	public List<Person> findAll() {
		return this.iPersonDAO.findAll();
	}

	public long count() {
		return this.iPersonDAO.count() + 1;
	}

	public Person create(final Person p) {
		if (p.getFirstName() == null || p.getFirstName().isBlank())
			throw new IllegalArgumentException("First name must be supplied");

		return this.iPersonDAO.save(p);
	}

	public void update(final Person p) {
		this.iPersonDAO.save(p);
	}

	public void delete(final Person p) {
		this.iPersonDAO.save(p);
	}

}
