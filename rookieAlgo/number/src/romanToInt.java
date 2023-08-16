/**
 * ClassName: romanToInt
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/9 16:14
 * @Version 1.0
 */
public class romanToInt {
    /**
     * 暴力写法
     * @param s
     * @return
     */

    public int romanToInt(String s) {
        char c,n;
        int index = 0;
        char[] roman = new char[s.length()+1];
        System.arraycopy(s.toCharArray(),0,roman,0,s.length());
        roman[s.length()] = ' ';
        int accum = 0;
        while(index < s.length()) {
            c = roman[index];
            n = roman[index+1];
            switch (c){
                case 'I':{
                    if(n == 'V'){
                        accum+=4;
                        index+=2;
                    }
                    else if (n == 'X'){
                        accum+=9;
                        index+=2;
                    }
                    else{
                        accum+=1;
                        index++;
                    }
                    break;
                }
                case 'V':{
                    accum+=5;
                    break;
                }
                case 'X':{
                    if(n == 'L'){
                        accum+=40;
                        index+=2;
                    }
                    else if (n == 'C'){
                        accum+=90;
                        index+=2;
                    }
                    else{
                        accum+=10;
                        index++;
                    }
                    break;
                }
                case 'L':{
                    accum+=50;
                    break;
                }
                case 'C':{
                    if(n == 'D'){
                        accum+=400;
                        index+=2;
                    }
                    else if (n == 'M'){
                        accum+=900;
                        index+=2;
                    }
                    else{
                        accum+=100;
                        index++;
                    }
                    break;
                }
                case 'D':{
                    accum+=500;
                    break;
                }
                case 'M':{
                    accum+=1000;
                    break;
                }
            }
        }
        return accum;
    }

    /**
     * 用函数或者hashmap映射，如果cur大于save，就减去save，否则加上save
     * 最后再加一次save（最后一个数一定为正）
     * @param s
     * @return
     */
    public int romanToInt2(String s){
        int index = 0;
        int accum = 0;
        int save = 0;
        int cur;
        while(index < s.length()) {
            cur = map(s.charAt(index));
            if(save < cur) accum-=save;
            else accum +=save;
            save = cur;
            index++;
        }
        return accum+save;
    }

    public static int map(char c){
        switch (c){
            case 'I':{
                return 1;
            }
            case 'V':{
                return 5;
            }
            case 'X':{
                return 10;
            }
            case 'L':{
                return 50;
            }
            case 'C':{
                return 100;
            }
            case 'D':{
                return 500;
            }
            case 'M':{
                return 1000;
            }
        }
        return 0;
    }
}
