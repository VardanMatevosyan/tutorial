package com.practice.proxy.parameter;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Parameter;
import java.util.Collection;

public class ProxyDataHolderTest {

    public static <T> T getProxy(Class<T> clazz) {
        return clazz.cast(Enhancer.create(clazz, getProxyMethodInterceptor()));
    }

    private static MethodInterceptor getProxyMethodInterceptor() {
        return (object, method, args, methodProxy) -> {
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                boolean annotationPresent = parameters[i].isAnnotationPresent(PrintMaxValue.class);
                if (annotationPresent) {
                    Collection<Integer> arg = (Collection<Integer>) args[i];
                    Integer max = arg.stream().max(Integer::compare).get();
                    System.out.println("Max value is " + max);
                    return methodProxy.invokeSuper(object, args);
                }
            }

            return methodProxy.invokeSuper(object, args);
        };
    }

}
