package com.latin.api.app.service.impl;

import java.util.HashMap;
import java.util.Hashtable;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.latin.api.app.mapper.OpinionMapper;
import com.latin.api.app.model.Opinion;
import com.latin.api.app.service.OpinionService;
import com.latin.common.utils.DateUtils;

/**
 * 
 * @ClassName OpinionServiceImpl
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:46:34 PM
 */
@Service("opinionService")
@Transactional
public class OpinionServiceImpl implements OpinionService {

	private Logger logger = Logger.getLogger(OpinionServiceImpl.class);

	@Autowired
	private OpinionMapper opinionMapper;

	/**
	 * 
	 * @Title OpinionServiceImpl
	 * @param @return
	 * @return OpinionMapper
	 * @Description TODO
	 * @thorws
	 */
	public OpinionMapper getOpinionMapper() {
		return opinionMapper;
	}

	/**
	 * 
	 * @Title OpinionServiceImpl
	 * @param @param opinionMapper
	 * @return void
	 * @Description TODO
	 * @thorws
	 */
	public void setOpinionMapper(OpinionMapper opinionMapper) {
		this.opinionMapper = opinionMapper;
	}

	/**
	 * 
	 * @Title addOpinion
	 * @Description 
	 * @param map
	 * @return
	 * @see com.latin.api.app.service.OpinionService#addOpinion(java.util.HashMap)
	 */
	public String addOpinion(HashMap<String, String> map) {
		Opinion opinion = new Opinion();
		// opinion.setPhone("18802007610");
		// opinion.setEmail("nick@comprame.com");
		// opinion.setUser_name("nickwu");
		// opinion.setContent("软件体验不好");
		// opinion.setCustomer_id(9);
		// opinion.setOs_type(1);
		// opinion.setNetflow_type(1);
		// opinion.setVersion_number("1.0.1");
		// opinion.setDate_added("2015-09-10 10:24:02");
		// opinion.setDate_modified("2015-09-10 10:24:02");

		opinion.setPhone(map.get("phone"));
		opinion.setEmail(map.get("email"));
		opinion.setUser_name(map.get("user_name"));
		opinion.setContent(map.get("content"));
		opinion.setCustomer_id(Integer.parseInt(map.get("customer_id")));
		opinion.setOs_type(Integer.parseInt(map.get("osType")));
		opinion.setNetflow_type(Integer.parseInt(map.get("netflow_type")));
		opinion.setVersion_number(map.get("version_number"));
		opinion.setDate_added(DateUtils.getCurrentTime());
		opinion.setDate_added(DateUtils.getCurrentTime());

		logger.info("-------------要插入数据："+opinion.getOpinion_id()+"----"+opinion.getNetflow_type()+"----"+opinion.getOs_type());
		opinionMapper.add(opinion);

		Hashtable<String, Object> returnHash = new Hashtable<String, Object>();
		returnHash.put("code", 0);
		returnHash.put("msg", "add the opinion success");
		returnHash.put("model", new HashMap<String, String>());
		JSONObject result = JSONObject.fromObject(returnHash);
		return result.toString();
	}


}
