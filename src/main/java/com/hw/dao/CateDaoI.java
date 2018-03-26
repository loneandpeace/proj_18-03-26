package com.hw.dao;

import java.util.List;

import com.hw.entity.Cate;
import com.hw.entity.PageModel;

public interface CateDaoI {
	public PageModel<Cate> findAllCateByPage(int pageNo,int pageSize);
	public int addCate(Cate cate);
	public int deleteCate(int cateid);
	public Cate findOneCate(int cateid);
	public int updateCate(Cate cate);
	public List<Cate> findAllCateId();
	public PageModel<Cate> findSomeCateByInfo(int pageNo,int pageSize,String info);
	
}
