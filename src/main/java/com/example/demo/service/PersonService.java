package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.model.Person;


@Service
public class PersonService {
    private List<Person> persons = new ArrayList<Person>();

    public PersonService()
    {
        persons.add(new Person("Mark", "Kwan"));
        persons.add(new Person("Darryl", "Eddie"));
        persons.add(new Person("James","Pang"));
    }

    public List<Person> getPersons()
    {
        return this.persons;
    }

    //create
    public void addPerson(Person newPerson)
    {
        persons.add(new Person(newPerson.getFirstName(), newPerson.getLastName()));
    }

    //delete
    public void removePerson(Person personToDelete)
    {
        Person foundPerson = persons.stream().filter(p-> p.getId().equals(personToDelete.getId())).findAny().orElse(null);
        persons.remove(foundPerson);
    }

    //update
    public void updatePerson(Person personToUpdate)
    {
        Person foundPerson = persons.stream().filter(p->p.getId().equals(personToUpdate.getId())).findAny().orElse(null);

        Person updatePerson = new Person();
        updatePerson.setId(personToUpdate.getId());
        updatePerson.setFirstName(personToUpdate.getFirstName());
        updatePerson.setLastName(personToUpdate.getLastName());
        persons.remove(foundPerson);
        persons.add(updatePerson);



    }
}
