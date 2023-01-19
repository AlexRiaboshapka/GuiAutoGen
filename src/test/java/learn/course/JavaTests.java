package learn.course;

public class JavaTests {
    public static void main(String[] args) {
        System.out.println(whatWouldHappen());

    }
    public static int whatWouldHappen(){
        try{
            return 1;
        } catch (Exception ex){
            return 2;
        }
    }
}
