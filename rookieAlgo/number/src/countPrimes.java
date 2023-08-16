import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: countPrimes
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/9 11:17
 * @Version 1.0
 */
public class countPrimes {
    /** 原理：所有数都可以表示为质数的乘积
     * 埃氏筛实现，当前质数x，把x*x以及x*(x+1)...标记为合数
     * 117ms 68%
     * 45.63mb 56%
     */
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes,true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(primes[i]){
                count++;
                for (long j = (long)i*i; j < n; j+=i) {
                    primes[(int)j] = false;
                }
            }
        }
        return count;
    }
    /** 线性筛
     * 线性筛实现：埃氏筛基础上不重复去除已经被标记的合数，由于所有数都可以表示为质数的乘积，所以合数通过最小的质数去除就能避免重复去除
     * 方法：维护一个已经查找到的质数数组，遍历1-n，设当前遍历到x
     * 1. 如果没有被标记，则为质数，放进质数数组
     * 2. 无论x是否为质数，遍历质数数组，标记[x*prime]位置为合数，如果x可以由质数数组中的某质数prime1整除，直接break
     * 解释：如果x可以由质数数组中的某质数prime1整除，则该数的最小质因数就是prime1,
     * 假设有y = x*prime2(prime2 > prime1),则这个y可以表示为y = x/prime1 * prime1 * prime2
     * 也就是当遍历到prime2*x/prime1的时候y会通过prime1标记，则此时就不需要遍历到prime2
     *
     * 269ms 15%
     * 55.44mb 38%
     */
    public int countPrimes2(int n) {
        boolean[] visited = new boolean[n];
        ArrayList<Integer> primes= new ArrayList<>();
        Arrays.fill(visited,false);
        for (int i = 2; i < n; i++) {
            if(!visited[i]){
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && 1l * i* primes.get(j) < n;j++) {
                visited[i* primes.get(j)] =true;
                if(i%primes.get(j) == 0 ) break;
            }

        }
        return primes.size();
    }
}
