package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.common.enums.CommodityTypeEnum;
import com.bupt.domain.Warehouse;
import com.bupt.domain.WarehouseLog;
import com.bupt.domain.WarehouseName;
import com.bupt.repository.WarehouseLogRepository;
import com.bupt.repository.WarehouseRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@Service
@Transactional
public class WarehouseLogService extends BasePageService<WarehouseLog,String> {
    @Autowired
    private WarehouseLogRepository warehouseLogRepository;
    @Autowired
    private WarehouseNameService warehouseNameService;

    public void save(WarehouseLog entity){
        warehouseLogRepository.save(entity);
    }

    public WarehouseLog findById(String id){
        return warehouseLogRepository.findOne(id);
    }

    public void deleteById(String id){ warehouseLogRepository.delete(id); }

    public void  pageByHql(PageEntity<WarehouseLog> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from WarehouseLog where 1=1 ");
        if (paramaMap.containsKey("operator")){
            sql.append(" and operator =:operator ");
        }
        if (paramaMap.containsKey("operatorNumber")){
            sql.append(" and operatorNumber =:operatorNumber ");
        }
        if (paramaMap.containsKey("code")){
            sql.append(" and code =:code ");
        }
        if (paramaMap.containsKey("location")){
            sql.append(" and location =:location ");
        }
        if (paramaMap.containsKey("name")){
            sql.append(" and name =:name ");
        }
        if (paramaMap.containsKey("type")){
            sql.append(" and type =:type ");
        }
        if (paramaMap.containsKey("totalPrice")){
            sql.append(" and totalPrice =:totalPrice ");
        }
        if (paramaMap.containsKey("countDetail")){
            sql.append(" and countDetail =:countDetail ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }
    @Override
    protected void translate(List<WarehouseLog> list) {
        super.translate(list);
        for (WarehouseLog warehouseLog : list) {
            if(StringUtils.isNotBlank(warehouseLog.getCode())){
                WarehouseName warehouseName=warehouseNameService.findByCode(warehouseLog.getCode());
                warehouseLog.setCodeName(warehouseName.getCodeName());
            }
            if (warehouseLog.getType() != null) {
                String typeName = CommodityTypeEnum.findByValue(warehouseLog.getType());
                warehouseLog.setTypeName(typeName);
            }
        }
    }
}
