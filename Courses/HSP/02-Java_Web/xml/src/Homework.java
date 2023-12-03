import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class Homework {
    public static void main(String[] args) throws DocumentException {

        //1.得到解析器
        SAXReader saxReader = new SAXReader();
        //2.指定解析哪个xml文件
        Document document = saxReader.read(new File("src/books.xml"));

        //3.遍历所有的book元素
        List<Element> books = document.getRootElement().elements("book");
        for (Element book : books) {
            //取出book元素的所有信息
            Element name = book.element("name");
            Element author = book.element("author");
            Element price = book.element("price");
            String id = book.attributeValue("id");
            //创建成Book对象
            Book book1 = new Book();
            book1.setId(Integer.parseInt(id));
            book1.setName(name.getText());
            book1.setPrice(Double.parseDouble(price.getText()));
            book1.setAuthor(author.getText());
            System.out.println("book1对象信息= " + book1);
        }
    }
}
