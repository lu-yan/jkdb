package cn.itcast.jk.service.impl;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.SysCodeDao;
import cn.itcast.jk.domain.SysCode;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.*;

@Service
public class SysCodeServiceImpl implements SysCodeService {
    @Resource
    SysCodeDao sysCodeDao;
	
	@Override
	public List<SysCode> find(Map paraMap) {
		return sysCodeDao.find(paraMap);
	}


}
