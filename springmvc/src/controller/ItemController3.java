package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import po.Items;

/**
 * 使用注解方式实现商品的展示
 * @author Administrator
 *
 */
@org.springframework.stereotype.Controller
public class ItemController3 {
	@RequestMapping("/queryItemsAnnotation.action")
	public ModelAndView queryItemsAnnotation() throws Exception {
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
		
		ModelAndView modelAndView=new ModelAndView();
		//相当于request.set 方法 存在域里面
		modelAndView.addObject("itemsList",itemsList);
		//指定视图
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemslist.jsp");
		//如果在视图解析里配置了前后缀，上面的路径可写为如下格式
		modelAndView.setViewName("items/itemslist");
		return modelAndView;
	}

}