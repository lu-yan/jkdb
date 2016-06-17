package cn.itcast.jk.dao;
import java.io.Serializable;
import java.util.Map;

import cn.itcast.jk.domain.*;

public interface ContractProductDao extends BaseDao<ContractProduct> {
  public void 	deleteByContractProductById(Serializable[] ids);
  public void 	deleteByContractId(Serializable[] ids);
}
