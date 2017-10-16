package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.domain.InfoAndDetail;
import com.bupt.domain.PurchaseDetail;
import com.bupt.domain.PurchaseInfo;
import com.bupt.repository.PurchaseDetailRepository;
import com.bupt.repository.PurchaseInfoRepository;
import com.google.gson.Gson;
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
public class PurchaseDetailService extends BasePageService<PurchaseInfo, String> {
    @Autowired
    private PurchaseDetailRepository purchaseDetailRepository;


    public PurchaseDetail findOne(String id) {
        return purchaseDetailRepository.findOne(id);
    }

    public void save(PurchaseDetail entity) {
        purchaseDetailRepository.save(entity);
    }

    public void deleteById(String id) {
        purchaseDetailRepository.delete(id);
    }

    public List<PurchaseDetail> findAll() {
        return purchaseDetailRepository.findAll();
    }

    public List<PurchaseDetail> findByPurchaseNumber(String purchaseNumber) {
        return purchaseDetailRepository.findByPurchaseNumber(purchaseNumber);
    }

    public void pageByHql(PageEntity<PurchaseDetail> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from PurchaseDetail where 1=1 ");
        if (paramaMap.containsKey("purchaseNumber")) {
            sql.append(" and purchaseNumber =:purchaseNumber ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);

    }
    public boolean updatePurchaseDetail(PurchaseDetail entity){
        if(StringUtils.isNotBlank(entity.getId())){
            PurchaseDetail purchaseDetail = findOne(entity.getId());
            BeanUtills.copyProperties(entity, purchaseDetail);
            save(purchaseDetail);
           return true;
        }else {
            return false;
        }
    }

    /*public void PurchaseHandle(String JsonData) {

    }*/
}
