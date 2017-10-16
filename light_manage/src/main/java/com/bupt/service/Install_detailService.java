package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Install_detail;
import com.bupt.repository.Install_detailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by mengying on 2017/9/26.
 */
@Service
@Transactional
public class Install_detailService extends BasePageService<Install_detail,String> {
    @Autowired
    private Install_detailRepository install_detailRepository;

    public void save(Install_detail entity){
        install_detailRepository.save(entity);
    }

    public Install_detail findById(String id){
        return install_detailRepository.findOne(id);
    }
    public List<Install_detail> findByInstallNumber(String installNumber){
        return install_detailRepository.findByInstallNumber(installNumber);
    }

    public void deleteById(String id){ install_detailRepository.delete(id); }

    public void  pageByHql(PageEntity<Install_detail> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from Install_detail where 1=1 ");
        if (paramaMap.containsKey("installNumber")){
            sql.append(" and installNumber =:installNumber ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }

    public List<Install_detail> findAll() {return install_detailRepository.findAll();}
}
