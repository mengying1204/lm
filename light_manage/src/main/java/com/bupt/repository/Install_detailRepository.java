package com.bupt.repository;

import com.bupt.domain.Install_detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mengying on 2017/9/26.
 */
public interface Install_detailRepository extends JpaRepository<Install_detail, String> {
    List<Install_detail> findByInstallNumber(String installNumber);
}
