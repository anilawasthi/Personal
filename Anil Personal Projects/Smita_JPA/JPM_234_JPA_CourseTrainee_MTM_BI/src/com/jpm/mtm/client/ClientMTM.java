package com.jpm.mtm.client;

import javax.persistence.EntityManager;

import com.jpm.mtm.entities.Course;
import com.jpm.mtm.entities.Trainee;
import com.jpm.mtm.util.JPAUtil;

public class ClientMTM {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.geEntityManager();
		em.getTransaction().begin();
		
		Trainee courseJava = new Trainee();
		courseJava.setTraineeId(101L);
		courseJava.setTraineeName("Mahendra");
		
		
		Trainee courseJava1 = new Trainee();
		courseJava1.setTraineeId(102L);
		courseJava1.setCourse("Smita");
		
		Trainee courseJava2 = new Trainee();
		courseJava2.setTraineeId(103L);
		courseJava2.setCourse("OP");
		
		Trainee coursePython1 = new Trainee();
		coursePython1.setTraineeId(104L);
		coursePython1.setCourse("Chandra");
		
		Trainee trainees5 = new Trainee();
		trainees5.setTraineeId(105L);
		trainees5.setCourse("JAVA");
		trainees5.setTraineeName("Rsahmi");
		
		Trainee trainees6 = new Trainee();
		trainees3.setTraineeId(106L);
		trainees3.setCourse("JAVA");
		trainees3.setTraineeName("OP");
		

	}

}
