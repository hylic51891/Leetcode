package _1782_H;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * ClassName: countPairs
 * Package: _1782_H
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/23 20:48
 * @Version 1.0
 */
public class countPairs {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<int[]> usedEdges = new HashSet<>();
        for(int[] edge:edges){
            if(usedEdges.add(edge)){
                map.put(edge[0],map.getOrDefault(edge[0],0)+1);
                map.put(edge[1],map.getOrDefault(edge[1],0)+1);
            }
        }
//        Integer[] nodes = map.keySet().toArray(new Integer[0]);
        Integer[] edgeVal = map.values().toArray(new Integer[0]);
        Arrays.sort(edgeVal);
        int maxVal = edgeVal[n-1]+edgeVal[n-2];
        int[] twoSum = new int[maxVal+1];
        for(int left = 0;left < n-1;left++){
            for(int right = left+1;right < n;right++){
                twoSum[edgeVal[left]+edgeVal[right]]++;
            }
        }
        int[] lastfix = new int[maxVal];
        lastfix[maxVal-1] = 1;
        for (int i = maxVal-2; i >=0; i--) {
            lastfix[i] = lastfix[i+1]+twoSum[i+1];
        }


        int[] ret = new int[queries.length];


        for (int i = 0; i < queries.length; i++) {
            int limit = queries[i];
            if(limit>=maxVal) ret[i] = 0;
            else ret[i] = lastfix[limit];
        }
        return ret;
    }
}
