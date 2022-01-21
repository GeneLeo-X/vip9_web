package day03;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * DOM4J解析
 */
public class Example1 {

    public static void main(String[] args) {

        try {
            SAXReader sr = new SAXReader();
            //获取文档流对象
            Document document = sr.read("src/demo.xml");
            //根据文档流对象获取根元素
            Element rootElement = document.getRootElement();
            System.out.println("根元素名称: " + rootElement.getName() + " - 根元素内容: " + rootElement.getText());

            //根据根元素获取所有其下面的子元素
            List<Element> elements = rootElement.elements();
            for(Element el : elements){
                System.out.println("子元素属性值: " + el.attributeValue("id"));
                if(el.attributeValue("id").equals("1")){//获取到了第一个人的元素了
                    List<Element> secElements = el.elements();

                    for(Element sel : secElements){
                        if(sel.getName().equals("name")) System.out.println("姓名为:" + sel.getText());
                        if(sel.getName().equals("sex")) System.out.println("性别为：" + sel.getText());
                    }
                }
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
