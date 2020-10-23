//package coda;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Stream;
//
//public class Sol3 {
//
//    public static void main(String[] args) {
//        Stream<SoldProduct> products;
//        List<SimpleSoldProduct> simpleSoldProductList = new ArrayList<>();
//        BigDecimal totalOfProductsPrice = new BigDecimal(0);
//
//        products.forEach(p -> {
//            if (p.getName() != null  &&  p.getCurrency() != null && !p.getName().isEmpty() && !p.getCurrency().isEmpty() && p.getPrice() != null && p.getPrice().compareTo(BigDecimal.ZERO) > 1)
//                simpleSoldProductList.add(new SimpleSoldProduct(p.getName(), p.getPrice()));
//        });
//
//        for (SimpleSoldProduct p : simpleSoldProductList) {
//
//            totalOfProductsPrice.add(p.getPrice());
//        }
//
//        SoldProductsAggregate soldProductsAggregate = new SoldProductsAggregate(simpleSoldProductList, totalOfProductsPrice);
//
//
//    }
//}
