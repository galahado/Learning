import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class Dom4j_ {

    /**
     * 演示如何加载xml文件
     */
    @Test
    public void loadXML() throws DocumentException {
        //得到一个解析器
        SAXReader reader = new SAXReader();
        //老师的代码技巧->debug 看看document对象的属性
        //分析了document对象的底层结构
        Document document = reader.read(new File("src/students.xml"));
        System.out.println(document);

    }

    /**
     * 遍历所有的student信息
     */
    @Test
    public void listStus() throws DocumentException {
        //得到一个解析器
        SAXReader reader = new SAXReader();
        //老师的代码技巧->debug 看看document对象的属性
        //分析了document对象的底层结构
        Document document = reader.read(new File("src/students.xml"));

        //1. 得到rootElement, 你是OOP
        Element rootElement = document.getRootElement();
        //2. 得到rootElement的student Elements
        List<Element> students = rootElement.elements("student");
        //System.out.println(student.size());//2
        for (Element student : students) {//element就是Student元素/节点
            //获取Student元素 的name Element
            Element name = student.element("name");
            Element age = student.element("age");
            Element resume = student.element("resume");
            Element gender = student.element("gender");

            System.out.println("学生信息= " + name.getText() + " " + age.getText() +
                    " " + resume.getText() + " " + gender.getText());
        }

    }

    /**
     * 指定读取第一个学生的信息 就是 dom4j+xpath
     */
    @Test
    public void readOne() throws DocumentException {

        //得到一个解析器
        SAXReader reader = new SAXReader();
        //老师的代码技巧->debug 看看document对象的属性
        //分析了document对象的底层结构
        Document document = reader.read(new File("src/students.xml"));

        //1. 得到rootElement, 你是OOP
        Element rootElement = document.getRootElement();

        //2. 获取第一个学生
        Element student = (Element) rootElement.elements("student").get(1);
        //3. 输出该信息
        System.out.println("该学生的信息= " + student.element("name").getText() + " " +
                student.element("age").getText() + " " + student.element("resume").getText() +
                student.element("gender").getText());

        //4. 获取student元素的属性
        System.out.println("id= " + student.attributeValue("id"));
    }

    /**
     * 加元素(要求: 添加一个学生到xml中) [不要求，使用少，了解]
     * @throws Exception
     */
    @Test
    public void add() throws Exception {

        //1.得到解析器
        SAXReader saxReader = new SAXReader();
        //2.指定解析哪个xml文件
        Document document = saxReader.read(new File("src/students.xml"));


        //首先我们来创建一个学生节点对象
        Element newStu = DocumentHelper.createElement("student");
        Element newStu_name = DocumentHelper.createElement("name");
        //如何给元素添加属性
        newStu.addAttribute("id", "04");
        newStu_name.setText("宋江");
        //创建age元素
        Element newStu_age = DocumentHelper.createElement("age");
        newStu_age.setText("23");
        //创建resume元素
        Element newStu_intro = DocumentHelper.createElement("resume");
        newStu_intro.setText("梁山老大");

        //把三个子元素（节点）加到 newStu下
        newStu.add(newStu_name);
        newStu.add(newStu_age);
        newStu.add(newStu_intro);
        //再把newStu节点加到根元素
        document.getRootElement().add(newStu);
        //直接输出会出现中文乱码:
        OutputFormat output = OutputFormat.createPrettyPrint();
        output.setEncoding("utf-8");//输出的编码utf-8

        //把我们的xml文件更新
        // lets write to a file
        //new FileOutputStream(new File("src/myClass.xml"))
        //使用到io编程 FileOutputStream 就是文件字节输出流
        XMLWriter writer = new XMLWriter(
                new FileOutputStream(new File("src/students.xml")), output);
        writer.write(document);
        writer.close();

    }

    /**
     * //删除元素(要求：删除第一个学生) 使用少，了解
     * @throws Exception
     */
    @Test
    public void del() throws Exception {
        //1.得到解析器
        SAXReader saxReader = new SAXReader();
        //2.指定解析哪个xml文件
        Document document = saxReader.read(new File("src/students.xml"));
        //找到该元素第一个学生
        Element stu = (Element) document.getRootElement().elements("student").get(2);
        //删除元素
        stu.getParent().remove(stu);
//        //删除元素的某个属性
//        stu.remove(stu.attribute("id"));
        //更新xml
        //直接输出会出现中文乱码:
        OutputFormat output = OutputFormat.createPrettyPrint();
        output.setEncoding("utf-8");//输出的编码utf-8
        //把我们的xml文件更新
        XMLWriter writer = new XMLWriter(
                new FileOutputStream(new File("src/students.xml")), output);
        writer.write(document);
        writer.close();
        System.out.println("删除成功~");
    }


    /**
     * //更新元素(要求把所有学生的年龄+3) 使用少，了解
     * @throws Exception
     */
    @Test
    public void update() throws Exception {

        //1.得到解析器
        SAXReader saxReader = new SAXReader();
        //2.指定解析哪个xml文件
        Document document = saxReader.read(new File("src/students.xml"));
        //得到所有学生的年龄
        List<Element> students = document.getRootElement().elements("student");
        //遍历, 所有的学生元素的age+3
        for (Element student : students) {
            //取出年龄
            Element age = student.element("age");
            age.setText((Integer.parseInt(age.getText()) + 3) + "");
        }

        //更新
        //直接输出会出现中文乱码:
        OutputFormat output = OutputFormat.createPrettyPrint();
        output.setEncoding("utf-8");//输出的编码utf-8

        //把我们的xml文件更新
        XMLWriter writer = new XMLWriter(
                new FileOutputStream(new File("src/students.xml")), output);
        writer.write(document);
        writer.close();
        System.out.println("更新成功~");
    }
}
