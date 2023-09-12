import java.util.*;

/**
 * ClassName: LRUCache
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/28 21:49
 * @Version 1.0
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
    int maxSize;
    Deque<Integer> queue = new LinkedList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    public LRUCache(int capacity) {
        maxSize = capacity;
    }

    public int get(int key) {
        int result = map.getOrDefault(key,-1);
        if(result!=-1){
            queue.remove(key);
            queue.offerLast(key);
        }
        return result;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.put(key,value);
            queue.remove(key);
            queue.offerLast(key);
        }
        else{
            if(queue.size() == maxSize){
                map.remove(queue.pollFirst());
            }
            queue.offerLast(key);
            map.put(key,value);
        }
    }
}

class LRUCache2 {
    int capacity;
    LinkedHashMap<Integer,Integer> map;
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer,Integer>(capacity,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size()>capacity;
            }

        };
    }

    public int get(int key) {
        return map.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        map.put(key,value);
    }
}

class LRUCache3 {
    class Node{
        public int key, val;
        public Node preNode;
        public Node nextNode;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }

    }
    Node dummyHead;
    Node dummyTail;
    int capacity;
    int size;
    HashMap<Integer,Node> map;
    public LRUCache3(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummyHead = new Node(0,0);
        dummyTail = new Node(0,0);
        dummyHead.nextNode = dummyTail;
        dummyTail.preNode = dummyHead;
        size = 0;
    }

    public void addLast(Node x){
        x.preNode = dummyTail.preNode;
        x.nextNode = dummyTail;
        dummyTail.preNode.nextNode = x;
        dummyTail.preNode = x;
        size++;
    }

    public void remove(Node remove){
        remove.preNode.nextNode = remove.nextNode;
        remove.nextNode.preNode = remove.preNode;
        size--;
    }

    public void moveToTail(Node x){
        remove(x);
        addLast(x);
    }

    public int get(int key) {
        Node get = map.getOrDefault(key,new Node(0,-1));
        if(get.val!=-1){
            moveToTail(get);
        }
        return get.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node get = map.get(key);
            moveToTail(get);
            get.val = value;
        }
        else{
            Node newNode = new Node(key,value);
            addLast(newNode);
            map.put(key,newNode);
            if(size > capacity){
                map.remove(dummyHead.nextNode.key);
                remove(dummyHead.nextNode);
            }
        }
    }
}
