package com.jpm.mtm.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="TRAINEE_MTM")
public class Trainee {
	@Id
	@Column(name="trainee_id")
	private Long traineeId;
	
	@Column(name="trainee_name")
	private String traineeName;

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="train")
	
	private Set<Course> course = new HashSet<>();

	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}
	

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", course=" + course + "]";
	}
	
	
}