package spring.mvc.practice.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import spring.mvc.practice.DTO.StudentDto;

@Component
public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yamini");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(StudentDto studentDto) {
		entityTransaction.begin();
		entityManager.persist(studentDto);
		entityTransaction.commit();

	}

	public StudentDto fid(int id) {
		StudentDto studentDto = entityManager.find(StudentDto.class, id);
		if (studentDto != null) {
			return studentDto;
		} else {
			return null;
		}

	}

	public List<StudentDto> fall() {
		Query q = entityManager.createQuery("select a from StudentDto a ");
		List<StudentDto> list = q.getResultList();
		return list;

	}

	public String did(int id) {
		StudentDto studentDto = entityManager.find(StudentDto.class, id);
		if (studentDto != null) {
			entityTransaction.begin();
			entityManager.remove(studentDto);
			entityTransaction.commit();
			return "data deleted";
		} else {
			return "data not found";
		}
	}

	public String dall() {
		Query q = entityManager.createQuery("select a from StudentDto a");
		List<StudentDto> list = q.getResultList();
		if (list.isEmpty()) {
			return "data not found";
		} else {
			for (StudentDto studentDto : list) {
				entityTransaction.begin();
				entityManager.remove(studentDto);
				entityTransaction.commit();
			}
			return "data deleted";
		}
	}

	public String modify(StudentDto studentDto) {
		entityTransaction.begin();
		entityManager.merge(studentDto);
		entityTransaction.commit();
		return "data updated successfully";

	}

}
