import java.util.List;

/**
 * Created by taoxu on 2017/5/9.
 */
public class Test_Dom4j {
    public static void main(String[] args) {
        Dom4j dom4j = new Dom4j();
        List<String> ele = dom4j.getelement("src/main/java/shuju.xml");
        for (int i=0;i<ele.size();i++){
            System.out.println(ele.get(i));
        }
    }
}
