package com.latin.api.app.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latin.api.app.common.APPAPIConstant;
import com.latin.api.app.service.APPAPIService;
import com.latin.api.app.service.OpinionService;
import com.latin.api.app.service.VersionService;

/**
 * 
 * @ClassName APPAPIServiceImpl
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:46:09 PM
 */
@Service("appAPIService")
@Transactional
public class APPAPIServiceImpl implements APPAPIService {

	@Resource(name = "opinionService")
	private OpinionService opinionService;
	
	@Resource(name = "versionService")
	private VersionService versionService;

	/**
	 * 
	 * @Title excute
	 * @Description 
	 * @param map
	 * @return
	 * @see com.latin.api.app.service.APPAPIService#excute(java.util.HashMap)
	 */
	public String excute(HashMap<String, String> map) {
		//osType和version打算用做日志文件用
//		String osType = String.valueOf(jsonObject.get("osType")); // 1-android 或者
																	
		int apiId = Integer.valueOf(map.get("apiId"));
//		String version = String.valueOf(jsonObject.get("version")); // 每个请求都必须要有版本，才能跟进问题关键
		String jsonData = "{}";
		switch (apiId) {
		case APPAPIConstant.API_ID_OPINION:
			// 调用OpinionService
			jsonData = opinionService.addOpinion(map);
			break;
		case APPAPIConstant.API_ID_VERSION_MANAGE:
			// 调用versionManageService
			jsonData = versionService.getLatestVersion();
			break;
		default:
			jsonData = defaultResponse();
			break;
		}
		return jsonData;
	}
	
	/**
	 * 
	 * @Title APPAPIServiceImpl defaultResponse
	 * @return String
	 * @Description TODO
	 */
	public String defaultResponse() {
		String jsonData = "{}";
		HashMap<String, Object> returnHash = new HashMap<String, Object>();
		returnHash.put("code", "500");
		returnHash.put("msg", "not find apiId parameter!");
		returnHash.put("model", new HashMap<String, String>());
		JSONObject result = JSONObject.fromObject(returnHash);
		jsonData = result.toString();
		return jsonData;
	}


	/**
	 * @Title test
	 * @Description 
	 * @return
	 * @see com.latin.api.app.service.APPAPIService#test()
	 */
	public String test() {
		System.out.println("111111111111111");
		return null;
	}

}
