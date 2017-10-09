package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.PurchaseInfo;
import com.bupt.service.PurchaseInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value="/purchaseInfo")
public class PurchaseInfoController extends BaseCommonController {
    @Autowired
    private PurchaseInfoService purchaseInfoService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody PurchaseInfo entity){
        purchaseInfoService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody PurchaseInfo entity){
        if((StringUtils.isNotBlank(entity.getPurchaseNumber()))){
            PurchaseInfo purchaseInfo = purchaseInfoService.findOne(entity.getPurchaseNumber());
            BeanUtills.copyProperties(entity, purchaseInfo);
            purchaseInfoService.save(purchaseInfo);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String id){
        PurchaseInfo entity= purchaseInfoService.findOne(id);
         return sendMessage("true", "", entity, DateUtil.DATE);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id") String id){
        purchaseInfoService.deleteById(id);
        return sendSuccessMessage();
    }
    //查询采购单，里面有总价和总数量
    @RequestMapping("/page")
    public String page(PurchaseInfo entity, int page, int size) {
        int start=(page-1)*size;
        PageEntity<PurchaseInfo> pageEntity = new PageEntity<>(start,size,page);
        purchaseInfoService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(PurchaseInfo entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getPurchaseManagerName())){
            parameterMap.put("purchaseManagerName", entity.getPurchaseManagerName());
        }
        if (entity.getPurchaseManagerNumber()!=null){
            parameterMap.put("purchaseManagerNumber", entity.getPurchaseManagerNumber());
        }
            return parameterMap;
    }
}

