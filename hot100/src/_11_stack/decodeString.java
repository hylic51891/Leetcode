package _11_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: decodeString
 * Package: _11_stack
 * Description:
 *  字符串解码
 * @Author hylic
 * @Create 2023/9/7 11:21
 * @Version 1.0
 */
public class decodeString {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();

        Deque<Integer> stack1 = new LinkedList<>(); // 数字栈
        Deque<StringBuilder> stack2 = new LinkedList<>();   // 字符串栈
        StringBuilder cur = new StringBuilder();    // 用来指向当前字符串
        stack2.add(cur);    // 统一放到字符串栈中

        boolean isDigit = false;    // 标识前一个字符是否是数字
        int num = 0;    // 标识获取到的数字
        for(char c:chars){
            if(c>='0' && c<='9' ){  // 遇到数字
                if(!isDigit){   // 第一个数
                    num = c-'0';
                    isDigit = true;
                }
                else{ // 是连续数字中的后序数字
                    num = num*10+(c-'0');
                }
            }
            else if(c=='['){    // 下一层字符串
                isDigit = false;    // 数字结束
                stack1.push(num);   // 数字栈放入数字
                cur = new StringBuilder();   // cur指向下一层的新字符串
                stack2.push(cur); // 字符串栈中放入新StringBuilder
            }
            else if(c==']'){    // 当前层结束
                StringBuilder temp = stack2.pop();  //当前层字符串
                cur = stack2.peek();    //cur指向上一层记录的字符串
                // 把当前层append到上一层
                int repeat = stack1.pop();
                for(int i = 1;i<=repeat;i++){
                    cur.append(temp);
                }
            }
            else{   // 正常字符
                cur.append(c);
            }
        }
        // 最外面的字符串即为最终结果
        return stack2.pop().toString();
    }
}
