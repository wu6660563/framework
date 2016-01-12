package com.latin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latin.mapper.AccountMapper;
import com.latin.model.AccountModel;
import com.latin.service.AccountService;
/**
 * 
 * @author nick
 *
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
