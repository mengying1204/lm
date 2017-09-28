package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.PurchaseDetail;
import com.bupt.domain.PurchaseInfo;
import com.bupt.repository.PurchaseDetailRepository;
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
public class PurchaseDetailService extends BasePageService<PurchaseInfo,String> {
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

    public void pageByHql(PageEntity<PurchaseDetail> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from PurchaseDetail where 1=1 ");

        super.pageByHql(sql.toString(), pageEntity, paramaMap);

    }


}
