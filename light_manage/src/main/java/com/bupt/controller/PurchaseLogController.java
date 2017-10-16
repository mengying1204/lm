package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Commodity;
import com.bupt.domain.PurchaseDetail;
import com.bupt.domain.PurchaseInfo;
import com.bupt.domain.PurchaseLog;
import com.bupt.service.PurchaseDetailService;
import com.bupt.service.PurchaseInfoService;
import com.bupt.service.PurchaseLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value="/purchaseLog")
public class PurchaseLogController extends BaseCommonController {
    @Autowired
    private PurchaseLogService purchaseLogService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody PurchaseLog entity){
        purchaseLogService.logHandle(entity);
        purchaseLogService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody PurchaseLog entity){
        if((StringUtils.isNotBlank(entity.getId()))){
            PurchaseLog purchaseLog = purchaseLogService.findOne(entity.getId());
            BeanUtills.copyProperties(entity, purchaseLog);
            purchaseLogService.save(purchaseLog);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String id){
        PurchaseLog entity= purchaseLogService.findOne(id);
         return sendMessage("true", "", entity, DateUtil.DATE);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id") String id){
        purchaseLogService.deleteById(id);
        return sendSuccessMessage();
    }
    @RequestMapping("/page")
    public String page(PurchaseLog entity, int page, int size) {
        int start=(page-1)*size;
        PageEntity<PurchaseLog> pageEntity = new PageEntity<>(start,size,page);
        purchaseLogService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(PurchaseLog entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getBuyerName())){
            parameterMap.put("buyerName", entity.getBuyerName());
        }
        if (StringUtils.isNotBlank(entity.getBuyerNumber())){
            parameterMap.put("buyerNumber", entity.getBuyerNumber());
        }
        if (StringUtils.isNotBlank(entity.getPurchaseNumber())){
            parameterMap.put("purchaseNumber", entity.getPurchaseNumber());
        }
        if (StringUtils.isNotBlank(entity.getRecorderName())){
            parameterMap.put("recorderName", entity.getRecorderName());
        }
        if (StringUtils.isNotBlank(entity.getRecorderNumber())){
            parameterMap.put("recorderNumber", entity.getRecorderNumber());
        }
        return parameterMap;
    }
}

