package com.aplication.demo.Service;

import com.aplication.demo.Entity.UsageHistory;
import com.aplication.demo.Repositories.hisReposities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class historyService {
    @Autowired
    private hisReposities usageHistoryRepository;
    @Autowired
    private tariffService tariffService;

    public List<UsageHistory> getHistory() {
        return usageHistoryRepository.findAllByOrderByDate();
    }
    public UsageHistory saveHistory(LocalDate date , int Kwh) {
        double tariff = tariffService.totalCost(Kwh);
        UsageHistory usageHistory = new UsageHistory();
        usageHistory.setDate(date);
        usageHistory.setKwh(Kwh);
        usageHistory.setTotal(tariff);
        return usageHistoryRepository.save(usageHistory);
    }
}
