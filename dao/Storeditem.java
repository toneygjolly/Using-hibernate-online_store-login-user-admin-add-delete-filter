package com.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.connect.HibernateConnect;
import com.pojo.Item;
import com.pojo.OrderDetails;
import com.pojo.User;



public class Storeditem {
	Scanner sc;
	 private SessionFactory fact;
	 private Session ses;
	 private org.hibernate.Transaction tx;
	 List<Item> buyinglist;

	 
	 public  Storeditem() {
		 sc=new Scanner(System.in);
		 fact = HibernateConnect.getSessionFactory();
		 buyinglist=new ArrayList<>();
	 }
	 
	 public void displayitem()
	 {
		 ses=fact.openSession();
			tx=ses.beginTransaction();
			Query q=ses.createQuery("from Item");
			List<Item>Itemlist=q.list();
			for(Item i:Itemlist) {
				System.out.println("*********************");
				System.out.println("item id="+i.getItemid());
				System.out.println("Item name="+i.getItemname());
				System.out.println("Item price"+i.getItemprice());
				System.out.println("*********************");
			
			}
	 }
	 public void  addtocart(User P)
	 {
		 ses=fact.openSession();
			tx=ses.beginTransaction();
			String choice="y";
			while(choice.equals("y")) {
			System.out.println("Enter the product");
			String name=sc.next();
			Query q=ses.createQuery("select p from Item p where p.itemname=:na");
			q.setParameter("na",name);
			List<Item>buying=q.list();
			//int it =15;
			
			//List<OrderDetails>history=new ArrayList<>();
			for(Item i:buying) {
				System.out.println("*********************");
				System.out.println("item id="+i.getItemid());
				System.out.println("Item name="+i.getItemname());
				System.out.println("Item price"+i.getItemprice());
				System.out.println("*********************");
//				System.out.println("enter the numbe of plate you want to purchase");
	//			int plate = sc.nextInt();
//				i.setItemprice(plate);

				//System.out.println("date"+i.getOdd());
				buyinglist.add(i);
				
				//List<OrderDetails>history=new ArrayList<>();

				OrderDetails od  = new OrderDetails();
				System.out.println("Enter the oderid");
				od.setOrderid(sc.nextInt());
				System.out.println("enter the numbe of plate you want to purchase");
				od.setPlate(sc.nextInt());
				for(Item m:buyinglist) {
					double total=(m.getItemprice()*od.getPlate());
					od.setTotal(total);
				}
//				double total = plate*
				//od.setOrderid(it++);
				LocalDate date = LocalDate.now();
				od.setPurchasedate(date);
				od.setUobj(P);
				ses.save(od);
			
			}
			
		    
		   
		    System.out.println("did you want to enter more product(Y)");
			choice=sc.next();
			
			//tx.commit();
		    //ses.close();
			}
			//ses.close();
			tx.commit();
			}
	 
	 public void finalamount()
	 {
		 double total=0.0;
		 System.out.println("bILL GENERATION");
			System.out.println("---------------------");
			for(Item o:buyinglist) {
			total=total+o.getItemprice();
			
			}
			System.out.println("Total amount "+total);
			System.out.println("---------------------");
	 }
	 public void finall() {
		 double total=0;
		 ses=fact.openSession();
			tx=ses.beginTransaction();
			System.out.println("Enter the userid");
			int name=sc.nextInt();
			Query q=ses.createQuery("from OrderDetails where UserIdfk=:u");
			q.setParameter("u",name);
			List<OrderDetails>Olist=q.list();
			for(OrderDetails i:Olist) {
				
				total=total+i.getTotal();
				
				//System.out.println("FINAL Bill="+i.getTotal());
				
			}
			System.out.println("final amount"+total);
	 }
	 public void history(User P)
	 {
		 ses=fact.openSession();
			tx=ses.beginTransaction();
		 System.out.println("History of order");
		//OrderDetails od  = new OrderDetails();
		// System.out.println("purchase date"+od.getPurchasedate(date));
		 for(Item b:buyinglist) {
			 System.out.println("---------------------");	 
		 System.out.println("Item name="+b.getItemname());
		 System.out.println("Item price="+b.getItemprice());
		 }
		 
		 
	 }
	 public void history1(User P)
	 {
		 ses=fact.openSession();
		 Query q=ses.createQuery("select p from User p where p.userid=:id");
		 q.setParameter("id",P.getUserid());
		 List<User>ulist=q.list();
		 List<OrderDetails>hlist=new ArrayList<>();
		 
		 for(User u:ulist)
		 {
			 hlist=u.getOrderlist();
		 }
		 for(OrderDetails o:hlist)
		 {
			 System.out.println("orderid"+o.getOrderid());
			 System.out.println("order date"+o.getPurchasedate());
			
		 }
				 
	 }
	 
}
