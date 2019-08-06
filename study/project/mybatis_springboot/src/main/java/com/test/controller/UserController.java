package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.test.aop.service.AopService;
import com.test.aop.service.ExecutionService;
import com.test.model.User;
import com.test.service.TxServiceA;
import com.test.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TxServiceA txServiceA;

	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}

	@RequestMapping("/get")
	@ResponseBody
	public String get(User user) {
		User u = userService.getNameById(user);

		return JSONObject.toJSONString(u);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public void add(User user) {
		userService.addUser(user);
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public Map<String, Object> test() {
		String str = txServiceA.serviceAaa();
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", str);
		
		return result;
	}
	
	@RequestMapping("/aspect")
	public void log() {
		aopService.addUser();
		aopService.addStu();
	}
	
	@Autowired
	private ExecutionService execute;
	
	@RequestMapping("/execute")
	public void execute() {
		execute.executeMethod("testExecute", 123);
	}

	@Resource
	private AopService aopService;
}
