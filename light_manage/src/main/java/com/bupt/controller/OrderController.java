package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Order;
import com.bupt.service.OrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CJ on 2017/10/9.
 */
@RestController
@RequestMapping("/maintainOrder")
public class OrderController extends BaseCommonController{
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody String data) {
        orderService.save(data);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String findByCode(@PathVariable(value = "id") String id) {
        Order maintainInput=orderService.findOne(id);
        return sendSuccessMessage(maintainInput);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String findByCode() {
        return sendSuccessMessage();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String delByCode(@PathVariable(value = "id") String id) {
        orderService.delete(id);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String delByCode() {
        return sendSuccessMessage(orderService.find());
    }

    @RequestMapping("/page")
    public String page(Order entity, int page, int size){
        int start = (page - 1) * size;
        PageEntity<Order> pageEntity = new PageEntity<>(start, size,page);
        orderService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(Order entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getMaintainNumber())){
            parameterMap.put("maintainNumber", entity.getMaintainNumber());
        }
        if (StringUtils.isNotBlank(entity.getMonitorNumber())){
            parameterMap.put("monitorNumber", entity.getMonitorNumber());
        }
        if (StringUtils.isNotBlank(entity.getMonitorName())){
            parameterMap.put("monitorName", entity.getMonitorName());
        }
        return parameterMap;
    }



}
