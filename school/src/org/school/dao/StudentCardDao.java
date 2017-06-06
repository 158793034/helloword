package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entity.Studentcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class StudentCardDao  extends BaseDao<Studentcard>{
@Autowired
	public StudentCardDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO 自动生成的构造函数存根
	}

}
