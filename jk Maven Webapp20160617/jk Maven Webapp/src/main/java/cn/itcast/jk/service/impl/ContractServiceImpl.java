package cn.itcast.jk.service.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.dao.ExtCproductDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.*;
import cn.itcast.jk.vo.ContractVO;

@Service
public class ContractServiceImpl implements ContractService {
    @Resource
    ContractDao contractDao;
    @Resource
    ContractProductDao contractProductDao;
    @Resource
    ExtCproductDao extCproductDao;
    
    @Override
	public List<Contract> findPage(Page page) {
		//return null;
		return contractDao.findPage(page);
	}

	@Override
	public List<Contract> find(Map paraMap) {
		return contractDao.find(paraMap);
	}

	@Override
	public Contract get(Serializable id) {
		// TODO Auto-generated method stub
		return contractDao.get(id);
	}


	public void insert(Contract contract) {
		contract.setId(UUID.randomUUID().toString());//设置UUDI
		contract.setState(0);                      //0草稿1上报
		contractDao.insert(contract);
		
	}

	@Override
	public void update(Contract contract) {
		contractDao.update(contract);
		
	}
	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids = {id};
		extCproductDao.deleteByContractId(ids);   //删除当前这些合同下的附件信息
		contractProductDao.deleteByContractId(ids);   //删除当前这些合同下的货物信息
		contractDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.deleteByContractId(ids);   //删除当前这些合同下的附件信息
		contractProductDao.deleteByContractId(ids);//删除当前这些合同下的货物信息
		contractDao.delete(ids);
	}
    
	@Override
	public void submit(Serializable[] ids) {
		 Map map = new HashMap();
		   map.put("state", 1);
		   map.put("ids",ids);
		   contractDao.updateState(map);
		
	}

	@Override
	public void cancel(Serializable[] ids) {
		 Map map = new HashMap();
		   map.put("state", 0);
		   map.put("ids",ids);
		   contractDao.updateState(map);
		
	}

	@Override
	public ContractVO view(String contractId) {
		return contractDao.view(contractId);
	}

	

}
