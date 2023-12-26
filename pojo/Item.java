package com.pojo;

import javax.persistence.*;
@Entity
@Table(name ="ItemTable00000")
//@Inheritance(strategy=InheritanceType.JOINED)
public class Item  {
    @Id
    @Column(name = "ItemId")
    private int itemid;
    
    
    
  //  public int getPlates() {
//		return plates;
	//}
	//public void setPlates(int plates) {
		//this.plates = plates;
	//}
	//@Column(name = "No of plates")
    //private int plates;
    
    
    
    @Column(name = "ItemName")
    private String itemname;
    @Column(name = "ItemPrice")
    private double itemprice;
    
    public int getItemid() {
        return itemid;
    }
    public void setItemid(int itemid) {
        this.itemid = itemid;
    }
    public String getItemname() {
        return itemname;
    }
    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    public double getItemprice() {
        return itemprice;
    }
    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }
    
    
    /*public OrderDetails getUobj() {
		return uob;
	}
	public void setUobj(OrderDetails uobj) {
		this.uob = uob;
	}


	@ManyToOne
	private OrderDetails uob;
	   
   */
    

}
