package config.parse;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import config.Bean;
import config.Property;

public class ConfigManager {

	//读取 配置文件 并返回 读取结果
	public static Map<String, Bean> getConfig(String Path){
		//返回的map对象 <Bean元素名字，Bean元素对象>
		Map<String, Bean> map = new HashMap<>();
		
		//dom4j
		//1.创建解析器
		SAXReader reader = new SAXReader();
		//2.加载配置文件
		InputStream is = ConfigManager.class.getResourceAsStream(Path);
		Document doc = null;
		try {
			doc = reader.read(is);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException("检察xml配置是否正确！");
		}
		//3.定义xpath表达式，取出所有Bean元素
		String xpath = "//bean";
		//4.对Bean元素进行遍历
		List<Element> beanList = doc.selectNodes(xpath);
		if (beanList!=null) {
			for (Element beanEle : beanList) {
				Bean bean = new Bean();
				//将Bean元素的name/class/scope属性封装到Bean对象中
				String name = beanEle.attributeValue("name");
				String className= beanEle.attributeValue("class");
				String scope = beanEle.attributeValue("scope");
				
				bean.setName(name);
				bean.setClassName(className);
				if (scope!=null) {//Bean对象配置中默认scope = singleton
					bean.setScope(scope);
				}
				
				//获得Bean元素下的所有Property子元素,将属性name/value/ref封装到Property对象中
				List<Element> propertyList = beanEle.elements("property");
				if (propertyList!=null) {
					for (Element propEle : propertyList) {
						Property property = new Property();
						String pName = propEle.attributeValue("name");
						String pValue = propEle.attributeValue("value");
						String pRef = propEle.attributeValue("ref");
						
						property.setName(pName);
						property.setValue(pValue);
						property.setRef(pRef);
						
						//将Property对象封装到Bean对象
						bean.getProperties().add(property);
					}
				}
				//将Bean对象封装到Map中(用于返回)
				map.put(name, bean);
			}
		}
		
		//5.返回Map
		return map;
	}
}
