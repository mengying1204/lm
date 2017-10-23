package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.PurchaseInfo;
import com.bupt.repository.PurchaseInfoRepository;
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
public class PurchaseInfoService extends BasePageService<PurchaseInfo,String> {
    @Autowired
    private PurchaseInfoRepository purchaseInfoRepository;

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
        if (paramaMap.containsKey("type")) {
            sql.append(" and type =:type ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);

    }


}
