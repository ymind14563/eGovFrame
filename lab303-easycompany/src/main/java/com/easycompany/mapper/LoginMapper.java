package com.easycompany.mapper;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.easycompany.cmm.vo.Account;

import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("loginMapper")
public class LoginMapper extends EgovAbstractMapper{

	public Account authenticate(String id, String password) throws DataAccessException{
		Account account = new Account();
		account.setEmployeeid(id);
		account.setPassword(password);
		return (Account)selectOne("com.easycompany.mapper.EmpMapper.authenticate", account);
	}
}
