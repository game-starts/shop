package com.mypro.dao;

import com.mypro.dbutil.DbUtil;
import com.mypro.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public static List<Category> getAllCategories() {
        String sql = "select * from category";
        Connection conn = DbUtil.getConn();
        List<Category> categories = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCid(rs.getInt("cid"));
                category.setCname(rs.getString("cname"));
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConn();
        }
        return null;
    }

    public static List<Category> getSingleCategories(int cid) {
        String sql = "select * from category where cid = ?";
        Connection conn = DbUtil.getConn();
        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                category.setCid(rs.getInt("cid"));
                category.setCname(rs.getString("cname"));
                categories.add(category);
            }
            return categories;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeConn();
        }
        return null;
    }
}
