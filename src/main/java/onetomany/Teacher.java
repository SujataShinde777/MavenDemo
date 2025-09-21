package onetomany;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@Column(name = "teacher_id")
	private int teacherId;
	private String name;
	
	@OneToMany
	private List<Student> students;
	
	public Teacher() {
		super();
		
	}

	public Teacher(int teacherId, String name, List<Student> students) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.students = students;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", students=" + students + "]";
	}
	
	
}
