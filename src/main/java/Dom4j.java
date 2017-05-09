import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public class Dom4j {
    public List<String> getelement(String file){
        Iterator<Element> elements;
        Element element = null;
        List<String> ele = new ArrayList<String>();
        try{
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document document = reader.read(new File(file));
        //获取根节点元素对象
        Element node = document.getRootElement();
        //获得一个element列表迭代器
        elements = node.elements("element").iterator();
        while (elements.hasNext()){
            element = elements.next();
            Attribute attr = element.attribute("name");
            Element locator =element.element("locator");
            Attribute attr1 = locator.attribute("type");
            System.out.println("用处："+attr.getText());
            System.out.println("类型:"+attr1.getText()+"\n"+locator.getText());
            System.out.println("---------------------------------------");
            ele.add(locator.getText());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return ele;
}

}
