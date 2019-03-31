package Test;

import org.junit.Test;

import bean.A;
import bean.B;
import main.BeanFactory;
import main.ClassPathXmlApplicationContext;

public class ContextTest {

	@Test
	public void testContext() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("/applicationContext.xml");
		A a = (A) beanFactory.getBean("A");
		System.out.println(a.getName());//Tom
		
		B b = (B) beanFactory.getBean("B");
		System.out.println(b.getA().getName());
	}
	@Test
	public void testSingleton() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("/applicationContext.xml");
		B b = (B) beanFactory.getBean("B");//A默认singleton B prototype
		B b2 = (B) beanFactory.getBean("B");
		B b3 = (B) beanFactory.getBean("B");
		System.out.println(b.getA().getName());//A B B B tom
	}
}
