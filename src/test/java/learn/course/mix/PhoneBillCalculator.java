package learn.course.mix;

public class PhoneBillCalculator {

    public static void main(String[] args) {
        PhoneBill phoneBill1 = new PhoneBill(1234);
        phoneBill1.setMinutesUsed(200);
        phoneBill1.printItemizedBill();
    }
}
