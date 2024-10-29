import java.util.*;

class Student{
	private String name;
	private String email;
	private int id;
	private String pass;
	private int grade;
	private static int studentCount;
 	private static ArrayList<Student> listofstudents = new ArrayList<Student>();

	public Student(String name, String email, int grade, int id){
		this.name = name;
		this.name = email;
		this.grade = grade;
		this.id = id;
		studentCount++;
		listofstudents.add(this);
	}

  // getter
	public ArrayList<Student> getStudentList(){
		return this.listofstudents;
	}

	public String toString(){
		return name + " " + email + " " + id + " " + grade;
	}

}



