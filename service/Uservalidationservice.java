package com.service;

import com.dao.Uservalidation;

public class Uservalidationservice {
	Uservalidation userdao;
	
	public Uservalidationservice() {
		userdao=new Uservalidation();
	}
	
	public void insert()
	{
		userdao.insert();
	}
	public void usercheck()
	{
		userdao.usercheck();
	}
	
}
