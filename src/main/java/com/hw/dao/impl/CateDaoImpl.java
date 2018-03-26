package com.hw.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.hw.common.MybatisUtils;
import com.hw.dao.CateDaoI;
import com.hw.entity.Cart;
import com.hw.entity.Cate;
import com.hw.entity.PageModel;

public class CateDaoImpl implements CateDaoI {

	@Override
	public PageModel<Cate> findAllCateByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		
		int offset=(pageNo-1)*pageSize;
		PageModel<Cate> pageModel=new PageModel<Cate>();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		List<Cate> list=sqlSession.selectList("com.hw.entity.Cate.findAllCateByPage", map);
		int totalCount=sqlSession.selectOne("com.hw.entity.Cate.findTotalCount", pageSize);
		pageModel.setData(list);
		
		int tp=(totalCount%pageSize)==0?(totalCount/pageSize):(totalCount/pageSize+1);
		pageModel.setTotalCount(tp);
		
		sqlSession.close();
		return pageModel;
	}

	@Override
	public int addCate(Cate cate) {
		// TODO Auto-generated method stub
		
		Map<String,Object> map=new HashMap<String,Object>();
		int parent_id=cate.getParent_id();
		String name=cate.getName();
		int status=cate.getStatus();
		int sort_order=cate.getSort_order();
		map.put("parent_id", parent_id);
		map.put("name", name);
		map.put("status", status);
		map.put("sort_order", sort_order);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		//sqlSession=sqlMapper.openSession();
		sqlSession=sqlMapper.openSession(false);
		int res=sqlSession.insert("com.hw.entity.Cate.addCate", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
		
	}

	@Override
	public int deleteCate(int cateid) {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		//sqlSession=sqlMapper.openSession();
		sqlSession=sqlMapper.openSession(false);
		int res=sqlSession.update("com.hw.entity.Cate.deleteCate", cateid);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public Cate findOneCate(int cateid) {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		Cate cate=sqlSession.selectOne("com.hw.entity.Cate.findOneCate", cateid);
		sqlSession.close();
		if(cate!=null) {
			return cate;
		}else {
			return null;
		}
	}

	@Override
	public int updateCate(Cate cate) {
		// TODO Auto-generated method stub
		
		Map<String,Object> map=new HashMap<String,Object>();
		int parent_id=cate.getParent_id();
		String name=cate.getName();
		int status=cate.getStatus();
		int sort_order=cate.getSort_order();
		int id=cate.getId();
		map.put("parent_id", parent_id);
		map.put("name", name);
		map.put("status", status);
		map.put("sort_order", sort_order);
		map.put("id", id);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		//sqlSession=sqlMapper.openSession();
		sqlSession=sqlMapper.openSession(false);
		int res=sqlSession.update("com.hw.entity.Cate.updateCate", map);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}

	@Override
	public List<Cate> findAllCateId() {
		// TODO Auto-generated method stub
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		List<Cate> cate=sqlSession.selectList("com.hw.entity.Cate.findAllCateId");
		sqlSession.commit();
		sqlSession.close();
		return cate;
	}

	@Override
	public PageModel<Cate> findSomeCateByInfo(int pageNo, int pageSize, String info) {
		// TODO Auto-generated method stub
		System.out.println("²éÑ¯¿ªÊ¼");
		String infor="%"+info+"%";
		int offset=(pageNo-1)*pageSize;
		PageModel<Cate> pageModel=new PageModel<Cate>();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("offset", offset);
		map.put("pageSize", pageSize);
		map.put("infor", infor);
		SqlSession sqlSession;
		SqlSessionFactory sqlMapper=MybatisUtils.getSqlSessionFactory();
		sqlSession=sqlMapper.openSession();
		int totalCount=sqlSession.selectOne("com.hw.entity.Cate.countSomeCateByInfo", infor);
		List<Cate> list=sqlSession.selectList("com.hw.entity.Cate.findSomeCateByInfo", map);
		int tp=(totalCount%pageSize)==0?(totalCount/pageSize):(totalCount/pageSize+1);
		pageModel.setData(list);
		pageModel.setTotalCount(tp);
		sqlSession.close();
		return pageModel;
		
	}

	

}
