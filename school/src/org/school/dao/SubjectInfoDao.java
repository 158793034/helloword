package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entity.Subjectinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class SubjectInfoDao extends BaseDao<Subjectinfo> {
@Autowired
	public SubjectInfoDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO 自动生成的构造函数存根
	}

}
