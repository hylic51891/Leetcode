import java.util.*;

/**
 * ClassName: MinStack
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/8 17:12
 * @Version 1.0
 */
public class MinStack {
    /**
     1. 辅助栈：每一个元素对应一个最小值，每次getMin只需要对辅助栈进行peek
        同步栈：出栈的时候同步pop
        非同步栈：每次进来的数<最小值，则放入最小值栈，出栈的时候如果元素=最小栈栈顶，则最小栈栈顶pop

     2. 不用额外空间怎么做？用与最小值的差值代表这个数
          初始状态：
              第一个入栈的数 = 0，最小值=第一个入栈值
          入栈:
              小于最小值，则入栈diff = num-min  min = num
              大于最小值，入栈diff = num - min;
          出栈：
              diff< 0 min出现变化则输出min min = min-diff
              diff>= 0 输出min+diff

     */
    long min;
    Deque<Long> stack;
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            min = val;
            stack.push(val-min);
        }
        else{
            stack.push(val-min);
            if(val < min){
                min = val;
            }
        }
    }

    public void pop() {
        long pop = stack.pop();
        if(pop < 0) min = min-pop;
    }

    public int top() {
        long top = stack.peek();
        if(top<0) return (int)min;
        else return (int)(top+min);
    }

    public int getMin() {
        return (int)min;
    }

}
