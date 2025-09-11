package com.practice.base;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Obj obj1 = new Obj();
        Obj obj2 = new Obj();
        Thread thread1 = new Thread(() -> obj1.doSome(obj2, "obj2"));
        Thread thread2 = new Thread(() -> obj2.doSome(obj1, "obj1"));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private static class Obj {
        private synchronized void doSome(Obj obj, String objName) {
            sleepFor(1000);
            System.out.println(objName + ".doSomeTest() " + Thread.currentThread().getName());
            obj.doSomeTest();
            System.out.println("This will never invoke ");
        }
        private synchronized void doSomeTest() {
            System.out.println("This will never invoke" + Thread.currentThread().getName());
        }
    }

    private static void sleepFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
