/**
 * ClassName: reverseBits
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/10 20:58
 * @Version 1.0
 */
public class reverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
    }

    /**
     * TO 100%
     */
    public static int reverseBits(int n) {
        int res = 0;
//        String s;
        for (int i = 0; i < 32; i++) {
            res = (res<<1) + ((n >>i) & 1);

        }
//        s = Integer.toBinaryString(res);
        return res;
    }
}
