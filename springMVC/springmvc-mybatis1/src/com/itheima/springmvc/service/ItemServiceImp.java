package com.itheima.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.springmvc.dao.ItemsMapper;
import com.itheima.springmvc.pojo.Items;
@Service
public class ItemServiceImp implements ItemService {
	@Autowired
	private ItemsMapper itemsMapper;
	
	public List<Items> selectItemsList() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}



	
}
