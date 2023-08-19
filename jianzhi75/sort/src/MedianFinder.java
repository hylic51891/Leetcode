import java.util.PriorityQueue;

/**
 * ClassName: MedianFinder
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/19 0:21
 * @Version 1.0
 */
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(-1);
        m.addNum(-2);
        System.out.println(m.findMedian());
        m.addNum(-3);
        m.addNum(-4);
        m.addNum(-5);
        System.out.println(m.findMedian());
    }
    PriorityQueue<Integer> rightHeap;
    PriorityQueue<Integer> leftHeap;
    int size;
    /** initialize your data structure here. */
    public MedianFinder() {
        rightHeap = new PriorityQueue<>();
        leftHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
        size = 0;
    }

    public void addNum(int num) {
        if (leftHeap.size() >= rightHeap.size()) {
            leftHeap.offer(num);
            rightHeap.offer(leftHeap.poll());
        } else {
            rightHeap.offer(num);
            leftHeap.offer(rightHeap.poll());
        }
        size++;
    }

    public double findMedian() {
        if(size == 0) return 0.0;
        if(size%2==0) return ((double)rightHeap.peek()+leftHeap.peek())/2.0;
        if(rightHeap.size() > leftHeap.size()) return rightHeap.peek();
        else return leftHeap.peek();
    }
}
