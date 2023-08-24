import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: findContinuousSequence
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/20 22:42
 * @Version 1.0
 */
public class findContinuousSequence {
    /**
     * 前缀和
     */
    public int[][] findContinuousSequence(int target) {
        int max = (target+1)/2;
        int[] prefix = new int[max+1];
        ArrayList<int[]> list = new ArrayList<>();
        prefix[0] = 0;
        for (int i = 1; i < max+1; i++) {
            prefix[i] = prefix[i-1]+i;
        }
        for(int i = 0;i<max;i++){
            for (int j = i+2; j < max+1; j++) {
                if(prefix[j]-prefix[i] > target) break;
                else if (prefix[j]-prefix[i] == target) {
                    list.add(sequence(i+1,j));
                    break;
                }
            }
        }
        int size = list.size();
        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] sequence(int i,int j){
        int len = j-i+1;
        int[] ret = new int[len];
        for (int k = 0; k < len; k++) {
            ret[k] = i+k;
        }
        return ret;
    }


    public int[][] findContinuousSequence2(int target) {

    }
}
