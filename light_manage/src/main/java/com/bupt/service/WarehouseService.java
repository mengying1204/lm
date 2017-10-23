package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;

import com.bupt.common.enums.CommodityTypeEnum;
import com.bupt.common.utils.BeanUtills;
import com.bupt.domain.Warehouse;
import com.bupt.domain.WarehouseLog;
import com.bupt.domain.WarehouseName;
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
public class WarehouseService extends BasePageService<Warehouse, String> {
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private WarehouseNameService warehouseNameService;
    @Autowired
    private WarehouseLogService warehouseLogService;

    public void save(Warehouse entity) {
        warehouseRepository.save(entity);
    }

    public Warehouse findById(String id) {
        return warehouseRepository.findOne(id);
    }

    public List<Warehouse> findByCommodityName(String commodityName) {
        return warehouseRepository.findByName(commodityName);
    }

    public void deleteById(String id) {
        warehouseRepository.delete(id);
    }

    //入库操作
    public boolean saveWarehouseAndLog(Warehouse entity) {
        List<Warehouse> list = findByCommodityName(entity.getName());
        if (list != null && !list.isEmpty()) {
            for (Warehouse warehouse : list) {
                double totalCount = warehouse.getCountDetail() + entity.getCountDetail();
                if (warehouse.getCode().equals((entity.getCode())) && warehouse.getLocation().equals(entity.getLocation())) {
                    if (totalCount > 1000.0) {
                        return false;
                    } else {
                        saveWarehouseLog(entity);
                        entity.setCountDetail(totalCount);
                        BeanUtills.copyProperties(entity, warehouse);
                        save(warehouse);
                        return true;
                    }
                } else {
                    save(entity);
                    saveWarehouseLog(entity);
                    return true;
                }
            }
        } else {
            saveWarehouseLog(entity);
            save(entity);
            return true;
        }
        return false;
    }

    public void saveWarehouseLog(Warehouse entity) {
        WarehouseLog warehouseLog = new WarehouseLog();
        warehouseLog.setCode(entity.getCode());
        warehouseLog.setCountDetail(entity.getCountDetail());
        warehouseLog.setName(entity.getName());
        warehouseLog.setType(entity.getType());
        warehouseLog.setOperator(entity.getOperator());
        warehouseLog.setOperatorNumber(entity.getOperatorNumber());
        warehouseLog.setLocation(entity.getLocation());
        warehouseLog.setRemark(entity.getRemark());
        warehouseLog.setTotalPrice(entity.getPrice() * entity.getCountDetail());
        warehouseLogService.save(warehouseLog);
    }

    //出库操作
    public boolean deleteWarehouse(Warehouse entity) {
        Warehouse warehouse = findById(entity.getId());
        if (entity.getCountDetail() < warehouse.getCountDetail()) {
            double SubCount = warehouse.getCountDetail() - entity.getCountDetail();
            warehouse.setCountDetail(SubCount);
            save(warehouse);
            entity.setPrice(warehouse.getPrice());
            saveWarehouseLog(entity);
            return true;
        } else
            return false;

    }

    public void pageByHql(PageEntity<Warehouse> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from Warehouse where 1=1 ");
        if (paramaMap.containsKey("name")) {
            sql.append(" and name =:name ");
        }
        if (paramaMap.containsKey("power")) {
            sql.append(" and power =:power ");
        }
        if (paramaMap.containsKey("price")) {
            sql.append(" and price =:price ");
        }
        if (paramaMap.containsKey("type")) {
            sql.append(" and type =:type ");
        }
        if (paramaMap.containsKey("countDetail")) {
            sql.append(" and countDetail =:countDetail ");
        }
        if (paramaMap.containsKey("code")) {
            sql.append(" and code =:code ");
        }
        if (paramaMap.containsKey("location")) {
            sql.append(" and location =:location ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
        translate(pageEntity.getResults());
    }

    @Override
    protected void translate(List<Warehouse> list) {
        super.translate(list);
        for (Warehouse warehouse : list) {
            if (StringUtils.isNotBlank(warehouse.getCode())) {
                WarehouseName warehouseName = warehouseNameService.findByCode(warehouse.getCode());
                if (warehouseName != null) {
                    warehouse.setCodeName(warehouseName.getCodeName());
                }
            }
            if (warehouse.getType() != null) {
                String typeName = CommodityTypeEnum.findByValue(warehouse.getType());
                warehouse.setTypeName(typeName);
            }
        }
    }

}
