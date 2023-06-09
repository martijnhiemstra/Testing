package eu.codefounders.training.testing.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@InjectMocks
    private PersonService service;

    @Mock
    private IPersonDAO repo;
    
    @Test
    public void test_findById() {
        Person person1 = new Person(1, "Martijn", "Hiemstra", 23);

        Mockito.when(repo.findById(1)).thenReturn(Optional.of(person1));

        assertEquals(true, service.findById(1).isPresent());
        assertEquals("Martijn", service.findById(1).get().getFirstName());
    }

    @Test
    public void test_findByIdEmpty() {
        Mockito.when(repo.findById(99)).thenReturn(Optional.empty());

        assertEquals(false, service.findById(99).isPresent());
    }

    @Test
    public void test_create_empty_firstname() {
    	Person person1 = new Person(1, "", "Hiemstra", 3);
    	
    	IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.service.create(person1);
    	});

    	assertEquals("First name must be supplied", thrown.getMessage());
    }
    
    @Test
    public void test_countByAge() {
    	Person person1 = new Person(0, "Person", "1", 1);
    	Person person2 = new Person(0, "Person", "2", 2);
    	Person person3 = new Person(0, "Person", "3", 3);
    	
    	List<Person> persons = Arrays.asList(person1, person2, person3);
    	
    	Mockito.when(repo.findByAgeBetween(2,  6)).thenReturn(persons);
    	
    	assertEquals(6, service.countByAge(2, 6));
    }
    
}
