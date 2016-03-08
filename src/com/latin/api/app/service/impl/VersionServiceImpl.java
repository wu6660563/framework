package com.latin.api.app.service.impl;

import java.util.Hashtable;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latin.api.app.mapper.VersionMapper;
import com.latin.api.app.model.Version;
import com.latin.api.app.service.VersionService;

/**
 * 
 * @ClassName VersionServiceImpl
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:46:47 PM
 */
@Service("versionService")
@Transactional
public class VersionServiceImpl implements VersionService {
	
	private Logger logger = Logger.getLogger(VersionServiceImpl.class);
	
	@Autowired
	private VersionMapper versionMapper;

	/**
	 * 
	 * @Title getLatestVersion
	 * @Description 
	 * @return
	 * @see com.latin.api.app.service.VersionService#getLatestVersion()
	 */
	public String getLatestVersion() {
		Version version = versionMapper.getLastObject();
		
		Hashtable<String, Object> returnHash = new Hashtable<String, Object>();
		returnHash.put("code", 0);
		returnHash.put("msg", "get the version success");
		returnHash.put("model", version);
		
		JSONObject result = JSONObject.fromObject(returnHash);
		logger.info("------>"+result.toString());
		return result.toString();
	}

}
