package package_1;

import org.testng.annotations.Test;

public class Class3 {
    private String country;

    public Class3(String country) {
        this.country = country;
    }

    public void printText() {
        System.out.println(country);
    }
}

class Class4 {
    Class3 class3 = new Class3("DE");

    @Test
    public void test3() {
        class3.printText();
    }
}


