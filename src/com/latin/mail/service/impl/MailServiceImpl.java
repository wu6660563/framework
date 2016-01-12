package com.latin.mail.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latin.common.utils.DateUtils;
import com.latin.mail.mapper.MailMapper;
import com.latin.mail.model.MailTask;
import com.latin.mail.service.MailService;
import com.latin.mail.util.MailUtil;

/**
 * 
 * @ClassName MailServiceImpl
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:26:18 PM
 */
@Service("mailService")
@Transactional
public class MailServiceImpl implements MailService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private MailMapper mailMapper;

	@Autowired
	public MailUtil mailUtil;

	/**
	 * 
	 * @Title sendMailTask
	 * @Description 
	 * @return
	 * @see com.latin.mail.service.MailService#sendMailTask()
	 */
	public boolean sendMailTask() {
		System.out.println("是否调用！！！！！！！！！！");
		boolean flag = false;
		List<MailTask> mailTaskList = mailMapper.getMailTaskList();
		if(mailTaskList != null && mailTaskList.size() > 0) {
			for (MailTask mailTaskvo : mailTaskList) {
				logger.info(mailTaskvo.getMail_from()+"------"+mailTaskvo.getMail_to()+"--------"+mailTaskvo.getMail_subject());
				mailUtil.send(mailTaskvo.getMail_to(), mailTaskvo.getMail_message(), mailTaskvo.getMail_subject());
				mailTaskvo.setIs_ok(1);
				mailTaskvo.setSend_count(mailTaskvo.getSend_count()+1);
				mailTaskvo.setDate_modified(DateUtils.getCurrentTime());
				mailMapper.updateStatus(mailTaskvo);
				logger.info(mailTaskvo.getTask_id()+"---------发送成功！");
			}
		}
		flag = true;
		return flag;
	}

	/**
	 * @return mailMapper
	 */
	public MailMapper getMailMapper() {
		return mailMapper;
	}

	/**
	 * @param mailMapper
	 * mailMapper
	 */
	public void setMailMapper(MailMapper mailMapper) {
		this.mailMapper = mailMapper;
	}

	/**
	 * @return mailUtil
	 */
	public MailUtil getMailUtil() {
		return mailUtil;
	}

	/**
	 * @param mailUtil
	 * mailUtil
	 */
	public void setMailUtil(MailUtil mailUtil) {
		this.mailUtil = mailUtil;
	}
	

}
