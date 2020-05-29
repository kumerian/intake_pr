package com.croga.intake_pr.model;

import java.time.LocalDate;
import java.util.Set;

public class Person {

    public int id;
    public String name;
    public LocalDate birthDate;
    public Person parent1;
    public Person parent2;
    public Set<Person> children;
    public Person partner;

    public Person() {
    }

    public Person(int id, String name, LocalDate birthDate, Person parent1, Person parent2, Set<Person> children, Person partner) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.children = children;
        this.partner = partner;
    }

    public boolean hasPartner() {
        return this.partner != null;
    }

    public int howManyChildren() { return this.children.size();}

}
