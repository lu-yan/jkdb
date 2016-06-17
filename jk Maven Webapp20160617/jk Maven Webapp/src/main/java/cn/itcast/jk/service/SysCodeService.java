package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.itcast.jk.domain.*;
import cn.itcast.jk.pagination.Page;

public interface SysCodeService {
	public List<SysCode> find(Map paraMap);		//带条件查询，条件可以为null，既没有条件；返回list对象集合

}
