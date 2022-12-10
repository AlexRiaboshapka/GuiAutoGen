package learn.tasks.task4;

import java.util.ArrayList;

public class PrepareTestData {

    // "Написать первый метод,
    // который будет создавать arrayList1 с типом int и в цикле наполнять его значениями от 1 до 5.
    //Написать второй метод, который будет создавать arrayList2 с типом
    // String и в цикле наполнять его значениями из arrayList1 первого метода с преобразованием типов данных.
    //Написать третий метод, который будет делать ассерт на равенство всех данных в arrayList2 с данными в arrayList1.
    //Третий метод с аннотацией @Test.
    //Первые два создать в отельном классе PrepareTestData.
    //Создание экземпляра класса делать в BaseTest.
    //Вызов первых двух методов осуществлять в BaseTest с аннотацией @BeforeMethod"
    public ArrayList<Integer> arrayList1 = new ArrayList<>();
    public ArrayList<String> arrayList2 = new ArrayList<>();

    public void createArrayInt() {
        for (int i = 1; i < 6; i++) {
            arrayList1.add(i);
        }
    }

    public void createArrayString() {
        for (int i = 0; i < arrayList1.size(); i++) {
            arrayList2.add(String.valueOf(arrayList1.get(i)));
        }
    }
}
