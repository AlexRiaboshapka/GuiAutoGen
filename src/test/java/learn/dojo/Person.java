package learn.dojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    public enum Gender {MALE, FEMALE};
    private Gender gender;
    private String name;
    private int age;
    private String favoriteColors;
    private int points;
    public void earnPoints(int points){
        this.points += points;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
