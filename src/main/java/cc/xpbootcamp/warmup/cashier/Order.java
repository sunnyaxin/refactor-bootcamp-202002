package cc.xpbootcamp.warmup.cashier;

import java.util.List;

class Order {
    private String customerName;
    private String customerAddress;
    private List<Product> products;

    Order(String customerName, String customerAddress, List<Product> products) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.products = products;
    }

    String getCustomerName() {
        return customerName;
    }

    String getCustomerAddress() {
        return customerAddress;
    }

    List<Product> getLineItems() {
        return products;
    }
}
