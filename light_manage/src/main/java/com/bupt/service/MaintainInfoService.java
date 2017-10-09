package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.domain.Light;
import com.bupt.domain.MaintainInfo;
import com.bupt.repository.MaintainInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CJ on 2017/9/21.
 */
@Service
public class MaintainInfoService extends BasePageService<MaintainInfo,String> {
    @Autowired
    MaintainInfoRepository maintainInfoRepository;
    @Autowired
    LightService lightService;

    public void save(MaintainInfo maintainInfo){
        maintainInfoRepository.save(maintainInfo);
    }

    public MaintainInfo findById(String id){
       return maintainInfoRepository.findOne(id);
    }
    public void delete(String id){
        maintainInfoRepository.delete(id);
    }

    public List<MaintainInfo> findByMaintainNumber(String maintainNumber){
        return maintainInfoRepository.findByMaintainNumber(maintainNumber);
    }
    public List<Light> detail(String maintainNumber){
        List<Light> lights=new ArrayList<>();
        List<MaintainInfo> maintainInfos=this.findByMaintainNumber(maintainNumber);
        for(MaintainInfo maintainInfo:maintainInfos){
            Light light=lightService.findById(maintainInfo.getId());
            lights.add(light);
        }
        return lights;
    }

}
