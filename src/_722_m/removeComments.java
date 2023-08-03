package _722_m;

import java.util.ArrayList;
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
    public List<String> removeComments(String[] source) {
        final String multiStart = "/*";
        final String multiEnd = "*/";
        final String singleComment = "//";
        List<String> result = new ArrayList<>();
        int m_index1 = 0,m_index2 = 0,s_index = 0;
        boolean commentMod = false;
        for(String line: source){
            if(!commentMod){
                m_index1 = line.indexOf(multiStart);
                s_index = line.indexOf(singleComment);

                if(m_index1!= -1){
                    if(s_index!= -1){
                        if(m_index1 < s_index){  // 多行注释开始
                            commentMod = true;
                        }
                        else{   // 单行注释
                            result.add(line.substring(0,s_index));
                        }
                    }
                    else{
                        commentMod = true;
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

                if(commentMod){
                    m_index2 = line.indexOf(multiEnd);
                    if(m_index2!= -1){
                        commentMod = false;
                        if(m_index2+2<line.length()-1){
                            result.add(line.substring(0,m_index1) + line.substring(m_index2+2));
                        }
                    }
                    else{
                        if(m_index1!=0){
                            result.add(line.substring(0,m_index1));
                        }
                    }
                }
            }
            else{
                m_index2 = line.indexOf(multiEnd);
                if(m_index2!= -1){
                    commentMod = false;
                    if(m_index2+2<line.length()-1){
                        result.add(line.substring(m_index2+2));
                    }
                }

            }
        }

        return result;
    }
}
