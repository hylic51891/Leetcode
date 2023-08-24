/**
 * ClassName: fib
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/19 16:38
 * @Version 1.0
 */
public class fib {
    public int fib(int n) {
        int f = 0;
        int f1 = 0;
        int f2 = 1;
        for(int i = 0;i<n;i++){
            f = (f1+f2)%1000000007;
            f1 = f2;
            f2 = f;
        }
        return f1;
    }
}
