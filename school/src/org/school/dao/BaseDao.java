package org.school.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.school.interfaces.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


//继承hibernateTemplete 相关方法可以直接使用,增删改查
@Transactional
public class BaseDao<T> extends HibernateTemplate implements Dao<T> {
	
	public static final int INSERT=1;
	public static final int DELETE=2;
	public static final int UPDATE=3;
	
	private Class type;
	@Autowired
	public BaseDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		
	ParameterizedType parameterizedType=(ParameterizedType)this.getClass().getGenericSuperclass();
	this.type=(Class)parameterizedType.getActualTypeArguments()[0];
	}
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<T> getAll() {
		
		return find(new StringBuffer(" from ").append(this.type.getName()).toString());
	}

	@Override
	public T getById(Serializable id) {
	
		return (T)get(this.type.getName(), id);
	}

	@Override
	public List<T> getInfoesByProperties(Criterion... criterions) {
		
		return getInfoesByProperties(null, null, criterions);
	}
	
	@Override
	/**
	 * 分页操作
	 */
	public List<T> getInfoesByProperties(Integer pageNum, Integer rowCount,
			Criterion... criterions) {
		DetachedCriteria criteria=DetachedCriteria.forClass(type);
		
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		//这就是需要分页
		if(pageNum!=null&&rowCount!=null&&pageNum>=1&&rowCount>=1){
		 return	findByCriteria(criteria, (pageNum-1)*rowCount, rowCount);
		}
		return findByCriteria(criteria);//不分页返回值
	}
	//由于插入，更新，删除方法类似，可以抽出一个共性的方法，定义一个i，当数据多的时候刷新缓存有用
	public void update(int wantToDo,T...ts){
		int i=0;
		switch (wantToDo) {
		case INSERT:
			for (T t : ts) {
				if(++i%50==0){
					this.flush();
					this.clear();
				}
				
				save(t);
			}
			break;
		case DELETE:
			for (T t : ts) {
				if(++i%50==0){
					this.flush();
					this.clear();
				}
				delete(t);
			}
			break;
		case UPDATE:
			for (T t : ts) {
				if(++i%50==0){
					this.flush();
					this.clear();
				}
				update(t);
			}
			break;
		default:
			break;
		}
	}
	//直接调用共性中的方法
	@Override
	public void execute_inset(T... ts) {
		this.update(INSERT,ts);
		
	}

	@Override
	public void execute_delete(T... ts) {
		this.update(DELETE, ts);
		
	}

	@Override
	public void execute_update(T... ts) {
	this.update(UPDATE,ts);
	}

	@Override
	public int getPageCountByRowCount(int rowCount) {
		Session session =this.getSession();
		
	
	Query query=session.createQuery("select count(v1) from "+this.type.getSimpleName()+" v1");
	 long count=(long)query.uniqueResult();
		return (int)(count%rowCount==0?count/rowCount:((count/rowCount)+1));
	}

	@Override
	// 获取根据筛选条件得到的信息的数量
	public int getRowCount(Criterion... criterions) {
		
		DetachedCriteria criteria=DetachedCriteria.forClass(type);
		
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		criteria.setProjection(Projections.rowCount());
		
		return (int)findByCriteria(criteria).get(0);
	}



}
