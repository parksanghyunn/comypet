package com.comypet.app.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.comypet.app.vo.CustomerVo;
import com.comypet.mybatis.config.SqlMapConfig;

public class CustomerDao {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public CustomerDao() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean insertCustomerContents(CustomerVo customer) {
		if(sqlsession.insert("Customer.insertCustomerContents", customer) == 1) {
			return true;
		}
		return false;
	}

}
