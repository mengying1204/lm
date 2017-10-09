package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.*;
import com.bupt.repository.PurchaseInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.bupt.common.utils.NumberUtills.getNumber;

/**
 * Created by Stadpole on 2017/9/21.
 */
@Service
@Transactional
public class PurchaseInfoService extends BasePageService<PurchaseInfo,String> {
    @Autowired
    private PurchaseInfoRepository purchaseInfoRepository;
    @Autowired
    private PurchaseDetailService purchaseDetailService;
    public PurchaseInfo findOne(String id) {
        return purchaseInfoRepository.findOne(id);
    }

    public void save(PurchaseInfo entity) {
               purchaseInfoRepository.save(entity);
    }

    public void deleteById(String id) {
        purchaseInfoRepository.delete(id);
    }

    public List<PurchaseInfo> findAll() {
        return purchaseInfoRepository.findAll();
    }

    public void pageByHql(PageEntity<PurchaseInfo> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from PurchaseInfo where 1=1 ");
        if (paramaMap.containsKey("purchaseManagerName")) {
            sql.append(" and purchaseManagerName =:purchaseManagerName ");
        }
        if (paramaMap.containsKey("purchaseManagerNumber")) {
            sql.append(" and purchaseManagerNumber =:purchaseManagerNumber ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
        translate(pageEntity.getResults());
    }

    @Override
    protected void translate(List<PurchaseInfo> list) {
        super.translate(list);
        for(PurchaseInfo entity:list){
            //double countZ=entity.getCountInfo();
            double priceZ=0;
            if(StringUtils.isNotBlank(entity.getPurchaseNumber())) {

                List<PurchaseDetail> purchaseDetailsList = purchaseDetailService.findByPurchaseNumber(entity.getPurchaseNumber());
                if (purchaseDetailsList != null) {
                    for (PurchaseDetail purchaseDetail : purchaseDetailsList) {
                        // countZ=countZ+purchaseDetail.getCountDetail();
                        priceZ = priceZ + purchaseDetail.getPrice() * purchaseDetail.getCountDetail();
                    }
                }
            }
          //  entity.setCountInfo(countZ);
            entity.setTotalPrice(priceZ);
        }
    }

}
