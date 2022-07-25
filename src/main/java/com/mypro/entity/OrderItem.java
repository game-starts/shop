package com.mypro.entity;

//订单项
public class OrderItem {
   
    private String itemid;
    private Integer count;
    private Float subtotal;
	private Integer pid;
	private String oid;

    private Product iproduct;//该订单项对应的商品对象


	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Product getIproduct() {
		return iproduct;
	}

	public void setIproduct(Product iproduct) {
		this.iproduct = iproduct;
	}


	@Override
	public String toString() {
		return "OrderItem{" +
				"count=" + count +
				", subtotal=" + subtotal +
				", pid=" + pid +
				'}';
	}


}