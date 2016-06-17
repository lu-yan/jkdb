package cn.itcast.jk.service.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.dao.ExtCproductDao;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.*;
import cn.itcast.util.UtilFuns;

@Service
public class ContractProductServiceImpl implements ContractProductService {
    @Resource
    ContractProductDao contractProductDao;
	
    @Resource
    ExtCproductDao extCproductDao;
    
	@Override
	public List<ContractProduct> findPage(Page page) {	
		//return null;
		return contractProductDao.findPage(page);
	}

	@Override
	public List<ContractProduct> find(Map paraMap) {
		return contractProductDao.find(paraMap);
	}

	@Override
	public ContractProduct get(Serializable id) {
			return contractProductDao.get(id);
	}


	public void insert(ContractProduct contractProduct) {
		contractProduct.setId(UUID.randomUUID().toString());//设置UUDI
		//自动计算总金额=数量*单价
		if(UtilFuns.isNotEmpty(contractProduct.getCnumber()) && UtilFuns.isNotEmpty(contractProduct.getPrice()) ){
		contractProduct.setAmount(contractProduct.getCnumber()*contractProduct.getPrice());    
		}
		contractProductDao.insert(contractProduct);
		
	}

	@Override
	public void update(ContractProduct contractProduct) {
		contractProductDao.update(contractProduct);
		
	}

	

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.deleteByContractProductById(ids);     //删除当前这些货物下的所有附件
		contractProductDao.delete(ids);
		
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[]  ids = {id};
		extCproductDao.deleteByContractProductById(ids);     //删除当前这些货物下的所有附件
		contractProductDao.deleteById(id);
		
	}


	

}
