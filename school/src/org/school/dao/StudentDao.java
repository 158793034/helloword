package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class StudentDao extends BaseDao<Student> {
	@Autowired
	public StudentDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		
	}

}
