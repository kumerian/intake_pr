package com.croga.intake_pr.model;

import java.util.HashSet;
import java.util.Set;

public class Persons {

    public Set<Person> persons = new HashSet<>();

    public Persons(Set<Person> persons) {
        this.persons = persons;
    }

    public Persons() {
    }

    public Persons getPersonsWithPartner() {
        Persons personsToReturn = new Persons();
        for(Person doesThisPersonHaveAPartner : this.persons) {
            if (doesThisPersonHaveAPartner.hasPartner()) {
                personsToReturn.persons.add(doesThisPersonHaveAPartner);
            }
        }
        return personsToReturn;
    }
}
