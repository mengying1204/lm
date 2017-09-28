package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Install_detail;
import com.bupt.service.Install_detailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mengying on 2017/9/28.
 */
@RestController
@RequestMapping("/installdetail")
public class Install_detailController extends BaseCommonController {
    @Autowired
    private Install_detailService install_detailService;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String save(@RequestBody Install_detail entity) {
        install_detailService.save(entity);
        return sendSuccessMessage();
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public String update(@RequestBody Install_detail entity) {
        if (StringUtils.isNotBlank(entity.getId())){
            Install_detail install_detail = install_detailService.findById(entity.getId());
            BeanUtills.copyProperties(entity,install_detail);
            install_detailService.save(install_detail);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String find(@PathVariable("id") String id){
        Install_detail install_detail = install_detailService.findById(id);
        return sendMessage("true","",install_detail, DateUtil.DATE);
    }

    @RequestMapping("/page")
    public String page(Install_detail entity,int page,int size){
        int start = (page - 1) * size;
        PageEntity<Install_detail> pageEntity = new PageEntity<>(start, size,page);
        install_detailService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(Install_detail entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getInstallNumber())){
            parameterMap.put("installNumber", entity.getInstallNumber());
        }
        return parameterMap;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable ("id") String id) {
        install_detailService.deleteById(id);
        return sendSuccessMessage();
    }

    @RequestMapping("/test/{installNumber}")
    public String find1(@PathVariable("installNumber") String installNumber){
        List<Install_detail> result = install_detailService.findByInstallNumber(installNumber);
        return sendMessage("true","",result, DateUtil.DATE);
    }
}
