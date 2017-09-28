package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.NumberUtills;
import com.bupt.domain.InstallInfoAndDetail;
import com.bupt.domain.Install_detail;
import com.bupt.domain.Install_info;
import com.bupt.repository.Install_infoRepository;
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
public class Install_infoService extends BasePageService<Install_info,String> {

    @Autowired
    private Install_infoRepository install_infoRepository;
    @Autowired
    private Install_detailService install_detailService;
    @Autowired
    private CommodityService commodityService;

    public void save(Install_info entity){ install_infoRepository.save(entity); }

    public Install_info findById(String id){
        return install_infoRepository.findOne(id);
    }

    public void deleteById(String id){ install_infoRepository.delete(id); }

    public void  pageByHql(PageEntity<Install_info> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from Install_info where 1=1 ");
        if (paramaMap.containsKey("id")){
            sql.append(" and id =:id ");
        }
        if (paramaMap.containsKey("decisionMakerName")){
            sql.append(" and decisionMakerName =:decisionMakerName ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }
    public List<Install_info> findAll() {return install_infoRepository.findAll();}

    public void saveInfoAndDetail(InstallInfoAndDetail entity) {
        Install_info install_info = new Install_info();
        String id = NumberUtills.getNumber();
        install_info.setId(id);
        install_info.setDecisionMakerNumber(entity.getDecisionMakerNumber());
        install_info.setDecisionMakerName(entity.getDecisionMakerName());
        save(install_info);
        //对象中拿到集合
        List<InstallInfoAndDetail.Install_detail> detailBeanList = entity.getArr();
        for(int i=0;i< detailBeanList.size();i++){
            Install_detail install_detail = new Install_detail();
            InstallInfoAndDetail.Install_detail detailBean= detailBeanList.get(i);
            install_detail.setInstallNumber(id);
            install_detail.setGoodsNumber(detailBean.getGoodsNumber());
            install_detail.setGoodsName(detailBean.getGoodsName());
            install_detail.setLocation(detailBean.getLocation());
            install_detail.setSwitchNumber(detailBean.getSwitchNumber());
            install_detail.setType(detailBean.getType());
            install_detailService.save(install_detail);
        }
    }
}
