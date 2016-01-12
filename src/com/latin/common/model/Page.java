package com.latin.common.model;

import java.util.List;

import com.latin.model.BaseModel;

/**
 * 
 * @ClassName Page
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:48:07 PM
 * @param <T>
 */
public class Page<T> extends BaseModel {

	/**
	 * @Fields serialVersionUID TODO
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields currentPage 当前页
	 */
	private Integer currentPage;

	/**
	 * @Fields total 总的数据条数
	 */
	private Integer total;

	/**
	 * @Fields startPage 开始页面
	 */
	private Integer startPage;

	/**
	 * @Fields endPage 结束页面
	 */
	private Integer endPage;

	/**
	 * @Fields resultList 结果集
	 */
	private List<T> resultList;

	/**
	 * @return currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            currentPage
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            total
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return startPage
	 */
	public Integer getStartPage() {
		return startPage;
	}

	/**
	 * @param startPage
	 *            startPage
	 */
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	/**
	 * @return endPage
	 */
	public Integer getEndPage() {
		return endPage;
	}

	/**
	 * @param endPage
	 *            endPage
	 */
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	/**
	 * @return resultList
	 */
	public List<T> getResultList() {
		return resultList;
	}

	/**
	 * @param resultList
	 *            resultList
	 */
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

}
