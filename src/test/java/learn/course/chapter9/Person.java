package learn.course.chapter9;

import logger.CustomLogger;

public class Person {
    private String name;
    private int age;
    private String gender;

    public Person() {
        CustomLogger.logger.info("Person default constructor");
    }

    public Person(String name) {
        this.name = name;
        CustomLogger.logger.info("Person name constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
