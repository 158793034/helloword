package org.school.action;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.school.Service.ModelService;

import com.opensymphony.xwork2.ActionContext;


/**
 * 用于 子类基础设计 响应 控制层action的父类
 * 子类需要根据设计改变指定的命名空间(namespace)以及跳转中的@result注释
 * @author Administrator
 *
 */
public abstract class BaseAction {
	
     /**
      * 依赖spring注入，获取ModelService对象
      */
	@Resource
	private ModelService service;
     /**
      * 用于关联service  以指定Action需要使用的Dao对象
      */
	private String key;
   
	/**
	 * pageNum:分页查询时用的页面，默认在第一页。rowCount:分页查询时，指定每页的行数，默认每页10行
	 */
	private int pageNum=1;
	private int rowCount=10;
	/**
	 * 分页查询时，根据指定的行数(rowCount)和相关信息表格  获取指定表格可以分的页数
	 */
	private Integer pageCount=null;
	/**
	 * 判断相关操作时添加还是更新的标识
	 */
	private String saveOrUpdate;
	
	 
	public String getSaveOrUpdate() {
		return saveOrUpdate;
	}

	public void setSaveOrUpdate(String saveOrUpdate) {
		this.saveOrUpdate = saveOrUpdate;
	}

	
  public int getPageCount() {
	  if(pageCount==null){
		pageCount=this.getService().getPageCount(getKey(), this.getRowCount());
	  }
	return pageCount;
}
	public int getPageNum() {
		return pageNum;
	}
	/**
	 * 相应setter 封装判断指定页数的合理性
	 * @param pageNum
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		if(this.pageNum<1)  //防止最小页数的时候
			this.pageNum=1;
		if(this.pageNum>this.getPageCount()){  //限定最大的页数
			this.pageNum=this.getPageCount();
		}
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	/**
	 * 强制实现getkey  结合父类封装需要，提供用于子类方法使用
	 * @return  用于关联service  以指定Action需要使用的Dao对象 的关键字
	 */
public abstract String getKey();
	public void setKey(String key) {
		this.key = key;
	}
public ModelService getService() {
		return service;
	}
	public void setService(ModelService service) {
		this.service = service;
	}
	/********************一下部分为从studentAction中抽取的共性方法--共性提取**********************************/
   public abstract List getBach_list(); //由于子类中都有list属性，所以在这里提出一个抽象
	
	public abstract Serializable getEntity();  //由于所有的实体类都是先了serializable接口，所以这里使用serializable属性
	
	/**
	 * 根据指定操作获取分页信息查询的操作方法
	 * @return
	 */
	@Action(value="getInfo")
    public String getInfo(){
		
		Map mp=(Map)ActionContext.getContext().get("request");
		
		mp.put("infoes",this.getService().getInfoByPageNum(getKey(), getPageNum(), getRowCount()));
		
		return "infoes";
   	 
    }
	/**
	 * 根据操作进行单个删除或者批量删除的方法
	 * @return
	 */
	@Action(value="deleteInfo")
	public String deleteInfo(){
		if(getBach_list()!=null&&getBach_list().size()>0){
			
			this.getService().delete_batch(getKey(), getBach_list().toArray());  //如果list不为空就删除list
			
		}else if(getEntity()!=null){
			this.getService().delete_batch(getKey(), getEntity());
			
		}
	
		return getInfo();  //删除信息后需要显示，如果直接返回"infoes"的话就没有传递的参数，这个时候直接调用方法，就不用考虑值的问题。
	}
	/**
	 * 根据标示符，决定是添加信息或者是更新信息
	 * @return
	 */
	@Action(value="insertOrUpdate")
	public  String insertOrUpdate(){
	if("update".equals(this.getSaveOrUpdate())){
		getService().update_batch(getKey(), getEntity());
	}
	else if("insert".equals(this.getSaveOrUpdate())){
		getService().insert_batch(getKey(), getEntity());
	}
		return getInfo();
	}

	
}
