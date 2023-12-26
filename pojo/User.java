package com.pojo;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "UserTable11")
//@Inheritance(strategy=InheritanceType.JOINED)
public class User {
    @Id
    @Column(name = "UserId")
    private int userid;
    @Column(name = "UserName")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "UserType")
    private String usertype;
    @OneToMany(mappedBy="uobj",cascade = CascadeType.ALL)
    private List<OrderDetails> orderlist;
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsertype() {
        return usertype;
    }
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    public List<OrderDetails> getOrderlist() {
        return orderlist;
    }
    public void setOrderlist(List<OrderDetails> orderlist) {
        this.orderlist = orderlist;
    }
    
}