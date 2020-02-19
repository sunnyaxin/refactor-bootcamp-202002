package cc.xpbootcamp.warmup.cashier;

import java.util.List;

class Order {
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
            double salesTax = product.totalAmount() * OrderReceipt.TAX_Rate;
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
        if (getOrderDate().getWeekDay().getValue() == OrderReceipt.DISCOUNT_WEEK_DAY)
            discount = totalAmount * OrderReceipt.DISCOUNT_RATE;
        return discount;
    }
}
