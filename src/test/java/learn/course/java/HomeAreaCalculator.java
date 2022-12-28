package learn.course.java;

public class HomeAreaCalculator {
    public static void main(String[] args) {
        /*
         * Rectangle 1
         */
        Rectangle room1 = new Rectangle();
        room1.setWidth(10);
        room1.setLength(5);
        double areaOfRoom1 = room1.calculateArea();

        Rectangle room2 = new Rectangle(15, 15);
        double areaOfRoom2 = room2.calculateArea();
    }
}
