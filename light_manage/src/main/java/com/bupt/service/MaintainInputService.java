package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.MaintainInput;
import com.bupt.repository.MaintainInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by CJ on 2017/9/21.
 */
@Service
public class MaintainInputService extends BasePageService<MaintainInput,String> {
    @Autowired
    MaintainInputRepository maintainInputRepository;

    public void save(MaintainInput maintainInput){
        maintainInputRepository.save(maintainInput);
    }

    public MaintainInput findById(String id){
       return maintainInputRepository.findOne(id);
    }
    public void delete(String id){
        maintainInputRepository.delete(id);
    }


    public void pageByHql(PageEntity<MaintainInput> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from MaintainInput where 1=1 ");
        if (paramaMap.containsKey("maintainNumber")){
            sql.append(" and maintainNumber =:maintainNumber ");
        }
        if (paramaMap.containsKey("maintainerName")){
            sql.append(" and maintainName =:maintainerName ");
        }
        if (paramaMap.containsKey("maintainerNumber")){
            sql.append(" and maintainerNumber =:maintainerNumber ");
        }
        if (paramaMap.containsKey("inputName")){
            sql.append(" and inputName =:inputName ");
        }
        if (paramaMap.containsKey("inputNumber")){
            sql.append(" and inputNumber =:inputNumber ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }
}
