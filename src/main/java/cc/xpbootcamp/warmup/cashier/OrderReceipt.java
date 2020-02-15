package cc.xpbootcamp.warmup.cashier;

class OrderReceipt {
    private Order order;

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

        double totSalesTx = 0d;
        double tot = 0d;
        for (Product product : order.getLineItems()) {
            output.append(product.getDescription());
            output.append('\t');
            output.append(product.getPrice());
            output.append('\t');
            output.append(product.getQuantity());
            output.append('\t');
            output.append(product.totalAmount());
            output.append('\n');

            double salesTax = product.totalAmount() * .10;
            totSalesTx += salesTax;

            tot += product.totalAmount() + salesTax;
        }

        output.append("Sales Tax").append('\t').append(totSalesTx);

        output.append("Total Amount").append('\t').append(tot);
        return output.toString();
    }
}