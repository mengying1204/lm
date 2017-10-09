package com.bupt.service;

import com.bupt.common.base.BasePageService;
import com.bupt.common.base.PageEntity;
import com.bupt.common.utils.NumberUtills;
import com.bupt.domain.MaintainInfo;
import com.bupt.domain.MaintainMult;
import com.bupt.domain.Order;
import com.bupt.repository.OrderRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by CJ on 2017/10/9.
 */
@Service
public class OrderService extends BasePageService<Order,String> {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MaintainInfoService maintainInfoService;

    public Order findOne(String id){
        return orderRepository.findOne(id);
    }

    public void delete(String id) {
        orderRepository.delete(id);
    }

    public void save(Order maintainOrder){
        orderRepository.save(maintainOrder);
    }

    public void  pageByHql(PageEntity<Order> pageEntity, Map<String,Object> paramaMap){
        StringBuilder sql = new StringBuilder(" from Order where 1=1 ");
        if (paramaMap.containsKey("maintainNumber")){
            sql.append(" and maintainNumber =:maintainNumber ");
        }
        if (paramaMap.containsKey("monitorName")){
            sql.append(" and monitorName =:monitorName ");
        }
        if (paramaMap.containsKey("monitorNumber")){
            sql.append(" and monitorNumber =:monitorNumber ");
        }
        super.pageByHql(sql.toString(),pageEntity,paramaMap);
        translate(pageEntity.getResults());
    }

    public List<Order> find(){
       return orderRepository.findAll();
    }

    public void save(String data) {
        MaintainMult resultBean = new Gson().fromJson(data, MaintainMult.class);
        Order temp = new Order();
        temp.setMaintainNumber(NumberUtills.getNumber());
        temp.setMonitorName(resultBean.getDecisionMakerName());
        temp.setMonitorNumber(resultBean.getDecisionMakerNumber());
        this.save(temp);

        String order = temp.getMaintainNumber();


        //对象中拿到集合
        List<MaintainMult.Temp> userBeanList = resultBean.getArr();
        for (int i = 0; i < userBeanList.size(); i++) {
            MaintainInfo maintainInfo = new MaintainInfo();
            maintainInfo.setMaintainNumber(order);
            System.out.println(order);
            maintainInfo.setType(userBeanList.get(i).getType());
            System.out.println(userBeanList.get(i).getType());
            maintainInfo.setLightId(userBeanList.get(i).getId());
            System.out.println(userBeanList.get(i).getId());
            maintainInfoService.save(maintainInfo);

        }
    }
}
