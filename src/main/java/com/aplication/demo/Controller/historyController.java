package com.aplication.demo.Controller;

import com.aplication.demo.Entity.UsageHistory;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.aplication.demo.Service.historyService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/History")
public class historyController {
    @Autowired
    private historyService historyService;

    @PostMapping
    public UsageHistory recordUsage(@RequestBody UsageHistoryRequest request) {
        return historyService.saveHistory(request.getDate() ,request.getKwh());
    }
    @GetMapping
    public List<UsageHistory> getHistory() {
        return historyService.getHistory();
    }

}
@Data
class UsageHistoryRequest {
    private LocalDate date;
    private int Kwh;

}
