package cc.xpbootcamp.warmup.cashier;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

class Order {
    public static final double TAX_RATE = .10;
    public static final double DISCOUNT_RATE = 0.02;

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
        double totalSalesTax = 0d;
        for (Product product : getProducts()) {
            double salesTax = product.totalAmount() * TAX_RATE;
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    double calculateAmountWithTax() {
        double amountWithTax = 0d;
        for (Product product : getProducts()) {
            amountWithTax += product.totalAmount() * (1 + TAX_RATE);
        }
        return amountWithTax;
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
