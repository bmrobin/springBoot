package springBoot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springBoot.service.MyService;
import springBoot.data.Person;

import java.util.List;

/**
 * @author brobinson
 */
@Controller
public class MyController {

    @Autowired
    private MyService service;

    @RequestMapping("/")
    public String index(Model model) {
        String myTextVariable = "Hello MCJUG!";
        Person person = new Person();
        List<Person> people = service.findPeople();
        model.addAttribute("people", people);
        model.addAttribute("person", person);
        return "index";
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getPerson(@PathVariable Long id) {
        Person retrievedPerson = service.findPerson(id);
        return "Meet " + retrievedPerson.getFirstName() + " " + retrievedPerson.getLastName();
    }

    @RequestMapping(value = "/person/new", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute Person person) {
        service.savePerson(person.getFirstName(), person.getLastName());
        return "success";
    }

    @RequestMapping(value = "/person/delete", method = RequestMethod.GET)
    public String deletePeople() {
        service.deletePeople();
        return "success";
    }


}
