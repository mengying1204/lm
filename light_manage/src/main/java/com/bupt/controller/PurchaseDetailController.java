package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Commodity;
import com.bupt.domain.InfoAndDetail;
import com.bupt.domain.PurchaseDetail;
import com.bupt.domain.PurchaseInfo;
import com.bupt.service.CommodityService;
import com.bupt.service.PurchaseDetailService;
import com.bupt.service.PurchaseInfoService;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bupt.common.utils.NumberUtills.getNumber;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value="/purchaseDetail")
public class PurchaseDetailController extends BaseCommonController {
    @Autowired
    private PurchaseDetailService purchaseDetailService;
    @Autowired
    private PurchaseInfoService purchaseInfoService;
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody String JsonData){
        //urchaseDetailService.PurchaseHandle(JsonData);
        PurchaseInfo purchaseInfo = new PurchaseInfo();
        String number = getNumber();
        double totalcount = 0;
        //GSON直接解析成对象
        InfoAndDetail resultBean = new Gson().fromJson(JsonData, InfoAndDetail.class);
        purchaseInfo.setPurchaseManagerNumber(resultBean.getPurchaseManagerNumber());
        purchaseInfo.setPurchaseManagerName(resultBean.getPurchaseManagerName());
        purchaseInfo.setPurchaseNumber(number);
        //对象中拿到集合
        List<InfoAndDetail.PurchaseDetail> userBeanList = resultBean.getArr();

        for (InfoAndDetail.PurchaseDetail infoPurchaseDetail : userBeanList) {
            double countDetail = infoPurchaseDetail.getCountDetail();
            totalcount = countDetail + totalcount;
            PurchaseDetail purchaseDetail = new PurchaseDetail();
            purchaseDetail.setName(infoPurchaseDetail.getName());
            purchaseDetail.setPower(infoPurchaseDetail.getPower());
            purchaseDetail.setPrice(infoPurchaseDetail.getPrice());
            purchaseDetail.setType(infoPurchaseDetail.getType());
            purchaseDetail.setCountDetail(countDetail);
            purchaseDetail.setPurchaseNumber(number);
            purchaseDetailService.save(purchaseDetail);
        }
        purchaseInfo.setTotalCount(totalcount);
        purchaseInfoService.save(purchaseInfo);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody PurchaseDetail entity){
       boolean b= purchaseDetailService.updatePurchaseDetail(entity);
       if(b){
           return sendSuccessMessage();
       }
       else {
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
    //查看商品详情
    @RequestMapping("/page")
    public String page(PurchaseDetail entity, int page, int size) {
        int start=(page-1)*size;
        PageEntity<PurchaseDetail> pageEntity = new PageEntity<>(start,size,page);
        purchaseDetailService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(PurchaseDetail entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getPurchaseNumber())){
            parameterMap.put("purchaseNumber", entity.getPurchaseNumber());
        }
            return parameterMap;
    }
}

