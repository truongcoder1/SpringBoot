package com.aplication.demo.Repositories;

import com.aplication.demo.Entity.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface hisReposities extends JpaRepository<UsageHistory,Long> {
        List<UsageHistory> findAllByOrderByDate();
}
