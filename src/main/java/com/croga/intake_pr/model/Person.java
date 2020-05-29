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
}
