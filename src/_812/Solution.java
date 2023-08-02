package _812;

/**
 * ClassName: Solution
 * Package: _812
 * Description:
 *
 * @Author hylic
 * @Create 2023/6/12 21:43
 * @Version 1.0
 */
public class Solution {
    public double largestTriangleArea(int[][] points) {
        // 找外接矩形
        int xmin =  50;
        int ymin =  50;
        int xmax = -50;
        int ymax = -50;
        for(int i = 0; i< points.length; i++){
            if (xmin > points[i][0]){
                xmin = points[i][0];
            }
            else if(xmax < points[i][0])
                xmax = points[i][0];

            if (ymin > points[i][1]){
                ymin = points[i][1];
            }
            else if(ymax < points[i][1])
                ymax = points[i][1];
        }

        // 找最接近的三角形
        return 0.0;
    }
}
