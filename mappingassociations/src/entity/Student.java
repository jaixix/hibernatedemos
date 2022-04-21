package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="enrollmentId", nullable=false)
	private String enrollmentId;
	
	@Column(name="student_name", nullable=false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="guide_id")
	private Guide guide;
	
	public Student() {}

	public Student(String enrollmentId, String name, Guide guide) {
		this.enrollmentId = enrollmentId;
		this.name = name;
		this.guide=guide;
	}
	
	
}
