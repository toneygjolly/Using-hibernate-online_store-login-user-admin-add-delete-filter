package com.connect;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pojo.Item;
import com.pojo.OrderDetails;
import com.pojo.User;

public class HibernateConnect {
	private static SessionFactory sesfact;

	private HibernateConnect() {
       
        sesfact = new Configuration().configure("Hiber.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(Item.class).
                addAnnotatedClass(OrderDetails.class).buildSessionFactory();
        System.out.println("Session factory created!");

    }

	public static SessionFactory getSessionFactory() {
		if (sesfact == null) {
			new HibernateConnect();
			return sesfact;
		} else {
			return sesfact;
		}

	}
	// public static void main(String[] args) {
	// HibernateConnect.getSessionFactory();
	// }

}
