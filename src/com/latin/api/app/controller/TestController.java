package com.latin.api.app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName TestController
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 9:44:30 PM
 */
@Controller
@RequestMapping("/app")
public class TestController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Test() {
		logger.info("start");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "xxx");
		modelAndView.addObject("xxx", "xxxx");
		return modelAndView;
	}
	
}
