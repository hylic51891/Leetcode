/**
 * ClassName: firstBadVersion
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/7 20:32
 * @Version 1.0
 */
public class firstBadVersion {

    public int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        return firstBadVersion1(1,n);
    }

    /**
     * 13 ms
     * 94.23%
     * 38.1 MB
     * 83.30%
     */
    public int firstBadVersion2(int n) {
        int low = 1;
        int high = n;
        int mid;
        while(low <high){
            mid = low + (high-low)/2;
            if(isBadVersion(mid)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }

    /*
    二分查找，如果范围第一个和最后一个测试结果相同，则目标在另外一个范围内
    1. 第一个版本就是第一个失败
    */
    public int firstBadVersion1(int low,int high) {
        if(isBadVersion(low)==isBadVersion(high) || low >high) return 0;
        int mid = low + (high-low)/2;
        if(isBadVersion(mid+1)==true && isBadVersion(mid) == false) return mid+1;
        return firstBadVersion1(low,mid) + firstBadVersion1(mid+1,high);
    }

    public static boolean isBadVersion(int i){
        return true;
    }
}
