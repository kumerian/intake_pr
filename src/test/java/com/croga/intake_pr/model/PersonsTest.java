package com.croga.intake_pr.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PersonsTest {

    private Persons persons;
    private DateTimeFormatter dtf;

    @BeforeEach
    void setUp() {
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Test
    final void filterPersonsByPartner() {
        Person person1 = new Person(1, "Name",  LocalDate.parse("1971-03-02", dtf), new Person(), new Person(), new HashSet<>(), new Person());
        Person person2 = new Person(1, "Name", LocalDate.parse("1971-03-02", dtf), new Person(), new Person(), new HashSet<>(), null);
        persons = new Persons();
        persons.persons.add(person1);
        persons.persons.add(person2);
        Persons resultPersons = persons.getPersonsWithPartner();
        assertEquals(1, resultPersons.persons.size());
        assertTrue(resultPersons.persons.contains(person1));
    }

    @Test
    final void filterPersonsByNumberOfChildren() {
        Person person1 = new Person(1, "Name",  LocalDate.parse("1971-03-02", dtf), new Person(), new Person(), new HashSet<>(), new Person());
        Person person2 = new Person(1, "Name", LocalDate.parse("1971-03-02", dtf), new Person(), new Person(), new HashSet<>(), null);
        Person child1 = new Person(1, "Name",  LocalDate.parse("1971-03-02", dtf), new Person(), new Person(), new HashSet<>(), new Person());
        Person child2 = new Person(1, "Name", LocalDate.parse("1971-03-02", dtf), new Person(), new Person(), new HashSet<>(), null);
        Person child3 = new Person(1, "Name", LocalDate.parse("1971-03-02", dtf), new Person(), new Person(), new HashSet<>(), null);
        person1.children.add(child1);
        person1.children.add(child2);
        person1.children.add(child3);
        persons = new Persons();
        persons.persons.add(person1);
        persons.persons.add(person2);
        Persons resultPersons = persons.getPersonsByNumberOfChildren(3);
        assertEquals(1, resultPersons.persons.size());
        assertTrue(resultPersons.persons.contains(person1));
    }

}