package _822_m;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: flipgame
 * Package: _822_m
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/2 23:47
 * @Version 1.0
 */
public class flipgame {
    public int flipgame(int[] fronts, int[] backs) {
        /* 调换两个数组中的对应数字位置，使得背面的数字中的最小值
            1. 如果正反面重复，则这个数不符合要求
            2. 一个hashmap存储所有值，排除1的情况，从小到大依次排查，
         */
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> badSet = new HashSet<Integer>();
        for(int i = 0; i< fronts.length;i++){
            if(fronts[i] == backs[i]){
                badSet.add(fronts[i]);
                set.remove(fronts[i]);
            }
            else{
                if(!badSet.contains(fronts[i])) set.add(fronts[i]);
                if(!badSet.contains(backs[i])) set.add(backs[i]);
            }
        }
        // set.removeAll(badSet);
        if(set.isEmpty()){
            return 0;
        }
        else{
            return Collections.min(set);
        }
    }
    public int flipgame21(int[] fronts, int[] backs) {
        /* 调换两个数组中的对应数字位置，使得背面的数字中的最小值
            1. 如果正反面重复，则这个数不符合要求
            2. 一个hashset存黑名单，一个hashset存符合要求的所有值，取最小值
         */
        HashSet<Integer> badSet = new HashSet<Integer>();
        int min = 2001;
        for(int i = 0; i< fronts.length;i++){
            if(fronts[i] == backs[i]){
                badSet.add(fronts[i]);
            }

        }
        for(int i = 0; i< fronts.length;i++){
            if(!badSet.contains(fronts[i]) && fronts[i]<min) min = fronts[i];
            if(!badSet.contains(backs[i]) && backs[i] < min) min = backs[i];
        }
        // set.removeAll(badSet);
        if(min == 2001){
            return 0;
        }
        return min;
    }
}
