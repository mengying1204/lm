package com.bupt.repository;

import com.bupt.domain.WarehouseName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Stadpole on 2017/9/21.
 */
public interface WarehouseNameRepository extends JpaRepository<WarehouseName,String> {
    WarehouseName findByCode(String code);
}
