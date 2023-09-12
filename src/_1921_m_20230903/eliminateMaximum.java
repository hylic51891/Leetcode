package _1921_m_20230903;

import java.util.Arrays;

/**
 * ClassName: eliminateMaximum
 * Package: _1921_m_20230903
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/9/3 10:42
 * @Version 1.0
 */
public class eliminateMaximum {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] step = new int[n];
        for(int i = 0;i<n;i++){
            step[i] = dist[i]/speed[i] +((dist[i]%speed[i]==0)?0:1);
        }
        Arrays.sort(step);
        int minute = 0;
        for (int i = 0; i < n; i++) {
            if(step[i] <= minute) break;
            minute++;
        }
        return minute;
    }
}
