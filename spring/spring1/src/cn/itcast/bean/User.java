package cn.itcast.bean;

public class User {

	private String name;
	private Integer age;
	
	
	
	public User() {
		System.out.println("user对象空参构造方法");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public void init() {
		System.out.println("user初始化方法");
	}
	
	public void destroy() {
		System.out.println("user销毁方法");
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
