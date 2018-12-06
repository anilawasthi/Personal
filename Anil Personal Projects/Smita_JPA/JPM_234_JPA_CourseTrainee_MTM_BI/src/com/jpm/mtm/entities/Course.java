package com.jpm.mtm.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="COURSES_MTM")
public class Course {
	
	@Id
	@Column(name="course_id")
	private Long courseId;
	
	@Column(name="course_name")
	private String courseName;

	@ManyToMany(cascade=CascadeType.ALL)
//Step 2: Join table
		@JoinTable(name="COURSES_MTM", 
//Step 3: joinColumns
		joinColumns= {@JoinColumn(name="COURSE_ID")}, 
//Step 4: inverseJoinColumns
		inverseJoinColumns={@JoinColumn(name="TRAINEE_ID")})
	
	private Set<Trainee> trainee = new HashSet<>();

	public Course() {
		
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<Trainee> getTrainee() {
		return trainee;
	}

	public void setTrainee(Set<Trainee> trainee) {
		this.trainee = trainee;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", trainee=" + trainee + "]";
	}
	
	



	

	
	
	
}
