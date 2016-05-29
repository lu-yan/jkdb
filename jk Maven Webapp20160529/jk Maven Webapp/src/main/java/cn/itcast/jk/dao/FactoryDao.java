package cn.itcast.jk.dao;
import java.util.Map;

import cn.itcast.jk.domain.*;

public interface FactoryDao extends BaseDao<Factory> {
   public void updateState(Map map);
}
