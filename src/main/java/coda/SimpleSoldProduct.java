package coda;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Data
class SimpleSoldProduct {
    String name;
    BigDecimal price;
}