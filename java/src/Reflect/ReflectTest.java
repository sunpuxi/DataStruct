package src.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        Class<?> computeUtils;
        try {
            computeUtils = Class.forName("src.Reflect.ComputeUtils");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Method add;
        try {
            add = computeUtils.getMethod("add",int.class,int.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(add.invoke(computeUtils.newInstance(), 3,5));
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
