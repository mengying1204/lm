package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
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
public class PurchaseLogService extends BasePageService<PurchaseLog,String> {
    @Autowired
    private PurchaseLogRepository purchaseLogRepository;

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


}
