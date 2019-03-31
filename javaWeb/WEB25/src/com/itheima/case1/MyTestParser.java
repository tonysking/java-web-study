package com.itheima.case1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestParser {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		
		//获得TestDemo
		Class clazz = TestDemo.class;
		//获得方法
		Method[] methods = clazz.getMethods();
		if (methods!=null) {
			//获得注解使用了@MyTest的方法
			for (Method method : methods) {
				boolean annotationPresent = method.isAnnotationPresent(MyTest.class);
				if (annotationPresent) {
					//该方法使用了@MyTest  则执行
					method.invoke(clazz.newInstance(), null);
				}
			}
			
		}
		
	}
}
