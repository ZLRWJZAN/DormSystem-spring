package com.ps.dorm.proxy;

import com.ps.dorm.Utils.CacheUtil;
import com.ps.dorm.annotation.Cache;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CacheProxy implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 1. 使用CGlib代理
        // 2. 去找真实对象的 Method对象 invocation.getThis().getClass().getMethod(invocation.getMethod().getName(), ..);
        Cache cache = invocation.getMethod().getAnnotation(Cache.class);

        String key = invocation.getThis().getClass().getName() + invocation.getMethod().getName();

        // 1.
        Object object = CacheUtil.get().get(key); // key 规则  包+类+方法+参数
        if(object != null) {
            System.out.println("有缓存");
            return object;
        }

        // 2. 调用真实对象
        System.out.println("无缓存， 走真实对象");
        Object result = invocation.proceed();

        // 3.
        System.out.println("放入缓存： " + key + "   " + result);
        CacheUtil.get().put(key, result, cache.time());

        return result;
    }
}