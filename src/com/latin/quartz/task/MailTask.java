package com.latin.quartz.task;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.latin.common.ApplicationContextFactory;
import com.latin.mail.service.MailService;

@Component("mailTask")
public class MailTask {

	private Logger logger = Logger.getLogger(this.getClass());

	public void sendMail() {
		logger.info("MailTask-----------sendMail------start");
		MailService mailService = (MailService) ApplicationContextFactory.getBean("mailService");
		mailService.sendMailTask();
		logger.info("MailTask-----------sendMail------end");
	}

}
