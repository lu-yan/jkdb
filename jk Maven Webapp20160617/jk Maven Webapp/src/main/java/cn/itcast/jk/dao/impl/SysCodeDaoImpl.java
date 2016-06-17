package cn.itcast.jk.dao.impl;
import java.util.Map;

import cn.itcast.jk.dao.*; 
import cn.itcast.jk.domain.*;

import org.springframework.stereotype.*;

@Repository
public class SysCodeDaoImpl  extends BaseDaoImpl<SysCode> implements SysCodeDao{
    public SysCodeDaoImpl(){
    	//设置命名空间
    	super.setNs("cn.itcast.jk.mapper.SysCodeMapper");
    }
		             
}
