package Demo;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.*;

public class StudentDao extends BaseDao{

	public boolean addStudent(Student s) throws Exception {
		String sql = "insert into Student(id, name, gender, age, dept) values(?, ?, ?, ?, ?)";
		try{
			Connection con = super.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, s.getId());
			stmt.setString(2, s.getName());
			stmt.setString(3, s.getGender());
			stmt.setInt(4, s.getAge());
			stmt.setString(5, s.getDept());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	public boolean delStudent(String id) throws Exception {
		String sql = "delete from Student where id = ?";
		try{
			Connection con = super.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	public Student searchByDept(String dept) throws Exception {
		String sql = "select id, name, gender, age, dept from Student where dept = ?";
		Student stu = new Student();
		try {
			Connection con = super.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dept);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				stu.setId(rs.getString("id"));
				stu.setName(rs.getString("name"));
				stu.setGender(rs.getString("gender"));
				stu.setAge(rs.getInt("age"));
				stu.setDept(rs.getString("dept"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return stu;
	}
	
	public ArrayList<Student> displayAllDetails() throws Exception {
		String sql = "select * from Student";
		ArrayList<Student> stuList = new ArrayList<Student>();
		try {
			Connection con = super.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getString("id"));
				stu.setName(rs.getString("name"));
				stu.setGender(rs.getString("gender"));
				stu.setAge(rs.getInt("age"));
				stu.setDept(rs.getString("dept"));
				stuList.add(stu);
			}
			return stuList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		try {
			ArrayList<Student> stuList = dao.displayAllDetails();
			for (Student s:stuList) {
				s.printDetails();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
/**	
 *addition & deletion 		
 		Student stu = new Student();
		stu.setId("0004");
		stu.setName("Jimmy");
		stu.setGender("M");
		stu.setAge(20);
		stu.setDept("CS");
  		try {
			boolean success = dao.addStudent(stu);
			boolean success0 = dao.delStudent("1000");
			if (success && success0) {
				System.out.println("success");
			} else {
				System.out.println("false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertion error");
		}
*/		
		
/**
 * search by id
		try {
			Student s = dao.searchByDept("CS");
			s.printDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		
		
		
	}
}
