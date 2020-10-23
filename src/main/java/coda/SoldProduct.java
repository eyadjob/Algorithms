package coda;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

@Value
class SoldProduct {
    String name;
    BigDecimal price;
    String currency;


}
