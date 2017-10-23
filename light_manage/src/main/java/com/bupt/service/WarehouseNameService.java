package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.WarehouseLog;
import com.bupt.domain.WarehouseName;
import com.bupt.repository.WarehouseLogRepository;
import com.bupt.repository.WarehouseNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@Service
@Transactional
public class WarehouseNameService extends BasePageService<WarehouseName,String> {
    @Autowired
    private WarehouseNameRepository warehouseNameRepository;

    public void save(WarehouseName entity){
        warehouseNameRepository.save(entity);
    }

    public WarehouseName findById(String id){
        return warehouseNameRepository.findOne(id);
    }

    public WarehouseName findByCode(String code){
        return warehouseNameRepository.findByCode(code);
    }

    public void deleteById(String id){ warehouseNameRepository.delete(id); }

    public void  pageByHql(PageEntity<WarehouseName> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from WarehouseName where 1=1 ");

        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }

}
