package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Commodity;
import com.bupt.domain.Staff;
import com.bupt.repository.CommodityRepository;
import com.bupt.repository.StaffRepository;
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
public class StaffService extends BasePageService<Staff,String> {
    @Autowired
    private StaffRepository staffRepository;

    public Staff findOne(String id) {
        return staffRepository.findOne(id);
    }

    public void save(Staff entity) {
        staffRepository.save(entity);
    }

    public void deleteById(String id) {
        staffRepository.delete(id);
    }

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public void pageByHql(PageEntity<Staff> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from Staff where 1=1 ");
        if (paramaMap.containsKey("job")) {
            sql.append(" and job =:job ");
        }
        super.pageByHql(sql.toString(), pageEntity, paramaMap);

    }


}
