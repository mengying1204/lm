package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.InfoAndDetail;
import com.bupt.domain.PurchaseDetail;
import com.bupt.service.PurchaseDetailService;
import com.google.gson.Gson;
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
@RequestMapping(value="/purchaseDetail")
public class PurchaseDetailController extends BaseCommonController {
    @Autowired
    private PurchaseDetailService purchaseDetailService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody String JsonData){

        //GSON直接解析成对象
        InfoAndDetail resultBean = new Gson().fromJson(JsonData,InfoAndDetail.class);
        System.out.println(resultBean.getPurchaseManagerNumbert());
        //对象中拿到集合
        List<InfoAndDetail.PurchaseDetail> userBeanList = resultBean.getArr();
        for(int i=0;i<userBeanList.size();i++){
        String id= userBeanList.get(i).getType();
        System.out.println(id);
     }

        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody PurchaseDetail entity){
        if((StringUtils.isNotBlank(entity.getPurchaseNumber()))){
            PurchaseDetail purchaseDetail = purchaseDetailService.findOne(entity.getPurchaseNumber());
            BeanUtills.copyProperties(entity, purchaseDetail);
            purchaseDetailService.save(purchaseDetail);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String id){
        PurchaseDetail entity= purchaseDetailService.findOne(id);
         return sendMessage("true", "", entity, DateUtil.DATE);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id") String id){
        purchaseDetailService.deleteById(id);
        return sendSuccessMessage();
    }
    @RequestMapping("/page")
    public String page(PurchaseDetail entity, int page, int size) {
        int start=(page-1)*size;
        PageEntity<PurchaseDetail> pageEntity = new PageEntity<>(start,size,page);
        purchaseDetailService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(PurchaseDetail entity) {
        Map<String, Object> parameterMap = new HashMap<>();
            return parameterMap;
    }
}

