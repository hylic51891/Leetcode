/**
 * ClassName: ways
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/17 15:42
 * @Version 1.0
 */
public class ways {
    /**
     我的思路：
     如果每一列和每一行都保证至少有一个苹果，则横竖的所有位置都可选
     但是切在空行的选择无法统计
     */
//    public int ways(String[] pizza, int k) {
//        int row = pizza.length;
//        if(row==0) return 0;
//        int column = pizza[0].length();
//        if(column==0) return 0;
//        boolean[] columnMark = new boolean[column];
//        boolean[] rowMark = new boolean[column];
//
//        for (int i = 0; i < row; i++) {
//            boolean hasApple = false;
//            for (int j = 0; j < column; j++) {
//                if(pizza[i].charAt(j)=='A'){
//                    if(!hasApple) hasApple =true;
//                    if(!columnMark[j]) columnMark[j] = true;
//                }
//            }
//            if(hasApple) rowMark[i] = true;
//        }
//
//        return 0;
//    }
}
