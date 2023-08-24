package _1_hash;

import java.util.*;

/**
 * ClassName: groupAnagrams
 * Package: _1_hash
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/22 15:57
 * @Version 1.0
 */
public class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] cur = strs[i].toCharArray();
            Arrays.sort(cur);
            Integer index = map.get(String.valueOf(cur));
            if(index!=null){
                ret.get(index).add(strs[i]);
            }
            else{
                List<String> add = new ArrayList<>();
                add.add(strs[i]);
                ret.add(add);
                map.put(String.valueOf(cur),ret.size()-1);
            }
        }
        return ret;
    }

}
