package com.latin.exception;
 
import org.springframework.dao.DataAccessException;

/**
 * 
 * @Project：mybatisForSpring3   
 * ServiceException   
 * @Description：TODO  
 * @author：nick   
 * @CreateTime：2015/09/08
 * @Remark：TODO 
 * @version 1.0
 */
public class ServiceException extends DataAccessException {
 
    private static final long serialVersionUID = 1L;
    
    public ServiceException(String msg) {
        super(msg);
    }
 
    public ServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

