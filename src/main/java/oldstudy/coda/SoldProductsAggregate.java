package oldstudy.coda;

import lombok.Value;
import java.math.BigDecimal;
import java.util.List;

@Value
class SoldProductsAggregate  {
    List<SimpleSoldProduct> products;
    BigDecimal total;
}