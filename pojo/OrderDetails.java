package com.pojo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "orderDetails00000")
public class OrderDetails{
	@Id
	@Column(name="ID")
	private int orderid;
	@Column(name = "purchaseDate")
	private LocalDate purchasedate;
	@ManyToOne
	@JoinColumn(name = "UserIdfk")
	private User uobj;
	@Column(name="Total")
	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Column(name="NumberOfPlate")
	private int plate;

	public int getPlate() {
		return plate;
	}

	public void setPlate(int plate) {
		this.plate = plate;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public LocalDate getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(LocalDate date) {
		this.purchasedate = date;
	}

	public User getUobj() {
		return uobj;
	}

	public void setUobj(User uobj) {
		this.uobj = uobj;
		
	
/*
	
	@OneToMany(mappedBy="uobj",cascade = CascadeType.ALL)
    private List<Item> orderlist;

	public List<Item> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(List<Item> orderlist) {
		this.orderlist = orderlist;
	}

*/

	
	}
}
