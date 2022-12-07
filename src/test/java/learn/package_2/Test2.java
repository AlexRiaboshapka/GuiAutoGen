package learn.package_2;

import learn.package_1.Class1;

public class Test2 {
    public static void main(String[] args) {
        Class1 class1 = new Class1(); // created new class object
        class1.method1("package_2.Test2 ");
        System.out.println(class1.getClass());
    }
}
