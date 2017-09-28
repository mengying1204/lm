package com.bupt.controller;

import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.domain.MaintainOrder;
import com.bupt.service.MaintainOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

import static com.bupt.common.utils.MessageUtil.sendFailMessage;
import static com.bupt.common.utils.MessageUtil.sendSuccessMessage;

/**
 * Created by CJ on 2017/9/28.
 */
@Controller
@RequestMapping("/maintainOrder")
public class MantainOrderController {
    @Autowired
    MaintainOrderService maintainOrderService;
    
    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody MaintainOrder entity) {
        maintainOrderService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String update(@RequestBody MaintainOrder entity) {
        if (StringUtils.isNotBlank(entity.getMaintainNumber())){
            MaintainOrder MaintainOrder = maintainOrderService.findOne(entity.getMaintainNumber());
            BeanUtills.copyProperties(entity,MaintainOrder);
            maintainOrderService.save(MaintainOrder);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") String id){
        MaintainOrder maintainOrder = maintainOrderService.findOne(id);
       // System.out.println(maintainOrder.toString());

        //return id;
        return sendSuccessMessage("ok");
    }

    @RequestMapping("/page")
    public String page(MaintainOrder entity,int page,int size){
        int start = (page - 1) * size;
        PageEntity<MaintainOrder> pageEntity = new PageEntity<>(start, size,page);
        maintainOrderService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(MaintainOrder entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getMaintainNumber())){
            parameterMap.put("maintainNumber", entity.getMaintainNumber());
        }
        if (StringUtils.isNotBlank(entity.getMonitorName())){
            parameterMap.put("monitorName", entity.getMonitorName());
        }
        if (StringUtils.isNotBlank(entity.getMonitorNumber())){
            parameterMap.put("monitorNumber", entity.getMonitorNumber());
        }
        return parameterMap;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String id) {
        maintainOrderService.deleteById(id);
        return sendSuccessMessage();
    }
}
