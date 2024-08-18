package src.bug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        test3();
    }

    public static void test1(){
        List<String> list = new ArrayList<>();
        Student student = new Student();
        for (int i = 0; i < 3; i++) {
            String name = "student" + i;
            student.setName(name);
            student.setAge(i);
            list.add(student.toString());
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void test2(){
        // 数组中的元素全部相同，存储的是引用而不是值
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        for (int i = 0; i < 3; i++) {
            String name = "student" + i;
            student.setName(name);
            student.setAge(i);
            list.add(student);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void test3(){
        // 数组中的元素全部相同，存储的是引用而不是值
        List<String> list = new ArrayList<>();
        String str = " ";
        for (int i = 0; i < 3; i++) {
            str += "i";
            list.add(str);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

}
