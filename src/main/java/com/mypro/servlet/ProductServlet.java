package com.mypro.servlet;

import com.google.gson.Gson;
import com.mypro.dao.CategoryDao;
import com.mypro.dao.ProductDao;
import com.mypro.entity.Category;
import com.mypro.entity.Product;
import com.mypro.to.JsonData;
import com.mypro.to.pageData;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        //每次访问servlet时 都会提交一个 optype 操作类型参数 ，由这个参数判断该servlet需要做什么操作
        String optype = request.getParameter("optype");
        if (optype.equals("index")) {
            ProductDao pd = new ProductDao();
            //为首页查询提供查询商品前9个数据
            List<Product> productList = pd.selectHotProduct();
            List<Category> categories = CategoryDao.getAllCategories();
            //封装到数据传输对象
            JsonData jsonData = new JsonData();
            jsonData.setData1(productList);
            jsonData.setData2(categories);
            Gson gson = new Gson();
            String str = gson.toJson(jsonData);
            response.getWriter().println(str);
            return;
        }
        //保存cid
        if (optype.equals("sivecid")) {
            //获取cid
            int cid = Integer.parseInt(request.getParameter("cid"));
            int page = Integer.parseInt(request.getParameter("page"));
            //绑定cid到Session
            request.getSession().setAttribute("cid", cid);
            request.getSession().setAttribute("page", page);
            request.getRequestDispatcher("/list.html").forward(request, response);
            return;
        }
        //根据cid查询对应类型商品
        if (optype.equals("queryProductByCid")) {
            ProductDao pd = new ProductDao();
            //从seesion获取cid
            int cid = (int) request.getSession().getAttribute("cid");
            System.out.println("cid: " + cid);
            //从seesion获取页数
            int page = (int) request.getSession().getAttribute("page");
            System.out.println("page:" + page);
            List<Category> categories = CategoryDao.getAllCategories();

            //设置每页显示数量
            int pageMax = 12;
            int pageSize = pd.selectCountByCid(cid);
            //分页的数量
            int pagenum = pageSize % pageMax == 0 ? pageSize / pageMax : pageSize / pageMax + 1;
            //设置上一页
            int pagepre = page - 1 == 0 ? 1 : page - 1;
            //设置下一页
            int pagenext = page + 1 == pagenum ? page : page + 1;
            //设置起始页
            int begin = (page - 1) * pageMax;

            List<Product> productList = pd.queryByCid(cid, begin, pageMax);
            //封装数据

            pageData pagedata = new pageData();
            pagedata.setPage(page);
            pagedata.setPagenum(pagenum);
            pagedata.setPagepre(pagepre);
            pagedata.setPagenext(pagenext);
            pagedata.setProduct(productList);


            //封装到数据传输对象
            JsonData jsonData = new JsonData();
            jsonData.setData1(pagedata);
            jsonData.setData2(categories);
            jsonData.setData3(cid);
            Gson gson = new Gson();
            String str = gson.toJson(jsonData);
            response.getWriter().println(str);
            return;
        }


    }
}
