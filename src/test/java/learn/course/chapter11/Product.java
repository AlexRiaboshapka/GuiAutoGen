package learn.course.chapter11;

public interface Product {
    double getPrice();

    void setPrice(double price);

    String getName();

    void setName(String name);

    String getColor();

    void setColor(String color);

    default String getBarcode() {
        return "no bar";
    }

    default String getBarcode2() {
        return "no bar";
    }
}
