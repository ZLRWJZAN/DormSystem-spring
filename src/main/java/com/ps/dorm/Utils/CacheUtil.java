package com.ps.dorm.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 第一步，私有化构造器
 *
 * 2. 提供 instance对象  static private 属性
 *
 * 3. 提供一个获取实例的方法
 *
 * 封装
 *
 *
 * 思考：
 *     map 会爆掉, 内存会溢出
 *
 *     //  缓存 淘汰策略
 *     1. 限制大小
 *     2. 淘汰策略
 *     https://blog.csdn.net/angelzhangtiantian/article/details/80652222
 *
 *
 */
public class CacheUtil {

    private static CacheUtil instance = new CacheUtil();

    private Map<String, Recode> cache = new HashMap();
    // key value
    // a    1
    // b    2

    private CacheUtil() {}

    public static CacheUtil get(){
        return instance;
    }

    public void put(String key , Object value , long time){
        Recode r = new Recode();
        r.setEffectiveTime(System.currentTimeMillis() +  (time * 1000));
        r.setObject(value);
        cache.put(key, r);
    }

    public <T> T get(String key) {
        Recode recode = cache.get(key);

        if(recode == null) {
            return null;
        }

        //  判断是否是失效
        if(System.currentTimeMillis() > recode.getEffectiveTime()){
            cache.remove(key);
            return null;
        }

        return (T)recode.getObject();
    }

    class Recode {
        private Object object;

        private long effectiveTime;

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public long getEffectiveTime() {
            return effectiveTime;
        }

        public void setEffectiveTime(long effectiveTime) {
            this.effectiveTime = effectiveTime;
        }
    }
}
