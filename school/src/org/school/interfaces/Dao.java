package org.school.interfaces;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;
/**
 * 基于规范进行设计的Dao接口
 * @author Administrator
 *
 * @param <T>
 */
public interface Dao<T> {
	/**
	 * 获取相关表格全部信息
	 * @return 封装有相关信息的实体类对象的list
	 */
	List<T> getAll();
	/**
	 * 根据主键获取指定信息封装对象
	 * @param id  主键信息
	 * @return  封装有相关数据的实体类对象
	 */
  T	getById(Serializable id);
  /**
   * 根据业务需要，进行多条件查询的方法
   * @param criterions 查询条件
   * @return  封装有相关信息的实体类对象的list
   */
  List<T> getInfoesByProperties(Criterion...criterions);
  /**
   * 进行多条件查询 并实现分页
   * @param pageNum   要查询的页面
   * @param rowCount   指定每页的行数
   * @param criterions
   * @return
   */
  List<T> getInfoesByProperties(Integer pageNum,Integer rowCount,Criterion...criterions);
  /**
   * 批量进行相关数据添加的方法
   * @param ts 封装有数据的n个实体类对象
   */

  void execute_inset(T...ts);
  /**
   * 批量进行相关数据删除的方法
   * @param ts 封装有数据的n个实体类对象
   */
  void execute_delete(T...ts);
  /**
   * 批量进行相关数据更新的方法
   * @param ts 封装有数据的n个实体类对象
   */
  void execute_update(T...ts);
  /**
   * 根据每页行数 得到相关表格可以分成几页的方法
   * @param rowCount   每页行数
   * @return  页数
   */
  int getPageCountByRowCount(int rowCount);
  /**
   * 获取根据筛选条件得到的信息的数量
   * @param criterions   筛选条件
   * @return  信息数量(行数)
   */
  int getRowCount(Criterion...criterions);
}
