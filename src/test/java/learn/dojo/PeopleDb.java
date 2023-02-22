package learn.dojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Getter
@AllArgsConstructor
public class PeopleDb {
    private List<Person> peopleDb;

    public List<Person> matchPeople(Predicate<Person> check) {
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person: peopleDb
             ) {
            if(check.test(person)){
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }
}
