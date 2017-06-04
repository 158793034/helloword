package org.sshtest.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.sshtest.entity.userInfo;
import org.sshtest.interfaces.DAO;
@Service(value="modelservice")
public class ModelService {
	@Resource(name="daoMap")
	private Map<String, DAO> daoMap;

	public Map<String, DAO> getDaoMap() {
		return daoMap;
	}

	public void setDaoMap(Map<String, DAO> daoMap) {
		this.daoMap = daoMap;
	}

	// 通过传递一个key在daoMap中查询想要的方法。
	public List getAll(String key) {
		return this.daoMap.get(key).getAll();
	}

	public userInfo login(userInfo user) {
		if (user.getLogName().equals("tom") && "6666".equals(user.getKeyword()))
			return new userInfo("tom","666",null );
		else
			return null;
	}
}
