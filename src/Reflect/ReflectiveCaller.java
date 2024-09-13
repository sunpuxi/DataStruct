package src.Reflect;

import java.lang.reflect.Method;

public class ReflectiveCaller {
    public static void main(String[] args) {
        try {
            // 获取 TargetClass 的 Class 对象
            Class<?> targetClass = Class.forName("src.Reflect.TargetClass");

            // 创建 TargetClass 的实例
            Object targetInstance = targetClass.newInstance();

            // 获取 targetMethod 方法的 Method 对象
            Method targetMethod = targetClass.getMethod("targetMethod", int.class);

            // 调用 targetMethod 方法，并传入参数 5
            Object result = targetMethod.invoke(targetInstance, 5);

            // 输出结果
            System.out.println("The result of targetMethod(5) is: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
