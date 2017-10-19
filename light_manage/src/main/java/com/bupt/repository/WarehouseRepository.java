package com.bupt.repository;

import com.bupt.domain.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Stadpole on 2017/9/21.
 */
public interface WarehouseRepository extends JpaRepository<Warehouse, String> {
    @Query
    List<Warehouse> findByName(String name);
}
