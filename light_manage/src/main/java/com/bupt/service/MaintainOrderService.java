package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.MaintainOrder;
import com.bupt.repository.MaintainOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by CJ on 2017/9/28.
 */
@Service
public class MaintainOrderService extends BasePageService<MaintainOrder,String> {
    @Autowired
    MaintainOrderRepository maintainOrderRepository;

    public void save(MaintainOrder maintainOrder){
        maintainOrderRepository.save(maintainOrder);
    }
    public MaintainOrder findOne(String id){
       return maintainOrderRepository.findOne(id);
    }

    public void  pageByHql(PageEntity<MaintainOrder> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from MaintainOrder where 1=1 ");
        if (paramaMap.containsKey("maintainNumber")){
            sql.append(" and maintainNumber =:maintainNumber ");
        }
        if (paramaMap.containsKey("monitorName")){
            sql.append(" and monitorName =:monitorName ");
        }
        if (paramaMap.containsKey("monitorNumber")){
            sql.append(" and monitorNumber =:monitorNumber ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }

    public void deleteById(String id) {
        maintainOrderRepository.delete(id);
    }
}
