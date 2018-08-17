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
 * ʹ��ע�ⷽʽʵ����Ʒ��չʾ
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
		items2.setName("huipu�ʼǱ�");
		items2.setPrice(2000f);
		items2.setCreatetime(new Date());
		
		itemsList.add(items1);
		itemsList.add(items2);
		
		ModelAndView modelAndView=new ModelAndView();
		//�൱��request.set ���� ����������
		modelAndView.addObject("itemsList",itemsList);
		//ָ����ͼ
		//modelAndView.setViewName("/WEB-INF/jsp/items/itemslist.jsp");
		//�������ͼ������������ǰ��׺�������·����дΪ���¸�ʽ
		modelAndView.setViewName("items/itemslist");
		return modelAndView;
	}

}