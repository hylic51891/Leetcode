import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: MaxQueue
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/11 22:44
 * @Version 1.0
 */
public class MaxQueue {
    Deque<Integer> deque;
    Deque<Integer> priQueue;
    public MaxQueue() {
        deque = new LinkedList<>();
        priQueue = new LinkedList<>();
    }

    public int max_value() {
        if(priQueue.isEmpty()) return -1;
        return priQueue.peekFirst();
    }

    public void push_back(int value) {
        deque.offerLast(value);
        while(!priQueue.isEmpty() && value > priQueue.peekLast()){
            priQueue.pollLast();
        }
        priQueue.offerLast(value);
    }

    public int pop_front() {
        if(deque.isEmpty()) return -1;
        int poll =  deque.pollFirst();
        if(poll == priQueue.peekFirst()){
            priQueue.pollFirst();
        }
        return poll;
    }
}
