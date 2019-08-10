package Ann;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/17 21:20
 */

public class Ather {
    public static void main(String[] args) throws NoSuchMethodException {
        Class annClass = An.class;

        Annotation annotation = annClass.getAnnotation(An.class);
        System.out.println(annotation);
    }
}
