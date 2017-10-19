package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.PurchaseInfo;
import com.bupt.domain.WarehouseLog;
import com.bupt.service.WarehouseLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value="/warehouseLog")
public class WarehouseLogController extends BaseCommonController {
    @Autowired
    private WarehouseLogService warehouseLogService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody WarehouseLog entity){
        warehouseLogService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody WarehouseLog entity){
        if((StringUtils.isNotBlank(entity.getId()))){
            WarehouseLog warehouseLog = warehouseLogService.findById(entity.getId());
            BeanUtills.copyProperties(entity, warehouseLog);
            warehouseLogService.save(warehouseLog);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String id){
        WarehouseLog entity= warehouseLogService.findById(id);
         return sendMessage("true", "", entity, DateUtil.DATE);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id") String id){
        warehouseLogService.deleteById(id);
        return sendSuccessMessage();
    }

    @RequestMapping("/page")
    public String page(WarehouseLog entity, int page, int size) {
        int start=(page-1)*size;
        PageEntity<WarehouseLog> pageEntity = new PageEntity<>(start,size,page);
        warehouseLogService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(WarehouseLog entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getCode())){
            parameterMap.put("code", entity.getCode());
        }
        if (StringUtils.isNotBlank(entity.getOperator())){
            parameterMap.put("operator", entity.getOperator());
        }
        if (StringUtils.isNotBlank(entity.getOperatorNumber())){
            parameterMap.put("operatorNumber", entity.getOperatorNumber());
        }
        if (StringUtils.isNotBlank(entity.getLocation())){
            parameterMap.put("location", entity.getLocation());
        }
        if (StringUtils.isNotBlank(entity.getName())){
            parameterMap.put("name", entity.getName());
        }
        if (entity.getType()!=null){
            parameterMap.put("type", entity.getType());
        }
        if (entity.getTotalPrice()!=null){
            parameterMap.put("totalPrice", entity.getTotalPrice());
        }
        if (entity.getCountDetail()!=null){
            parameterMap.put("countDetail", entity.getCountDetail());
        }
            return parameterMap;
    }
}

