package com.client;

import java.util.Scanner;

import com.service.Uservalidationservice;

public class Loginmain {
	Uservalidationservice userservice;
	Scanner sc;
	public Loginmain()
	{
		userservice=new Uservalidationservice();
		sc=new Scanner(System.in);
	}
	
	public void loginmenu()
	{
	System.out.println("WELCOME TO ONLINE STORE");
	int ch=0;
	String choice="Y";
	while(choice.equals("Y")) {
		System.out.println("1.Admin login");
		System.out.println("2.User login");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			userservice.usercheck();
			break;
		case 2:
			Userlogin();
			break;
		}
		System.out.println("Do you want to continue y/n");
		choice=sc.next();
	}
	}
	public void Userlogin() {
		
		 System.out.println("Welcome to User page");
		 int ch=0;
			String choice="Y";
			while(choice.equals("Y")) {
				System.out.println("1.New Register user");
				System.out.println("2.user login");
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					userservice.insert();
					break;
				case 2:
					userservice.usercheck();
					break;
				}
				System.out.println("Do you want to continue y/n");
				choice=sc.next();
	 }
	 }
	
	public static void main(String args[]) {
		Loginmain lm=new Loginmain();
		lm.loginmenu();
	}
}
