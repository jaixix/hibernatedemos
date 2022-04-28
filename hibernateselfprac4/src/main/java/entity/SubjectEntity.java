package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subjects")
public class SubjectEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID")
	private int id;
	
//	@Column(name="Subject Name")
	private String name;
	
//	@Column(name="Grade Points")
	private int gradePoints;

	public SubjectEntity() {}
	
	public SubjectEntity(String name, int gradePoints) {
		this.name = name;
		this.gradePoints = gradePoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGradePoints() {
		return gradePoints;
	}

	public void setGradePoints(int gradePoints) {
		this.gradePoints = gradePoints;
	}

}
