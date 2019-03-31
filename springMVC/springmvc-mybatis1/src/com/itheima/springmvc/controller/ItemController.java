package com.itheima.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.service.ItemServiceImp;

/**
 * 商品管理
 * 
 * @author lx
 *
 */
@Controller
public class ItemController {
	@Autowired
	private ItemServiceImp imp;
	//入门程序 第一   包类 + 类包 + 方法名
	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList(){
		List<Items> list = imp.selectItemsList();
		
		ModelAndView mav = new ModelAndView();
		//数据
		mav.addObject("itemList", list);//封装了request.setAttribute()
		mav.setViewName("itemList");
		return mav;
	}
	
}
