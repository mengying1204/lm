package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Commodity;
import com.bupt.domain.PurchaseDetail;
import com.bupt.domain.PurchaseInfo;
import com.bupt.domain.PurchaseLog;
import com.bupt.repository.PurchaseInfoRepository;
import com.bupt.repository.PurchaseLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@Service
@Transactional
public class PurchaseLogService extends BasePageService<PurchaseLog, String> {
    @Autowired
    private PurchaseLogRepository purchaseLogRepository;
    @Autowired
    private PurchaseDetailService purchaseDetailService;
    @Autowired
    private CommodityService commodityService;

    public PurchaseLog findOne(String id) {
        return purchaseLogRepository.findOne(id);
    }

    public void save(PurchaseLog entity) {
        purchaseLogRepository.save(entity);
    }

    public void deleteById(String id) {
        purchaseLogRepository.delete(id);
    }

    public List<PurchaseLog> findAll() {
        return purchaseLogRepository.findAll();
    }

    public void pageByHql(PageEntity<PurchaseLog> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from PurchaseLog where 1=1 ");
        if (paramaMap.containsKey("buyerName")) {
            sql.append(" and buyerName =:buyerName ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);

    }

    public void logHandle(PurchaseLog entity) {
        List<PurchaseDetail> purchaseDetails = purchaseDetailService.findByPurchaseNumber(entity.getPurchaseNumber());
        if (purchaseDetails != null) {
            List<Commodity> commodities = commodityService.findAll();
            for (PurchaseDetail purchaseDetail : purchaseDetails) {
                boolean b = false;
                for (Commodity commodity : commodities) {
                    if (purchaseDetail.getName().equals(commodity.getName())) {
                        double count = commodity.getCount();
                        commodity.setCount(count + purchaseDetail.getCountDetail());
                        b=true;
                    }
                }
                if(b==false){
                    Commodity commodity=new Commodity();
                    commodity.setName(purchaseDetail.getName());
                    commodity.setCount(purchaseDetail.getCountDetail());
                    commodity.setPower(purchaseDetail.getPower());
                    commodity.setType(purchaseDetail.getType());
                    commodity.setPrice(purchaseDetail.getPrice());
                    commodityService.save(commodity);
                }
            }
        }
    }

}
