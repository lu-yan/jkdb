package cn.itcast.jk.dao.impl;
import java.io.Serializable;
import java.util.Map;

import cn.itcast.jk.dao.*; 
import cn.itcast.jk.domain.*;

import org.springframework.stereotype.*;

@Repository
public class ContractProductDaoImpl  extends BaseDaoImpl<ContractProduct> implements ContractProductDao{
    public ContractProductDaoImpl(){
    	//设置命名空间
    	super.setNs("cn.itcast.jk.mapper.ContractProductMapper");
    }

	
	public void deleteByContractProductById(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractProductById",ids);
		
	}

	
	public void deleteByContractId(Serializable[] ids) {
		super.getSqlSession().delete(super.getNs()+".deleteByContractId",ids);
		
	}           
}
