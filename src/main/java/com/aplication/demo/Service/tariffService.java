package com.aplication.demo.Service;

import com.aplication.demo.Entity.ElectricPrices;
import com.aplication.demo.Repositories.epRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tariffService {
    @Autowired
    private epRepositories euRepositories;
    public double totalCost (int Kwh ){
        List<ElectricPrices> prices = euRepositories.findAllByOrderByFromKwh();

        double total = 0;
        for (ElectricPrices price : prices) {
            if(Kwh > price.getToKwh()){
                total += (price.getToKwh()-price.getFromKwh()+1)*price.getPrice();
            }
            else if (Kwh > price.getFromKwh()) {
                total += (Kwh-price.getFromKwh()+1)*price.getPrice();
                break;
            }
        }
        return total;
    }
}
