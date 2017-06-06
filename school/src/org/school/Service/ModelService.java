package org.school.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.school.hb.entity.Student;
import org.school.hb.entity.Studentandsubject;
import org.school.hb.entity.StudentandsubjectId;
import org.school.hb.entity.Studentcard;
import org.school.hb.entity.Subjectinfo;
import org.school.hb.entity.Userinfo;
import org.school.hb.entity.Userloginfo;
import org.school.interfaces.Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModelService {
	public static final String TERCHER="teacherDao";
	public static final String CLASSINFO="classInfoDao";
	public static final String SUBJECTINFO="subjectInfoDao";
	public static final String STUDENT="studentDao";
	public static final String STUDENTCARD="studentCardDao";
	public static final String STUDENTANDSUBJECT="studentAndSubjectDao";
	public static final String USERINFO="userInfoDao";
	public static final String USERLOGINFO="userLogInfoDao";
	@Resource(name="daoMap")
	private Map<String, Dao> daoMap;

	//为什么要在业务中重复dao的方法，应为很多时候开发人员根本不关注dao的实现，而是针对service来进行编程。service是dao的外部接char人员。
//把dao放入集合操作，主要是因为每一个Dao都包含有相同的增删改查，所以可以提出共性，只用根据相关的key值去对应查询即可。
	//Dao不要暴露在其他的层，
	public Map<String, Dao> getDaoMap() {
		return daoMap;
	}
	public void setDaoMap(Map<String, Dao> daoMap) {
		this.daoMap = daoMap;
	}
	//----------------以下为根据Dao相关实现进行的基础方法封装--------------------
	/**
	 * 获取指定表格所有信息
	 * @param key  指定表格key常量
	 * @return   封装有相关实体类对象的list
	 */
	public List getAll(String key){
		return this.daoMap.get(key).getAll();
	}
	/**
	 * 根据主键编号返回指定信息
	 * @param key 指定表格key常量
	 * @param id 主键编号 
	 * @return  封装有相关数据的实体类对象
	 */
	public Object getInfoById(String key,Serializable id){
		return this.daoMap.get(key).getById(id);
	}
	/**
	 *根据提供的条件做相应查询获取信息的方法，并可以进行分页操作
	 * @param key  指定表格key常量
	 * @param pageNum   指定页面
	 * @param rowCount  指定单页显示信息行数
	 * @param criterions  查询条件
	 * @return
	 */
	public List getInfoByProperties(String key,Integer pageNum,Integer rowCount,Criterion...criterions){
		return this.daoMap.get(key).getInfoesByProperties(pageNum, rowCount, criterions);
	}
	/**
	 *根据提供的条件做相应查询获取信息的方法
	 * @param key  指定表格key常量
	 * @param criterions  查询条件
	 * @return
	 */
	public List getInfoByProperties(String key,Criterion...criterions){
	 return this.daoMap.get(key).getInfoesByProperties( criterions);
	}
	/**
	 * 对指定表格进行批量数据添加的方法
	 * @param key  指定表格key常量
	 * @param objects  根据hibernate规范和业务需要封装有相关数据的实体类对象
	 */
	public void insert_batch(String key,Object...objects){
		this.daoMap.get(key).execute_inset(objects);
	}
	/**
	 * 对指定表格进行批量数据删除的方法
	 * @param key  指定表格key常量
	 * @param objects  根据hibernate规范和业务需要封装有相关数据的实体类对象
	 */
	public void delete_batch(String key,Object...objects){
		this.daoMap.get(key).execute_delete(objects);
	}
	/**
	 * 对指定表格进行批量数据修改的方法
	 * @param key  指定表格key常量
	 * @param objects  根据hibernate规范和业务需要封装有相关数据的实体类对象
	 */
	public void update_batch(String key,Object...objects){
		this.daoMap.get(key).execute_update(objects);	
	}
	/**
	 * 根据每页的行数得到指定表格信息可以分成的页数
	 * @param type  指定表格
	 * @param rowCount  指定每页行数
	 * @return
	 */
	public int getPageCount(String type,int rowCount){
		return this.daoMap.get(type).getPageCountByRowCount(rowCount);
	}
	//----------------以下为根据Dao相关实现进行的业务需要方法--------------------
	/**
	 * 根据分页操作获取指定的相关信息
	 * @param type   指定表格 
	 * @param pageNum   指定页数
	 * @param rowCount  指定每页显示的行数 
	 * @return    查询结果
	 */
	public List getInfoByPageNum(String type,int pageNum,int rowCount){
	  return	this.getInfoByProperties(type, pageNum, rowCount);
	}
	/**
	 * 根据指定学生信息获取其当前选修的课程
	 * @param student  当前的的学生信息（封装有主键编号即可）
	 * @return  学员当前选修的课程
	 */
	public List<Studentandsubject> getSubjectByStudent(Student student){
		//根据传递过来的学生的编号，查询到的学生，和id.student是否一致
		  Criterion c1=  Restrictions.eq("id.student", student);
		 List<Studentandsubject> infoes=  daoMap.get(STUDENTANDSUBJECT).getInfoesByProperties(c1);
		return infoes;
	}
	/**
	 * 根据学生的主键和所选的科目，更新学生的选课信息
	 * @param student
	 * @param subjectinfos
	 * @return
	 */
	public boolean subjectUpdate(Student student,Subjectinfo...subjectinfos){
		
		//根据学生的主键得出他所选修的 课程
		List<Studentandsubject>al=this.getSubjectByStudent(student);
		//把学生的课程删除
			if(al!=null&&al.size()>0)
				daoMap.get(STUDENTANDSUBJECT).execute_delete(al.toArray());
				al.clear();
				if(subjectinfos!=null&&subjectinfos.length>0){
					for(int i=0 ; i<subjectinfos.length;i++){
						
						Studentandsubject bean=new Studentandsubject();
						//把学生的id和他所选的课程的id封装到subject中去
						bean.setId(new StudentandsubjectId(student, subjectinfos[i]));
						  al.add(bean);
						  
					}	
				daoMap.get(STUDENTANDSUBJECT).execute_inset(al.toArray());
				}
			
		return true;
	}
	/**
	 * 根据需要清除学生所有信息的方法
	 * @param students
	 * @return
	 */
  public boolean delete_student_clear(Student...students){
	Dao dao_card=  daoMap.get(STUDENTCARD);
	List<Studentandsubject>list_sas=new ArrayList<>();
	List<Studentcard>list_card=new ArrayList<>();
	for(Student student:students){
	 Studentcard sc=(Studentcard)dao_card.getById(student.getStid());//返回的是一张卡
		list_card.add(sc);
		
	 list_sas.addAll(getSubjectByStudent(student)); //每个人的选修课信息都保存了
	}
	 delete_batch(STUDENTANDSUBJECT,list_sas.toArray());  //删除选课信息
	 delete_batch(STUDENTCARD,list_card.toArray());   //删除
	 delete_batch(STUDENT,students);
	  return true;
  }
  /**
   * 系统登录根据传过来的user，找到对应数据库的user
   * @param userinfo   封装有用户名和密码的用户对象
   * @return  如正确，则返回有此用户全部信息的对象，否则返回空表示查无此人
   */
  public Userinfo login(Userinfo userinfo){
	  //必须满足logname和keyword同时和数据库中的相等，才找出相对应的user
	Criterion c1=  Restrictions.and(Restrictions.eq("logname", userinfo.getLogname()),Restrictions.eq("keyword", userinfo.getKeyword()));
	//查找出来的结果是一个list集合
	List<Userinfo> infoes= daoMap.get(USERINFO).getInfoesByProperties(c1);
	//记录日志信息，如果登陆成功就把登陆的信息写到记录中去
	if(infoes!=null&&infoes.size()==1){
	  //首先得出用户
		Userinfo userinfo2=infoes.get(0);
		Userloginfo userloginfo=new Userloginfo(userinfo2, new Date(),new Integer(1));
	  daoMap.get(USERLOGINFO).execute_inset(userloginfo);
	  return userinfo2;
	}
	return null;
  }
  /**
   * 系统用户退出
   * @param user  需要退出的用户，封装相关的数据，填写日志表格
   */
  public void exit(Userinfo user){
	  Userloginfo userloginfo=new Userloginfo(user, new Date(),new Integer(0));
	  daoMap.get(USERLOGINFO).execute_inset(userloginfo);
  }
}
