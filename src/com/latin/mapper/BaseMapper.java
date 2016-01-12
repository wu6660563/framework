package com.latin.mapper;

import java.util.List;

/**
 * 公用的Mapper类，所有的
 * 
 * @author nick
 *
 */
public interface BaseMapper<T> {

	/**
	 * 增加
	 * @param t
	 * @return
	 */
	public boolean add(T t);

	/**删除
	 * @param t
	 * @return
	 */
	public boolean delete(T t);

	/**修改
	 * @param t
	 * @return
	 */
	public T update(T t);

	/**按照ID查询
	 * @param id
	 * @return
	 */
	public boolean findById(int id);

	/**查询所有的
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 得到最新一条数据
	 * @return
	 */
	public T getLastObject();

}
