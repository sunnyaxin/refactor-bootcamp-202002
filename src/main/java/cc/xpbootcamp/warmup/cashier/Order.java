package cc.xpbootcamp.warmup.cashier;

import java.util.List;

class Order {
    public static final double TAX_Rate = .10;
    public static final int DISCOUNT_WEEK_DAY = 3;
    public static final double DISCOUNT_RATE = 0.02;

    private String customerName;
    private String customerAddress;
    private OrderDate orderDate;
    private List<Product> products;

    Order(String customerName, String customerAddress, OrderDate orderDate, List<Product> products) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.products = products;
    }

    String getCustomerName() {
        return customerName;
    }

    String getCustomerAddress() {
        return customerAddress;
    }

    public OrderDate getOrderDate() {
        return orderDate;
    }

    List<Product> getProducts() {
        return products;
    }

    double calculateTax() {
        double totalSalesTax = 0d;
        for (Product product : getProducts()) {
            double salesTax = product.totalAmount() * TAX_Rate;
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    double calculateAmount() {
        double totalAmount = 0d;
        for (Product product : getProducts()) {
            totalAmount += product.totalAmount();
        }
        return totalAmount;
    }

    double calculateDiscount(double totalAmount) {
        double discount = 0d;
        if (getOrderDate().getWeekDay().getValue() == DISCOUNT_WEEK_DAY)
            discount = totalAmount * DISCOUNT_RATE;
        return discount;
    }
}
