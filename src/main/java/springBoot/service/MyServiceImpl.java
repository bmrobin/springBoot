package springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springBoot.data.MyRepository;
import springBoot.data.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author brobinson
 */
@Service
@Profile("prod")
public class MyServiceImpl implements MyService {

    @Autowired
    private MyRepository repository;

    public Person savePerson(String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return repository.save(person);
    }

    public Person findPerson(Long id) {
        return repository.findOne(id);
    }

    public List<Person> findPeople() {
        List<Person> people = new ArrayList<Person>();

        for (Person person : repository.findAll()) {
            people.add(person);
        }

        return people;
    }

    public void deletePeople() {
        repository.deleteAll();
    }
}
