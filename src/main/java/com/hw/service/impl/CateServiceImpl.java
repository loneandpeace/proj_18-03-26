package com.hw.service.impl;
import java.util.List;

import com.hw.dao.CateDaoI;
import com.hw.dao.impl.CateDaoImpl;
import com.hw.entity.Cate;
import com.hw.entity.PageModel;
import com.hw.service.CateServiceI;

public class CateServiceImpl implements CateServiceI {
	CateDaoI cateDao=new CateDaoImpl();
	@Override
	public PageModel<Cate> findAllCateService(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return cateDao.findAllCateByPage(pageNo , pageSize);
	}

	@Override
	public int addCateService(Cate cate) {
		// TODO Auto-generated method stub
		return cateDao.addCate(cate);
	}

	@Override
	public int deleteCateService(int cateid) {
		// TODO Auto-generated method stub
		return cateDao.deleteCate(cateid);
	}

	@Override
	public Cate findOneCateService(int cateid) {
		// TODO Auto-generated method stub
		return cateDao.findOneCate(cateid);
	}

	@Override
	public int updateCateService(Cate cate) {
		// TODO Auto-generated method stub
		return cateDao.updateCate(cate);
	}


	@Override
	public List<Cate> findAllCateIdService() {
		// TODO Auto-generated method stub
		//CateDaoI cateDao=CateDaoImpl.getInstance();
		return cateDao.findAllCateId();
	}

	@Override
	public PageModel<Cate> findSomeCateByInfoService(int pageNo, int pageSize, String info) {
		// TODO Auto-generated method stub
		///CateDaoI cateDao=CateDaoImpl.getInstance();
		return cateDao.findSomeCateByInfo(pageNo, pageSize, info);
	}


}
