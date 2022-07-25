package com.mypro.to;

import java.util.List;

public class pageData {
    int page;
    int pagenum;
    int pagepre;
    int pagenext;
    List product;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPagepre() {
        return pagepre;
    }

    public void setPagepre(int pagepre) {
        this.pagepre = pagepre;
    }

    public int getPagenext() {
        return pagenext;
    }

    public void setPagenext(int pagenext) {
        this.pagenext = pagenext;
    }

    public List getProduct() {
        return product;
    }

    public void setProduct(List product) {
        this.product = product;
    }
}
