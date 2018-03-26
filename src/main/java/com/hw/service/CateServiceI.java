package com.hw.service;

import java.util.List;

import com.hw.entity.Cate;
import com.hw.entity.PageModel;

public interface CateServiceI {
	public PageModel<Cate> findAllCateService(int pageNo,int pageSize);
	public int addCateService(Cate cate);
	public int deleteCateService(int cateid);
	public Cate findOneCateService(int cateid);
	public int updateCateService(Cate cate);
	public List<Cate> findAllCateIdService();
	public PageModel<Cate> findSomeCateByInfoService(int pageNo,int pageSize,String info);
}
