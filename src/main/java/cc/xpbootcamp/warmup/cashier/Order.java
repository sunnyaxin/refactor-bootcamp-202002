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
}
