package oop.interfaces.package2;

import oop.interfaces.package1.Class1;
import org.junit.jupiter.api.Test;

public class Class3 extends Class1 {


    @Test
    public void test3() {
        setVar1("Updated var1");
        var2 = "Updated var2";
        setVar3("Updated var3");
        var4 = "Updated var4";

        System.out.println(getVar1());
        System.out.println(var2);
        System.out.println(getVar3());
        System.out.println(var4);

    }
}
