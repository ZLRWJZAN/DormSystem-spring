package Ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/17 19:40
 */
@Retention(RetentionPolicy.SOURCE)
public @interface Cont {

    String value();

    String anime() default "动漫";

    int age() default 17;

    String time() default "2017-02-25 20:20:20";

    String[] love() default "看书";

    SEnum a() default SEnum.CODER;

}
