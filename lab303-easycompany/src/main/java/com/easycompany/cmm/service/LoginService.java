package com.easycompany.cmm.service;

import com.easycompany.cmm.vo.Account;

public interface LoginService {
	
	public Account authenticate(String id, String password);	
}
