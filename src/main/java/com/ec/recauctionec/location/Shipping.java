package com.ec.recauctionec.location;

import com.ec.recauctionec.entity.Delivery;
import org.springframework.context.annotation.Bean;


public class Shipping {
    public static float IN = 1;
    public static float OUT = 1.5F;

    public static float calculateShipping(Location src, Location des, Delivery deli) {
        return src == des ? deli.getDiscount() * IN : deli.getDiscount() * OUT;
    }

}
