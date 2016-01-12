package com.latin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @ClassName AccountController
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:24:31 PM
 */
@Controller
@RequestMapping("/account")
public class AccountController {
//	
//	@Resource(name="accountService")
//	public AccountService accountService;
//
//
//	/**
//	 * 
//	 * @MethodName: add
//	 * @Description: 初始化页面请求
//	 * @author nick
//	 * @param request
//	 * @param response
//	 * @return ModelAndView
//	 * @throws
//	 */
//
//	@RequestMapping("/addinit")
//	public ModelAndView add(HttpServletRequest request,
//			HttpServletResponse response) {
//		return new ModelAndView("jsptest/add");
//	}
//
//	/**
//	 * 
//	 * @MethodName: create
//	 * @Description: TODO
//	 * @author nick
//	 * @param accountModel
//	 * @param request
//	 * @param response
//	 * @return ModelAndView
//	 * @throws
//	 */
//	@RequestMapping(value="/addSubmit",method=RequestMethod.POST)
//	public ModelAndView create(
//			@ModelAttribute("accountModel") AccountModel accountModel,
//			HttpServletRequest request, HttpServletResponse response) {
//		accountService.insertUser(accountModel);
//		System.out.println(">>>>>>>>>>>>>>>>"+accountModel.getAccountId());
//		return new ModelAndView("jsptest/success");
//
//	}
//
//	@ExceptionHandler(Exception.class)
//	public String exception(Exception e, HttpServletRequest request) {
//		e.printStackTrace();
//		request.setAttribute("exception", e);
//		return "jsptest/error";
//	}
}
