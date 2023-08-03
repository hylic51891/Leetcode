import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * ClassName: test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author hylic
 * @Create 2023/8/3 21:17
 * @Version 1.0
 */
public class treeMapTest {
    public static void main(String[] args) {
//        Map<Integer,String> map = new TreeMap<>();
        Map<Integer,String> map = new HashMap<>();
        map.put(5,"ew34");
        map.put(66,"7884");
        map.put(44,"8998");
        map.put(2,"sfdtuhg");
        map.put(1,"yysysy");
        for (Map.Entry<Integer,String> entry: map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(" ");
            System.out.println(entry.getValue());
        }
    }
}
