package learn.dojo;

import logger.CustomLogger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class PeopleTests {
    Person luk = new Person(Person.Gender.MALE, "Luk", 30, "yellow", 0);
    Person moshe = new Person(Person.Gender.MALE, "Moshe", 45, "green", 0);
    Person taras = new Person(Person.Gender.MALE, "Taras", 33, "blue", 0);
    Person sara = new Person(Person.Gender.FEMALE, "Sara", 40, "white", 0);
    Person marg = new Person(Person.Gender.FEMALE, "Marg", 36, "blue", 0);
    List<Person> peopleDB = Arrays.asList(luk, moshe, taras, sara, marg);
    Predicate<Person> COLOR_YELLOW = person -> person.getFavoriteColors().contains("yellow");

    @Test
    public void testPeopleCreated() {
        CustomLogger.logger.info(peopleDB);
    }

    @Test
    public void getPeopleWithColorBlue() {
        List<Person> matchingPeople = peopleDB.stream()
                .filter(person -> person.getFavoriteColors().contains("blue"))
                .collect(Collectors.toList());
        CustomLogger.logger.info(matchingPeople);
        Assertions.assertThat(matchingPeople).contains(taras, marg);
    }

    @Test
    public void getPeopleWithColorYellow() {
        PeopleDb peopleDb = new PeopleDb(peopleDB);
        List<Person> matchingPeople = peopleDb.matchPeople(COLOR_YELLOW);
        CustomLogger.logger.info(matchingPeople);
        Assertions.assertThat(matchingPeople).contains(luk);
    }
}
