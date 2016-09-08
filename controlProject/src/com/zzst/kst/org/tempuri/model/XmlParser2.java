package com.zzst.kst.org.tempuri.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;

/**
 * Java递归遍历XML所有元素
 * 
 * @author  Administrator
 * @version  [版本号, Apr 13, 2010]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class XmlParser2
{
    // private static Map xmlmap = new HashMap(); 
    //存储xml元素信息的容器 
    private static ArrayList<Leaf> elemList = new ArrayList<Leaf>();
    
    public static void main(String args[])
        throws DocumentException
    {
        XmlParser2 test = new XmlParser2();
        String path = "d:/a.xml";
        // 读取XML文件
        SAXReader reader = new SAXReader();
        Document doc = reader.read(path);
        // 获取XML根元素
        Element root = doc.getRootElement();
        test.getElementList(root);
        String x = test.getListString(elemList);
        System.out.println("-----------解析结果------------\n" + x);
    }
    
    /** 
     * 获取节点所有属性值
     * <功能详细描述>
     * @param element
     * @return
     * @see [类、类#方法、类#成员]
     */
    public String getNoteAttribute(Element element)
    {
        String xattribute = "";
        DefaultAttribute e = null;
        List list = element.attributes();
        for (int i = 0; i < list.size(); i++)
        {
            e = (DefaultAttribute)list.get(i);
            //System.out.println("name = " + e.getName() + ", value = " + e.getText());
            xattribute += " [name = " + e.getName() + ", value = " + e.getText() + "]";
        }
        return xattribute;
    }
    
    /** 
     * 递归遍历方法 
     * <功能详细描述>
     * @param element
     * @see [类、类#方法、类#成员]
     */
    public void getElementList(Element element)
    {
        List elements = element.elements();
        // 没有子元素 
        if (elements.isEmpty())
        {
            String xpath = element.getPath();
            String value = element.getTextTrim();
            elemList.add(new Leaf(getNoteAttribute(element), xpath, value));
        }
        else
        {
            // 有子元素
            Iterator it = elements.iterator();
            while (it.hasNext())
            {
                Element elem = (Element)it.next();
                // 递归遍历 
                getElementList(elem);
            }
        }
    }
    
    public String getListString(List elemList)
    {
        StringBuffer sb = new StringBuffer();
        for (Iterator it = elemList.iterator(); it.hasNext();)
        {
            Leaf leaf = (Leaf)it.next();
            sb.append("xpath: " + leaf.getXpath()).append(", value: ").append(leaf.getValue());
            if (!"".equals(leaf.getXattribute()))
            {
                sb.append(", Attribute: ").append(leaf.getXattribute());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

/** 
* xml节点数据结构 
*/
class Leaf
{
    // 节点属性
    private String xattribute;
    
    // 节点PATH
    private String xpath;
    
    // 节点值
    private String value;
    
    public Leaf(String xattribute, String xpath, String value)
    {
        this.xattribute = xattribute;
        this.xpath = xpath;
        this.value = value;
    }
    
    public String getXpath()
    {
        return xpath;
    }
    
    public void setXpath(String xpath)
    {
        this.xpath = xpath;
    }
    
    public String getValue()
    {
        return value;
    }
    
    public void setValue(String value)
    {
        this.value = value;
    }
    
    public String getXattribute()
    {
        return xattribute;
    }
    
    public void setXattribute(String xattribute)
    {
        this.xattribute = xattribute;
    }
}
