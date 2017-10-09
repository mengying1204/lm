package com.bupt.repository;

import com.bupt.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by CJ on 2017/10/9.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,String>{
}
