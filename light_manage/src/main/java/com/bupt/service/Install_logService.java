package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.domain.Install_detail;
import com.bupt.domain.Install_log;
import com.bupt.domain.Light;
import com.bupt.domain.Switch;
import com.bupt.repository.Install_logRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by mengying on 2017/9/21.
 */
@Service
@Transactional
public class Install_logService extends BasePageService<Install_log,String> {
    @Autowired
    private Install_logRepository install_logRepository;
    @Autowired
    private Install_detailService install_detailService;
    @Autowired
    private LightService lightService;
    @Autowired
    private SwitchService switchService;

    public void save(Install_log entity){
        install_logRepository.save(entity);
        String installNumber = entity.getInstallNumber();
        List<Install_detail> result = install_detailService.findByInstallNumber(installNumber);
        for(int i=0;i< result.size();i++) {
            Install_detail install_detail = result.get(i);
            String type = install_detail.getType();
            System.out.println(type);
            if (type.equals("0") ) {
                Light light = new Light();
                light.setLightNumber(install_detail.getGoodsNumber());
                light.setLightName(install_detail.getGoodsName());
                light.setLocation(install_detail.getLocation());
                light.setSwitchNumber(install_detail.getSwitchNumber());
                light.setState("0");
                lightService.save(light);
            }else {
                Switch s = new Switch();
                s.setSwitchNumber(install_detail.getGoodsNumber());
                s.setSwitchName(install_detail.getGoodsName());
                s.setLocation(install_detail.getLocation());
                s.setState("0");
                switchService.save(s);
            }
        }
    }

    public Install_log findById(String id){
        return install_logRepository.findOne(id);
    }

    public void deleteById(String id){ install_logRepository.delete(id); }

    public void  pageByHql(PageEntity<Install_log> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from Install_log where 1=1 ");
        if (paramaMap.containsKey("installNumber")){
            sql.append(" and installNumber =:installNumber ");
        }
        if (paramaMap.containsKey("installerName")){
            sql.append(" and installerName =:installerName ");
        }
        if (paramaMap.containsKey("inputName")){
            sql.append(" and inputName =:inputName ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }
    public List<Install_log> findAll() {return install_logRepository.findAll();}
}
