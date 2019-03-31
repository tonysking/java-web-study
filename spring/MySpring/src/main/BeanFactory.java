package main;

public interface BeanFactory {

	//根据Bean的name获得Bean对象方法
	Object getBean(String beanName);
}
