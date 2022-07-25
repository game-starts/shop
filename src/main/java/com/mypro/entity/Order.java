package com.mypro.entity;


import java.util.Date;
import java.util.List;

//订单类
public class Order {
    private String oid;
    private Date ordertime;
    private Float total;
    private Integer state;
    private String address;
    private String name;
    private String telephone;
    private Integer uid;

    //订单中包含 订单项集合
    private List<OrderItem>  items=null;
    
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Order{" +
				"oid='" + oid + '\'' +
				", ordertime=" + ordertime +
				", total=" + total +
				", state=" + state +
				", address='" + address + '\'' +
				", name='" + name + '\'' +
				", telephone='" + telephone + '\'' +
				", uid=" + uid +
				'}';
	}
}