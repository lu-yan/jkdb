package cn.itcast.jk.dao.impl;
import cn.itcast.jk.dao.*; 
import cn.itcast.jk.domain.*;
import org.springframework.stereotype.*;

@Repository
public class FactoryDaoImpl  extends BaseDaoImpl<Factory> implements FactoryDao{

	
    public FactoryDaoImpl(){
    	super.setNs("cn.itcast.jk.mapper.FactoryMapper");
    }
}
