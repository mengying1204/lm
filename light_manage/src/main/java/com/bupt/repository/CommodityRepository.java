package com.bupt.repository;

import com.bupt.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Stadpole on 2017/9/21.
 */
public interface CommodityRepository extends JpaRepository<Commodity,String> {
}
