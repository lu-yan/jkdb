package cn.itcast.jk.dao.impl;
import java.util.Map;

import cn.itcast.jk.dao.*; 
import cn.itcast.jk.domain.*;

import org.springframework.stereotype.*;

@Repository
public class FactoryDaoImpl  extends BaseDaoImpl<Factory> implements FactoryDao{
    public FactoryDaoImpl(){
    	//设置命名空间
    	super.setNs("cn.itcast.jk.mapper.FactoryMapper");
    }

	@Override
	public void updateState(Map map) {
	    super.getSqlSession().update(super.getNs()+".updateState",map);
		
	}              
}
