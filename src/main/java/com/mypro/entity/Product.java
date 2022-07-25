package com.mypro.entity;

import java.util.Date;

//商品
public class Product {
	
    private Integer pid;
    private String pname;
    private Float market_price;
    private Float shop_price;
    private String pimage;
    private Date pdate;
    private Integer isHot;
    private String pdesc;
    private Integer pflag;
    private Integer cid;


    
    
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Float getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Float market_price) {
		this.market_price = market_price;
	}
	public Float getShop_price() {
		return shop_price;
	}
	public void setShop_price(Float shop_price) {
		this.shop_price = shop_price;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getPflag() {
		return pflag;
	}
	public void setPflag(Integer pflag) {
		this.pflag = pflag;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}



}
