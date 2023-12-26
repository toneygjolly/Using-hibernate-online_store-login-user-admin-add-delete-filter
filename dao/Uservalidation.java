package com.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.connect.HibernateConnect;

import com.pojo.Item;
import com.pojo.OrderDetails;
import com.pojo.User;






public class Uservalidation {
	Scanner sc;
	 private SessionFactory fact;
	 private Session ses;
	 private Transaction tx;
	Storeditem store;
	 public Uservalidation() {
		 sc=new Scanner(System.in);
		 fact = HibernateConnect.getSessionFactory();
		 store=new Storeditem();
	 }
	 
	public void insert() {
		 
	       
	        Session ses = fact.openSession();
	        ses.beginTransaction();
	      //  org.hibernate.Transaction tx = ses.beginTransaction();
	        System.out.println("Enter how much user u want to add");
	    	int no=sc.nextInt();
	    	for(int i=0;i<no;i++) {
	        User u = new User();
	        System.out.println("Enter the user id");
	        u.setUserid(sc.nextInt());
	        System.out.println("Enter the User name");
	        u.setUsername(sc.next());
	        System.out.println("Enter the password");
	        u.setPassword(sc.next());
	        System.out.println("Enter the Type");
	        u.setUsertype(sc.next());
	        ses.save(u);
	        ses.getTransaction().commit();
	        
	    	}
	    	ses.close();
	    	System.out.println("Enter sucessfully");
	    
	    	}
	public void usercheck()
	{
		
		Session ses = fact.openSession();
        ses.beginTransaction();
        
	System.out.println("Enter the name");
	String name=sc.next();
	System.out.println("Enter the password..");
	String psswd=sc.next();
	Query q=ses.createQuery("Select p from User p where p.username=:user and p.password=:pass");
	q.setParameter("user",name);
	q.setParameter("pass",psswd );
	List<User> userlist=q.list();
	for(User P: userlist) {
		
		if(P.getUsertype().equals("user")) 
		{
			System.out.println("Enter to the Userpage");
			int ch=0;
			String choice="y";
			while(choice.equals("y")){
				System.out.println("Enter your choice...");
				System.out.println("1.List the items");
				System.out.println("2.order list");
				System.out.println("3.final bill");
				System.out.println("4.order History");
				System.out.println("5.order History by date");
				System.out.println("6.exit");
				
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					store.displayitem();
					break;
				case 2:
					store.addtocart(P);
					break;
				case 3:
			store.finall();
					break;
				case 4:
					store.history(P);
					break;
				case 5:
					store.history1(P);
				
				}
				System.out.println("Do you want to continue Y/N");
				choice=sc.next();
		}
			break;
	}
		else if(P.getUsertype().equals("Admin")) {
			System.out.println("Enter to Admin Page");
			int ch=0;
			String choice="y";
			while(choice.equals("y")){
				System.out.println("Enter your choice...");
				System.out.println("1.Insert into Store");
				System.out.println("2.Serach product ById");
				System.out.println("3.Display by category");
				System.out.println("4.Calculate total amount");
				System.out.println("5.Search item ByName");
				System.out.println("6.Calculate profit amount");
				System.out.println("7.exit");
				
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					System.out.println("insert the item");
					
					
					break;
				case 2:
					break;
				
				case 3:
				
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
				}
				System.out.println("Do you want to continue y/n");
				choice=sc.next();
		}
			break;
		}
		else {
			System.out.println("Not available");
		}
	
	}	
	
	
	
}

}

