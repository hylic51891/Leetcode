package _1114_e;

import java.util.function.IntConsumer;

/**
 * ClassName: Foo
 * Package: _1114_e
 * Description:
 *
 * @Author hylic
 * @Create 2023/6/23 19:42
 * @Version 1.0
 */
class Foo {
    private volatile int flag;    // 1 2 3
    private final Object lock = new Object();
    public Foo() {
        flag = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            while(flag != 1){
                lock.wait();
            }
            printFirst.run();
            flag = 2;
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

        lock.notifyAll();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while(flag != 2){
                lock.wait();
            }
            printSecond.run();
            flag = 3;
        }
        // printSecond.run() outputs "second". Do not change or remove this line.

        lock.notifyAll();
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock){
            while(flag != 3){
                lock.wait();
            }
            printThird.run();
        }
        // printThird.run() outputs "third". Do not change or remove this line.

    }

}