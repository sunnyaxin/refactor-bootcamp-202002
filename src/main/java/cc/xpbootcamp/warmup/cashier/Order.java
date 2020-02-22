package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

class Order {
    private static final double TAX_RATE = .10;
    private static final double DISCOUNT_RATE = 0.02;

    private LocalDate orderDate;
    private List<Product> products;

    Order(LocalDate orderDate, List<Product> products) {
        this.orderDate = orderDate;
        this.products = products;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    List<Product> getProducts() {
        return products;
    }

    double calculateTax() {
        return products.stream().mapToDouble(Product::totalAmount).sum() * TAX_RATE;
    }

    double calculateAmountWithTax() {
        return products.stream().mapToDouble(Product::totalAmount).sum() * (1 + TAX_RATE);
    }

    double calculateTotalAmount() {
        return hasDiscount() ? calculateAmountWithTax() - calculateDiscount() : calculateAmountWithTax();
    }

    double calculateDiscount() {
        return calculateAmountWithTax() * DISCOUNT_RATE;
    }

    boolean hasDiscount() {
        return orderDate.getDayOfWeek() == DayOfWeek.WEDNESDAY;
    }
}
