package cn.itcast.jk.service.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
		return factoryDao.get(id);
	}


	public void insert(Factory factory) {
		
		factory.setId(UUID.randomUUID().toString());//设置UUDI
		factory.setState("1");                      //设置默认启动状态
		factoryDao.insert(factory);
		
	}

	@Override
	public void update(Factory factory) {
		factoryDao.update(factory);
		
	}

	@Override
	public void deleteById(Serializable id) {
		factoryDao.deleteById(id);
		
	}

	@Override
	public void delete(Serializable[] ids) {
		factoryDao.delete(ids);
		
	}

	@Override
	public void start(Serializable[] ids) {
	   Map map = new HashMap();
	   map.put("state", 1);
	   map.put("ids",ids);
	   factoryDao.updateState(map);
		
	}

	@Override
	public void stop(Serializable[] ids) {
		   Map map = new HashMap();
		   map.put("state", 0);
		   map.put("ids",ids);
		   factoryDao.updateState(map);
		
	}

}
