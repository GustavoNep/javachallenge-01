package com.devsuperior.aula.services;

import com.devsuperior.aula.entities.Order;
import org.springframework.stereotype.Service;


@Service
public class ShippingService {
    public double shipment(Order disc) {
        if(disc.getBasic() < 100) {
            disc.setDiscount(20);
        } else if (disc.getBasic() < 200) {
            disc.setDiscount(12);
        } else {
            disc.setDiscount(0);
        }
        return disc.getDiscount();
    }

}
