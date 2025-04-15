package com.practice.proxy.method;

public class SomeClassTest implements ClassTest {

    @MethodInvocationWrapperPrint
    public void test() throws InterruptedException {
        Thread.sleep(2000);
    }
}
