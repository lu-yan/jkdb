package cn.itcast.jk.dao;
import java.io.Serializable;
import java.util.Map;

import cn.itcast.jk.domain.*;

public interface ExtCproductDao extends BaseDao<ExtCproduct> {
	public void 	deleteByContractProductById(Serializable[] ids);
	public void 	deleteByContractId(Serializable[] contractIds);
}
