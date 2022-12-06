package oop.interfaces.package1;

import org.junit.jupiter.api.Test;

public class Class1 extends Class2 {

    public String var4 = "var4";
    protected String var2 = "var2";
    String var3 = "var3";
    private String var1 = "var1";

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    @Test
    public void test1() {
        printText("someText");
    }
}
