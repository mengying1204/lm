package com.bupt.repository;

import com.bupt.domain.PurchaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Stadpole on 2017/9/21.
 */
public interface PurchaseInfoRepository extends JpaRepository<PurchaseInfo,String> {
}
