package com.bupt.controller;

import com.bupt.common.base.PageEntity;
import com.bupt.domain.MaintainInput;
import com.bupt.service.MaintainInputService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.bupt.common.utils.MessageUtil.sendFailMessage;
import static com.bupt.common.utils.MessageUtil.sendSuccessMessage;


/**
 * Created by CJ on 2017/9/21.
 */
@RestController
@RequestMapping("/maintainInput")
public class MaintainInputController {
    @Autowired
    MaintainInputService maintainInputService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody MaintainInput entity) {
        maintainInputService.save(entity);
        return sendSuccessMessage();
    }
    //查询
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findByCode(@PathVariable(value = "id") String id) {
        MaintainInput maintainInput=maintainInputService.findById(id);
        return sendSuccessMessage(maintainInput);
    }
    //删除
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable(value = "id") String ids) {
        if (StringUtils.isNotBlank(ids)) {
            maintainInputService.delete(ids);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();
        }
    }

    @RequestMapping("/page")
    public String page(MaintainInput entity, int page, int size){
        int start = (page - 1) * size;
        PageEntity<MaintainInput> pageEntity = new PageEntity<>(start, size,page);
        maintainInputService.pageByHql(pageEntity,buildParameter(entity));
        return sendSuccessMessage(pageEntity);
    }

    private Map<String,Object> buildParameter(MaintainInput entity){
        Map<String,Object> parameterMap = new HashMap<>();
        if (StringUtils.isNotBlank(entity.getMaintainNumber())){
            parameterMap.put("maintainNumber", entity.getMaintainNumber());
        }
        if (StringUtils.isNotBlank(entity.getMaintainerName())){
            parameterMap.put("maintainerName", entity.getMaintainerName());
        }
        if (StringUtils.isNotBlank(entity.getMaintainerNumber())){
            parameterMap.put("maintainerNumber", entity.getMaintainerNumber());
        }
        if (StringUtils.isNotBlank(entity.getInputName())){
            parameterMap.put("inputName",entity.getInputName());
        }
        if (StringUtils.isNotBlank(entity.getInputNumber())){
            parameterMap.put("inputNumber",entity.getInputNumber());
        }
        return parameterMap;
    }
}
