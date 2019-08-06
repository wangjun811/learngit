package com.test.service.impl;

import javax.annotation.Resource;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.test.dao.UserDao;
import com.test.model.User;
import com.test.service.TxServiceA;
import com.test.service.TxServiceB;

@Service
public class TxServiceAImpl implements TxServiceA {

	@Autowired
	private UserDao userDao;
	
	@Resource
	private TxServiceB txServiceB;
	
	@Transactional
	@Override
	public void serviceA() {
		System.out.println("serviceA......");
		
		userDao.addUser(new User("678", "txTester"));
		
		try{
			/**
			 * 通过ThreadLocal暴露Aop代理对象
			 */
			((TxServiceA)AopContext.currentProxy()).serviceAa();
		} catch(Exception e) {
			System.out.println("调用serviceB发生异常了......");
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void serviceAa() {
		System.out.println("serviceAa......");
		userDao.addUser(new User("876", "serviceAa"));
		
		throw new RuntimeException();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String serviceAaa() {
		System.out.println("serviceAaa......");
		
		userDao.addUser(new User("idAaa", "serviceAaa"));
		
		String result = txServiceB.serviceBb();
		
		System.out.println("最后调用结果：" + result);
		
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		
		return result;
	}

}
