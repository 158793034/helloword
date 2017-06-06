package org.school.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.school.hb.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao extends BaseDao<Teacher> {
	
	@Autowired
	public TeacherDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		
	}
	
	
}
