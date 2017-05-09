import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public class Dom4j {
    public static void main(String[] args) {
        List<Element> elements = null;
        try{
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document document = reader.read(new File("src/main/java/shuju.xml"));
        //获取根节点元素对象
        Element node = document.getRootElement();
                //因为第一个module标签只有内容没有子节点，直接.iterator()就java.lang.NullPointerException了, 所以需要分开实现
        elements = node.elements("element");
        for (int i=0;i<elements.size();i++){
            Attribute attr = elements.get(i).attribute("name");
            Element element = elements.get(i).element("locator");
            Attribute attr1 = element.attribute("type");
            System.out.println("用处："+attr.getText());
            System.out.println("类型:"+attr1.getText()+"\n"+element.getText());
            System.out.println("---------------------------------------");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
