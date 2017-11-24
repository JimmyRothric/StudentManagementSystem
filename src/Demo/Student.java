package Demo;

public class Student {
	private String id;
	private String name;
	private String gender;
	private int age;
	private String dept;
	
	public Student() {}
	public void printDetails() {
		System.out.println(id + "-" + name + "-" + gender + "-" + age + "-" + dept);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
