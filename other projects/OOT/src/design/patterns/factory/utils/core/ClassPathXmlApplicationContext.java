package design.patterns.factory.utils.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import design.patterns.factory.utils.Bean;
import design.patterns.factory.utils.BeanUtils;
import design.patterns.factory.utils.ConfigManager;
import design.patterns.factory.utils.Property;


public class ClassPathXmlApplicationContext implements BeanFactory {

	private Map<String, Bean> config;
	
	//使用map来做spring的容器(放置管理对象)
	private Map<String, Object> context = new HashMap<>();
	//类一创建就初始化容器
	public ClassPathXmlApplicationContext(String path) {
		
		//1.读取配置文件获得需要初始化的Bean信息
		config = ConfigManager.getConfig(path);
		//2.遍历配置 初始化Bean
		if (config!=null) {
			for (Entry<String,Bean> entry : config.entrySet()) {
				//获得Bean信息
				String beanName = entry.getKey();
				Bean bean = entry.getValue();
				
				//---------由于 属性注入其他Bean时 可能调用createBean放置对象到context中 
				//故   初始化放入前(只有Bean不存在且其scope属性为singleton才放入)  需判断是否存在
				Object existBean = context.get(beanName);
				if (existBean==null && bean.getScope().equals("singleton")) {
					
					//根据Bean配置 创建Bean对象
					Object beanObj = createBean(bean);
					//3.将初始化号的Bean放入容器中
					context.put(beanName, beanObj);
					
				}
			}
		}
	}
	
	/*
	 * Bean配置
	 * <bean name="" class="">
	 * <property name="" value=""></property>
	 * <property name="" ref=""></property>
	 * </bean>
	 */
	
	private Object createBean(Bean bean) {
		//1.获得Bean的class
		String className = bean.getClassName();
		Class clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("请检查Bean的class配置是否正确!:"+className);
		}
		//创建class对应的对象
		Object beanObj = null;
		try {
			beanObj = clazz.newInstance();//调用空参构造
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException("Bean没有空参构造方法!:"+className);
		}
		//2.获得Bean的属性 将其注入
		if (bean.getProperties()!=null) {
			for (Property prop : bean.getProperties()) {
				//获得要注入的属性名
				String propName = prop.getName();
				//根据属性名称获得注入属性对应的set方法
				Method setMethod = BeanUtils.getWriteMethod(beanObj, propName);
				//创建需要注入到Bean中的属性
				Object param = null; 
				
				
				//1>value属性注入
				if (prop.getValue()!=null) {
					//获得要注入的属性值
					String value = prop.getValue();
					param = value;
				}
				//2>其他Bean的注入
				if (prop.getRef()!=null) {
					//检查要注入的Bean是否创建
					Object existBean = context.get(prop.getRef());
					if (existBean == null) {
						//若不存在 则创建
						existBean =  createBean(config.get(prop.getRef()));
						//放入容器中(scope属性为singleton才放入)
						if (config.get(prop.getRef()).getScope().equals("singleton")) {
							context.put(prop.getRef(), existBean);
						}
					}
					param = existBean;
				}
				
				//调用set方法注入属性
				try {
					setMethod.invoke(beanObj, param);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
					throw new RuntimeException("属性:"+propName+"没有对应的set方法或方法参数不正确:"+className);
				}
			}
		}
		
		return beanObj;
	}


	@Override
	//根据Bean名称获得Bean实例
	public Object getBean(String beanName) {
		Object bean = context.get(beanName);
		//若Bean的scope配置为prototype, context中就不包含该Bean对象 ,需要创建该对象
		if (bean==null) {
			bean = createBean(config.get(beanName));
		}
		return bean;
	}

	
}
