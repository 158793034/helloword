package org.school.dao;

import org.hibernate.SessionFactory;
import org.school.hb.entity.Userloginfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserLogInfoDao extends BaseDao<Userloginfo> {
@Autowired
	public UserLogInfoDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO 自动生成的构造函数存根
	}

}
