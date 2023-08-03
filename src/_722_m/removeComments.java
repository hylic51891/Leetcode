package _722_m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: _722_m._722_m
 * Package: PACKAGE_NAME
 *
 * @description
 * @Author hylic_desktop
 * @Create 2023/8/3 10:57
 * @Version 1.0
 */
public class removeComments {
    public static void main(String[] args) {
        System.out.println(new removeComments().removeComments2(new String[]{"a/*comment", "line", "more_comment*/b"}));
        System.out.println(new removeComments().removeComments2(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
        System.out.println(new removeComments().removeComments2(new String[]{"class test{", "public: ", "   int x = 1;", "   /*double y = 1;*/", "   char c;", "};"}));
    }

    // 用index找不可靠，一行中出现多次注释难以解决，如“/* dfadfa*/2323//77777”
    public List<String> removeComments(String[] source) {
        final String multiStart = "/*";
        final String multiEnd = "*/";
        final String singleComment = "//";
        List<String> result = new ArrayList<>();
        int m_index1 = 0,m_index2 = 0,s_index = 0;
        boolean commentMod = false;
        StringBuilder multiString = new StringBuilder();
//        char[] multi1 = new char[0];
//        char[] multi2;
        for(String line: source){
            if(!commentMod){
                m_index1 = line.indexOf(multiStart);
                s_index = line.indexOf(singleComment);

                if(m_index1!= -1){
                    if(s_index!= -1){
                        if(m_index1 < s_index){  // 多行注释开始
                            commentMod = true;
//                            multi1 = line.substring(0,m_index1).toCharArray();
                            multiString.append(line, 0, m_index1);
                        }
                        else{   // 单行注释
                            result.add(line.substring(0,s_index));
                        }
                    }
                    else{
                        commentMod = true;
//                        multi1 = line.substring(0,m_index1).toCharArray();
                        multiString.append(line, 0, m_index1);
                    }
                }
                else{
                    if(s_index!= -1){
                        result.add(line.substring(0,s_index));
                    }
                    else{   // 没有注释
                        result.add(line);
                    }
                }

                // 本行进入多行注释
                if(commentMod){
                    m_index2 = line.indexOf(multiEnd,m_index1+1);
                    if(m_index2!= -1){  // 本行结束multiComment
                        commentMod = false;
                        if(m_index2+2<=line.length()-1){
                            multiString.append(line.substring(m_index2+2));
//                        multi2 = line.substring(m_index2+2).toCharArray();

                        }
                        result.add(multiString.toString());
                        multiString.delete(0,multiString.length());   // 清空
                    }
                }

            }
            else{
                m_index2 = line.indexOf(multiEnd);
                if(m_index2!= -1){  // 本行结束multiComment
                    commentMod = false;
                    if(m_index2+2<=line.length()-1){
                        multiString.append(line.substring(m_index2+2));
//                        multi2 = line.substring(m_index2+2).toCharArray();

                    }
                    result.add(multiString.toString());
                    multiString.delete(0,multiString.length());   // 清空
                }
            }
        }
        result.removeIf((s)->{return s.length()==0;});
        return result;
    }
    // 需要遍历每一行的每个字符
    public List<String> removeComments2(String[] source){
        final String multiStart = "/*";
        final String multiEnd = "*/";
        final String singleComment = "//";
        List<String> result = new ArrayList<>();
        int index = 0,m_index1 = 0,m_index2 = 0,s_index = 0;
        boolean block = false;
        StringBuilder multiString = new StringBuilder();

        for(String line: source){
            index = 0;
            m_index1 = 0;
            m_index2 = 0;
            s_index = 0;
            while(true){
                if(!block){
                    m_index1 = line.indexOf(multiStart,index);
                    s_index = line.indexOf(singleComment,index);
                    if(m_index1!= -1){   // 有多行注释
                        if(s_index!= -1 && s_index < m_index1){  // 有单行且单行在前
                            multiString.append(line,index, s_index);
                            break;
                        }
                        else{  //只有多行
                            block = true;
                            multiString.append(line,index, m_index1);
                            index = m_index1+2;
                        }
                    }
                    else{   // 无多行注释
                        if(s_index!= -1){   // 有单行注释
                            multiString.append(line, index, s_index);
                            break;
                        }
                        else{   //一行到最后全都有效
                            multiString.append(line.substring(index));
                            break;
                        }
                    }
                }
                else{
                    m_index2 = line.indexOf(multiEnd,index);
                    if(m_index2!= -1){
                        block = false;
                        index = m_index2+2;
                    }
                    else{
                        break;
                    }
                }
                if(index > line.length()-1) break;
            }

            if(!block){ // 结束遍历，并且不在block中
                result.add(multiString.toString());
                multiString = new StringBuilder();
            }
        }
        result.removeIf((s)->{return s.length()==0;});
        return result;
    }
}
