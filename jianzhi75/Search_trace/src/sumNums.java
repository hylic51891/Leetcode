/**
 * ClassName: sumNums
 * Package: PACKAGE_NAME
 * https://leetcode.cn/problems/qiu-12n-lcof/description/?envType=study-plan-v2&envId=coding-interviews
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/17 0:15
 * @Version 1.0
 */
public class sumNums {
    public int sumNums(int n) {
        boolean x = n>1 && (n+=sumNums(n-1)) > 0;
        return n;
    }
}
