package sk.tomashrdy.services;

import sk.tomashrdy.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonServices {

    private static PersonServices instance = null;
    private Map<Long, Person> persons = new HashMap<>();
    private PersonServices (){
        Person person1 = new Person(1L ,"Tomáš" , "Hrdý" , 25);
        Person person2 = new Person(2L ,"Janka" , "Michalkova" , 24);

        persons.put(person1.getId(), person1);
        persons.put(person2.getId(), person2);
    }

    public static PersonServices getPersonService(){
        if (instance == null){
            return instance = new PersonServices();
        }return instance;
    }


    public List<Person> getAllPerson(){
        return new ArrayList<>(persons.values());
    }

    public Person getPersonById(long id){
        return persons.get(id);
    }

}
