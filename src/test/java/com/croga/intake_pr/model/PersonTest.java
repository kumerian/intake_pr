package com.croga.intake_pr.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;
    DateTimeFormatter dtf;

    @BeforeEach
    void setUp() {
        person = new Person();
        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    }

    @Test
    final void NewShouldInstantiateNewPerson() {
        assertTrue(person instanceof Person);
    }

    @ParameterizedTest
    @MethodSource("testData")
    final void AllPropertiesAreSettableAndGettable(int id, String name, String birthDateString, Person parent1, Person parent2, Set<Person> children, Person partner) {
        person.id = id;
        person.name = name;
        person.birthDate = LocalDate.parse(birthDateString, dtf);
        person.parent1 = parent1;
        person.parent2 = parent2;
        person.partner = partner;
        person.children = children;
        assertEquals(person.id, id);
        assertEquals(person.name, name);
        assertEquals(person.parent1, parent1);
        assertEquals(person.parent2, parent2);
        assertEquals(person.partner, partner);
        assertEquals(person.children, children);
    }


    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, "Name", "1971-03-02", new Person(), new Person(), new HashSet<>(), new Person()),
                Arguments.of(2, "Name2", "1970-02-10", new Person(), new Person(), new HashSet<>(), new Person())
        );
    }

}