package eu.codefounders.training.testing.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping("/api/person/all")
	public List<Person> vindAllePersonen() {
		List<Person> personen = personService.findAll();

		return personen;
	}

	@RequestMapping("/api/person/count")
	public long count() {
		return personService.count();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/person")
	public Person create(@RequestBody Person person) {
		return personService.create(person);
	}

}
