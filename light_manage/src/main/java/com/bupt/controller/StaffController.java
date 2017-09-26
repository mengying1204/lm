package com.bupt.controller;

import com.bupt.common.base.BaseCommonController;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.BeanUtills;
import com.bupt.common.utils.DateUtil;
import com.bupt.domain.Commodity;
import com.bupt.domain.Staff;
import com.bupt.service.CommodityService;
import com.bupt.service.StaffService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stadpole on 2017/9/21.
 */
@RestController
@RequestMapping(value="/staff")
public class StaffController extends BaseCommonController {
    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@RequestBody Staff entity){
        staffService.save(entity);
        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody Staff entity){
        if((StringUtils.isNotBlank(entity.getId()))){
            Staff staff=staffService.findOne(entity.getId());
            BeanUtills.copyProperties(entity, staff);
            staffService.save(staff);
            return sendSuccessMessage();
        }else {
            return sendFailMessage();
        }
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findOne(@PathVariable(value="id") String id){
        Staff entity= staffService.findOne(id);
         return sendMessage("true", "", entity, DateUtil.DATE);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value="id") String id){
        staffService.deleteById(id);
        return sendSuccessMessage();
    }
    @RequestMapping("/page")
    public String page( Staff entity,int page,int size) {
        int start=(page-1)*size;
        PageEntity<Staff> pageEntity = new PageEntity<>(start,size,page);
        staffService.pageByHql(pageEntity, buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }
    private Map<String, Object> buildParameter(Staff entity) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (entity.getId()!=null){
            parameterMap.put("job", entity.getJob());
        }
        return parameterMap;
    }
}

