package cn.itcast.jk.dao.impl;
import java.io.Serializable;
import java.util.Map;

import cn.itcast.jk.dao.*; 
import cn.itcast.jk.domain.*;

import org.springframework.stereotype.*;

@Repository
public class ExtCproductDaoImpl  extends BaseDaoImpl<ExtCproduct> implements ExtCproductDao{
    public ExtCproductDaoImpl(){
    	//设置命名空间
    	super.setNs("cn.itcast.jk.mapper.ExtCproductMapper");
    }

    
	public void deleteByContractProductById(Serializable[] ids) {
		super.getSqlSession().delete(getNs()+".deleteByContractProductById",ids);
		
	}

	  
		public void deleteByContractId(Serializable[] contractIds) {
			super.getSqlSession().delete(getNs()+".deleteByContractId",contractIds);
			
		}
             
}
