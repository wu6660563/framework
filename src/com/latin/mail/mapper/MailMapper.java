package com.latin.mail.mapper;

import java.util.HashMap;
import java.util.List;

import com.latin.mail.model.MailTask;
import com.latin.mapper.BaseMapper;

public interface MailMapper extends BaseMapper<MailTask> {

	public List<HashMap<String, String>> getMailProperties();

	public List<MailTask> getMailTaskList();
	
	public void updateStatus(MailTask mailTask);

}
