package cc.xpbootcamp.warmup.cashier;

import java.util.List;

class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItemList;

    Order(String customerName, String customerAddress, List<LineItem> lineItemList) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItemList = lineItemList;
    }

    String getCustomerName() {
        return customerName;
    }

    String getCustomerAddress() {
        return customerAddress;
    }

    List<LineItem> getLineItems() {
        return lineItemList;
    }
}
