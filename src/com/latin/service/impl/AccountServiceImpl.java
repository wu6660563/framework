package com.latin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latin.mapper.AccountMapper;
import com.latin.model.AccountModel;
import com.latin.service.AccountService;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @author Nick
 * @version 1.0
 * @Date Jan 12, 2016 10:34:22 PM
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	public AccountMapper getAccountMapper() {
		return accountMapper;
	}

	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	public void insertUser(AccountModel accountModel) {
		accountMapper.insertUser(accountModel);
	}

}
