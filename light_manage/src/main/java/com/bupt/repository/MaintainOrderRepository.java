package com.bupt.repository;

import com.bupt.domain.MaintainOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by CJ on 2017/9/28.
 */
@Repository
public interface MaintainOrderRepository extends JpaRepository<MaintainOrder,String> {
}
