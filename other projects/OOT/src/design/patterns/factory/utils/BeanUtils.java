package design.patterns.factory.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
/*
 * 根据属性名称获得注入属性对应的set方法
 */
public class BeanUtils {

	//beanObj:bean对象 propName:属性名
	public static Method getWriteMethod(Object beanObj, String propName) {

		Method method = null;
		//使用内省技术
		//1.分析beanObj得到BeanInfo
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(beanObj.getClass());
			//2.根据BeanInfo获得所有属性的描述器
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			//3.遍历属性描述器  找到对应属性  返回找到的set方法
			if (pds!=null) {
				for (PropertyDescriptor pd : pds) {
					//获得属性名称
					String pName = pd.getName();
					//返回写入属性的set方法
					if (pName.equals(propName)) {
						method = pd.getWriteMethod();
					}
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		if (method==null) {
			throw new RuntimeException("请检查属性"+propName+"的set方法是否创建！");
		}
		
		
		
		
		return method;
	}

}
