package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.PurchaseInfo;
import com.bupt.domain.WarehouseName;
import com.bupt.service.PurchaseInfoService;
import com.bupt.service.WarehouseNameService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value="/warehouseName")
public class WarehouseNameController extends BaseCommonController {
    @Autowired
    private WarehouseNameService warehouseNameService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody WarehouseName entity){
        warehouseNameService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody WarehouseName entity){
        if((StringUtils.isNotBlank(entity.getId()))){
            WarehouseName warehouseName = warehouseNameService.findById(entity.getId());
            BeanUtills.copyProperties(entity, warehouseName);
            warehouseNameService.save(warehouseName);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String id){
        WarehouseName entity= warehouseNameService.findById(id);
         return sendMessage("true", "", entity, DateUtil.DATE);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id") String id){
        warehouseNameService.deleteById(id);
        return sendSuccessMessage();
    }
    //查询采购单，里面有总价和总数量
    @RequestMapping("/page")
    public String page(PurchaseInfo entity, int page, int size) {
        int start=(page-1)*size;
        PageEntity<WarehouseName> pageEntity = new PageEntity<>(start,size,page);
        warehouseNameService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(PurchaseInfo entity) {
        Map<String, Object> parameterMap = new HashMap<>();

            return parameterMap;
    }
}

