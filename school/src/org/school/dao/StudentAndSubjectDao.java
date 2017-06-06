package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entity.Studentandsubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class StudentAndSubjectDao extends BaseDao<Studentandsubject> {
@Autowired
	public StudentAndSubjectDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO 自动生成的构造函数存根
	}

}
