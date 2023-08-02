package _1195_m;

import java.util.function.IntConsumer;

/**
 * ClassName: FizzBuzz
 * Package: _1195_m
 * Description:
 * 1195. 交替打印字符串
 *  https://leetcode.cn/problems/fizz-buzz-multithreaded/submissions/
 *
 * @Author hylic
 * @Create 2023/6/23 21:00
 * @Version 1.0
 */

/**
 * 执行用时: 6 ms
 * 内存消耗: 41.3 MB
 */
class FizzBuzz {
    private int n;
    private int i;
    public FizzBuzz(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i<=n){
            if(i%3==0 && i%5!=0){
                printFizz.run();
                i++;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i<=n){
            if(i%5==0 && i%3!=0){
                printBuzz.run();
                i++;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i<=n){
            if(i%3==0 && i%5==0){
                printFizzBuzz.run();
                i++;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i<=n){
            if(i%3!=0 && i%5!=0){
                printNumber.accept(i);
                i++;
            }
        }
    }
}

/**
 执行用时: 5 ms
 内存消耗: 41.4 MB
 */
class FizzBuzz2 {
    private int n;
    private int i;
    private volatile int flag;
    public FizzBuzz2(int n) {
        this.n = n;
        this.i = 1;
    }

    public void judge(){
        if(i>n){
            return;
        }
        if(i%3==0 ){
            if(i%5==0){
                flag = 3;
            }
            else{
                flag = 1;
            }
        }
        else{
            if(i%5==0){
                flag = 2;
            }
            else{
                flag = 4;
            }
        }
    }
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i<=n){
            if(flag == 0){
                judge();
            }
            if(flag == 1){
                printFizz.run();
                i++;
                flag = 0;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i<=n){
            if(flag == 0){
                judge();
            }
            if(flag == 2){
                printBuzz.run();
                i++;
                flag = 0;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i<=n){
            if(flag == 0){
                judge();
            }
            if(flag == 3){
                printFizzBuzz.run();
                flag = 0;
                i++;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i<=n){
            if(flag == 0){
                judge();
            }
            if(flag == 4){
                printNumber.accept(i);
                flag = 0;
                i++;
            }
        }
    }
}