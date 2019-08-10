package com.ps.dorm.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 作者：ZLRWJSAN
 * 创建于 2019/6/19 16:34
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value();
}
