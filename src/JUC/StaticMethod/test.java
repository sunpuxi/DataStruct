package src.JUC.StaticMethod;

import java.time.LocalDate;

public class test {
    public static void main(String[] args) {
        int monthValue = LocalDate.now().getMonthValue();
        System.out.println(monthValue+"=============");
    }
}
