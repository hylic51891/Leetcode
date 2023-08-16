import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: isPowerOfThree
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/9 15:20
 * @Version 1.0
 */
public class isPowerOfThree {
    public static void main(String[] args) {
//        System.out.println(isPowerOfThree(45));
//        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(19684));
    }

    /** 循环
     执行用时：
     8 ms
     99.61%
     内存消耗：
     41.7 MB
     39.01%
     */
    public static boolean isPowerOfThree(int n) {
        if(n<1) return false;
        while(n%3 ==0){
            n = n/3;
        }
        return n==1;
    }


    /**
     * 直接得出int范围内的3的最大次幂19，看n是否整除3^19
     * 打表，用一个静态表写入Integer范围内的3的幂次，挨个判断是不是
     */
    /**
     * 9ms 38%
     * 40mb 42%
     */
    static Set<Integer> set = new HashSet<>();
    static {
        int cur = 1;
        set.add(cur);
        while (cur <= Integer.MAX_VALUE / 3) {
            cur *= 3;
            set.add(cur);
        }
    }
    public boolean isPowerOfThree2(int n) {
        return n > 0 && set.contains(n);
    }
}
