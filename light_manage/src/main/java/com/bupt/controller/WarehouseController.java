package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Warehouse;
import com.bupt.domain.WarehouseLog;
import com.bupt.domain.WarehouseName;
import com.bupt.service.WarehouseLogService;
import com.bupt.service.WarehouseNameService;
import com.bupt.service.WarehouseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value = "/warehouse")
public class WarehouseController extends BaseCommonController {
    @Autowired
    private WarehouseService warehouseService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody Warehouse entity) {
        boolean b = warehouseService.saveWarehouseAndLog(entity);
        if (b) {
            return sendSuccessMessage();
        } else
            return sendFailMessage();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody Warehouse entity) {
        if ((StringUtils.isNotBlank(entity.getId()))) {
            Warehouse warehouse = warehouseService.findById(entity.getId());
            BeanUtills.copyProperties(entity, warehouse);
            warehouseService.save(warehouse);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable(value = "id") String id) {
        Warehouse entity = warehouseService.findById(id);
        return sendMessage("true", "", entity, DateUtil.DATE);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public String deleteWarehouse(@RequestBody Warehouse entity) {
        boolean b = warehouseService.deleteWarehouse(entity);
        if (b) {
            return sendSuccessMessage();
        } else
            return sendFailMessage();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value = "id") String id) {
        warehouseService.deleteById(id);
        return sendSuccessMessage();
    }

    @RequestMapping("/page")
    public String page(Warehouse entity, int page, int size) {
        int start = (page - 1) * size;
        PageEntity<Warehouse> pageEntity = new PageEntity<>(start, size, page);
        warehouseService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String, Object> buildParameter(Warehouse entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getName())) {
            parameterMap.put("name", entity.getName());
        }
        if (entity.getPower() != null) {
            parameterMap.put("power", entity.getPower());
        }
        if (entity.getPrice() != null) {
            parameterMap.put("price", entity.getPrice());
        }
        if (entity.getType()!=null) {
            parameterMap.put("type", entity.getType());
        }
        if (entity.getCountDetail() != null) {
            parameterMap.put("countDetail", entity.getCountDetail());
        }
        if (StringUtils.isNotBlank(entity.getCode())) {
            parameterMap.put("code", entity.getCode());
        }
        if (StringUtils.isNotBlank(entity.getLocation())) {
            parameterMap.put("location", entity.getLocation());
        }
        return parameterMap;
    }
}

