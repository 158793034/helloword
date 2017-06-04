package org.sshtest.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.sshtest.entity.Teacher;
import org.sshtest.interfaces.DAO;
@Repository
public class TeacherDao implements DAO {
	public List<Teacher>getAll(){
		List<Teacher>al=new ArrayList<>();
		Collections.addAll(al, new Teacher(1,"©ввс",30),new Teacher(2,"цовс",31),new Teacher(3,"в╞вс",32));
		return al;
	}
}
