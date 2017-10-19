package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Commodity;
import com.bupt.service.CommodityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value="/commodity")
public class CommodityController extends BaseCommonController {
    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody Commodity entity){
        commodityService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody Commodity entity){
        boolean b=commodityService.updateCommodity(entity);
        if(b){return sendSuccessMessage();}
        else {return  sendFailMessage();}
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String id){
        Commodity entity= commodityService.findOne(id);
         return sendMessage("true", "", entity, DateUtil.DATE);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id") String id){
        commodityService.deleteById(id);
        return sendSuccessMessage();
    }
    @RequestMapping("/page")
    public String page( Commodity entity,int page,int size) {
        int start=(page-1)*size;
        PageEntity<Commodity> pageEntity = new PageEntity<>(start,size,page);
        commodityService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(Commodity entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (entity.getType()!=null){
            parameterMap.put("type", entity.getType());
        }
        if (StringUtils.isNotEmpty(entity.getName())){
            parameterMap.put("name", entity.getName());
        }
        if (entity.getPower()!=null){
            parameterMap.put("power", entity.getPower());
        }
        if (entity.getPrice()!=null){
            parameterMap.put("price", entity.getPrice());
        }
        return parameterMap;
    }
}

