package cn.itcast.jk.dao.impl;
import java.util.Map;

import cn.itcast.jk.dao.*; 
import cn.itcast.jk.domain.*;
import cn.itcast.jk.vo.ContractVO;

import org.springframework.stereotype.*;

@Repository
public class ContractDaoImpl  extends BaseDaoImpl<Contract> implements ContractDao{
    public ContractDaoImpl(){
    	//设置命名空间
    	super.setNs("cn.itcast.jk.mapper.ContractMapper");
    }


	public void updateState(Map map) {
	    super.getSqlSession().update(super.getNs()+".updateState",map);
		
	}


	public ContractVO view(String contractId) {
		
		return   super.getSqlSession().selectOne(super.getNs()+".view",contractId);
	}              
}
