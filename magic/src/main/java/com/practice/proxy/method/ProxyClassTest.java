package com.practice.proxy.method;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;


public class ProxyClassTest {

    public static <T> T getProxy(Class<T> clazz) {
       return clazz.cast(Enhancer.create(clazz, getProxyMethodInterceptor()));
    }

    private static MethodInterceptor getProxyMethodInterceptor() {
        return (object, method, args, methodProxy) -> {
            boolean annotationPresent = method.isAnnotationPresent(MethodInvocationWrapperPrint.class);
            Object invocation;
            if (annotationPresent) {
                System.out.println("Start method");
                invocation = methodProxy.invokeSuper(object, args);
                System.out.println("End method");
            } else {
                return methodProxy.invokeSuper(object, args);
            }
            return invocation;
        };
    }
}
