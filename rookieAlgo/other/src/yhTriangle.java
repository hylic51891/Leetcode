import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: yhtriangle
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/10 21:09
 * @Version 1.0
 */


public class yhTriangle {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 96.54%
     * 的用户
     * 内存消耗：
     * 39.8 MB
     * , 在所有 Java 提交中击败了
     * 89.05%
     * 的用户
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0 || j == i){
                    curRow.add(1);
                }
                else{
                    curRow.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }
            }
            ret.add(curRow);
        }
        return ret;
    }
}
