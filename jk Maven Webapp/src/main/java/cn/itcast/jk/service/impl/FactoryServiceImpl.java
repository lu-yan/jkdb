package cn.itcast.jk.service.impl;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.*;

@Service
public class FactoryServiceImpl implements FactoryService {
    @Resource
    FactoryDao factoryDao;
	
	@Override
	public List<Factory> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factory> find(Map paraMap) {
		
		return factoryDao.find(paraMap);
	}

	@Override
	public Factory get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Factory factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Factory factory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

}
