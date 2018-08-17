package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import po.Items;

//实现controller接口的方法  查询商品列表
public class ItemController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
		List<Items> itemsList=new ArrayList<Items>();
		Items items1=new Items();
		items1.setDetail("expensive");
		items1.setName("lemon");
		items1.setPrice(2000f);
		items1.setCreatetime(new Date());
		
		
		Items items2=new Items();
		items2.setDetail("cheap");
		items2.setName("huipu笔记本");
		items2.setPrice(2000f);
		items2.setCreatetime(new Date());
		
		itemsList.add(items1);
		itemsList.add(items2);
		
		reqeust.setAttribute("itemsList",itemsList);
		
		reqeust.getRequestDispatcher("/WEB-INF/jsp/items/itemslist.jsp").forward(reqeust, response);

	}

}
