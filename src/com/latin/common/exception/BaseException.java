/**
 *
 * @Title BaseException.java
 * @Package com.latin.common.exception
 * @Description TODO
 * @Date Jan 12, 2016 9:35:12 PM
 * @version 1.0
 */
package com.latin.common.exception;

/**
 * @ClassName BaseException
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:35:12 PM
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	private long code = 0;

	/**
	 * 
	 * @Title BaseException
	 * @param @return
	 * @return long
	 * @Description TODO
	 * @thorws
	 */
	public long getCode() {
		return code;
	}

	/**
	 * 
	 * @Title BaseException
	 * @param @param code
	 * @return void
	 * @Description TODO
	 * @thorws
	 */
	public void setCode(long code) {
		this.code = code;
	}

	/**
	 * 
	 * @Title BaseException
	 * 
	 * @Description TODO
	 * @param string
	 * @param code
	 */
	public BaseException(String string, long code) {
		super(string);
		this.code = code;
	}

	/**
	 * 
	 * @Title getMessage
	 * @Description 
	 * @return
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return this.code + ":" + super.getMessage();
	}

}
