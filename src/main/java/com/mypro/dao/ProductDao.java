package com.mypro.dao;


import com.mypro.dbutil.DbUtil;
import com.mypro.entity.Category;
import com.mypro.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public List<Product> selectHotProduct() {
        Connection cn = DbUtil.getConn();
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement st = cn.prepareStatement("SELECT p.* FROM product p LIMIT 0,9");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                //封装商品对象
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setPname(rs.getString("pname"));
                p.setPimage(rs.getString("pimage"));
                p.setMarket_price(rs.getFloat("market_price"));
                p.setShop_price(rs.getFloat("shop_price"));
                p.setPdate(rs.getDate("pdate"));
                p.setPdesc(rs.getString("pdesc"));
                p.setCid(rs.getInt("cid"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbUtil.closeConn();
        }
        return list;
    }

    public static List<Product> queryByCid(int cid, int begin, int pageMax) {
        Connection cn = DbUtil.getConn();
        List<Product> list = new ArrayList<Product>();
        try {
            PreparedStatement st = cn.prepareStatement("SELECT p.* FROM product p where cid=? limit ?,?");
            st.setInt(1, cid);
            st.setInt(2, begin);
            st.setInt(3, pageMax);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                //封装商品对象
                Product p = new Product();
                p.setPid(rs.getInt("pid"));
                p.setPname(rs.getString("pname"));
                p.setPimage(rs.getString("pimage"));
                p.setMarket_price(rs.getFloat("market_price"));
                p.setShop_price(rs.getFloat("shop_price"));
                p.setPdate(rs.getDate("pdate"));
                p.setPdesc(rs.getString("pdesc"));
                p.setCid(rs.getInt("cid"));
                list.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DbUtil.closeConn();
        }
        return list;
    }

    public static int selectCountByCid(int cid) {
        Connection cn = DbUtil.getConn();
        int sum = 0;
        try {
            PreparedStatement st = cn.prepareStatement("SELECT count(*) as sum FROM product where cid=?");
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                sum = rs.getInt("sum");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.closeConn();
        }
        return sum;
    }

}
