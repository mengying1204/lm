package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.domain.Commodity;
import com.bupt.repository.CommodityRepository;
import org.apache.commons.lang3.StringUtils;
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
public class CommodityService extends BasePageService<Commodity, String> {
    @Autowired
    private CommodityRepository commodityRepository;

    public Commodity findOne(String id) {
        return commodityRepository.findOne(id);
    }

    public void save(Commodity entity) {
        commodityRepository.save(entity);
    }

    public void deleteById(String id) {
        commodityRepository.delete(id);
    }

    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }

    public void pageByHql(PageEntity<Commodity> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from Commodity where 1=1 ");
        if (paramaMap.containsKey("type")) {
            sql.append(" and type =:type ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);

    }

    public boolean updateCommodity(Commodity entity) {
        if ((StringUtils.isNotBlank(entity.getId()))) {
            Commodity commodity = findOne(entity.getId());
            BeanUtills.copyProperties(entity, commodity);
            save(commodity);
            return true;
        } else {
            return false;
        }
    }
}
