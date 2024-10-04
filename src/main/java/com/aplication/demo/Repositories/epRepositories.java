package com.aplication.demo.Repositories;

import com.aplication.demo.Entity.ElectricPrices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface epRepositories extends JpaRepository<ElectricPrices,Long> {
        List<ElectricPrices> findAllByOrderByFromKwh();
}
