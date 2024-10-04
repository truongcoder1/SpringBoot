package com.aplication.demo.Controller;

import com.aplication.demo.Entity.ElectricPrices;
import com.aplication.demo.Repositories.epRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ElectricPrice")
public class tariffController {
    @Autowired
    private epRepositories electricPricesRepository;

    @PostMapping
    public ElectricPrices createElectricPrice(@RequestBody ElectricPrices electricPrices) {
        return electricPricesRepository.save(electricPrices);
    }
    @GetMapping
    public List<ElectricPrices> getAllElectricPrices() {
        return electricPricesRepository.findAllByOrderByFromKwh();
    }
}
