package cn.itcast.jk.service.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.*;
import cn.itcast.jk.domain.*;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.*;
import cn.itcast.util.UtilFuns;

@Service 
public class ExtCproductServiceImpl implements ExtCproductService {
    @Resource
    ExtCproductDao extCproductDao;
	
    @Resource
    SysCodeDao sysCodeDao;
    
	@Override
	public List<ExtCproduct> findPage(Page page) {	
		//return null;
		return extCproductDao.findPage(page);
	}

	@Override
	public List<ExtCproduct> find(Map paraMap) {
		return extCproductDao.find(paraMap);
	}

	@Override
	public ExtCproduct get(Serializable id) {
			return extCproductDao.get(id);
	}


	public void insert(ExtCproduct extCproduct) {
		extCproduct.setId(UUID.randomUUID().toString());//设置UUDI
		//自动计算总金额=数量*单价
		if(UtilFuns.isNotEmpty(extCproduct.getCnumber()) && UtilFuns.isNotEmpty(extCproduct.getPrice()) ){
			extCproduct.setAmount(extCproduct.getCnumber()*extCproduct.getPrice());    
		}
		extCproductDao.insert(extCproduct);
		
	}

	@Override
	public void update(ExtCproduct extCproduct) {
		extCproductDao.update(extCproduct);
		
	}

	

	@Override
	public void delete(Serializable[] ids) {
		extCproductDao.delete(ids);
		
	}

	@Override
	public void deleteById(Serializable id) {
		extCproductDao.deleteById(id);
		
	}

	@Override
	public List<SysCode> getCtypeList() {
		Map paraMap = new HashMap();
		paraMap.put("parentId", "0104");
		return sysCodeDao.find(paraMap);
	}


	

}
