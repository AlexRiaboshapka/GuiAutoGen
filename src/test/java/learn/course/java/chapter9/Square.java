package learn.course.java.chapter9;

public class Square extends Rectangle {
    @Override
    public double calcPerimeter() {
        return sides * length;
    }
}
