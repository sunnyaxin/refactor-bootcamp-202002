package cc.xpbootcamp.warmup.cashier;

class OrderReceipt {
    public static final String PRINTING_ORDERS_TITLE = "======Printing Orders======\n";
    public static final String SALES_TAX = "Sales Tax";
    public static final String TOTAL_AMOUNT = "Total Amount";
    public static final double TAX_Rate = .10;

    private Order order;

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        StringBuilder output = new StringBuilder();
        printTitle(output);
        printCustomerInfo(output);
        printProductsInfo(output);
        return output.toString();
    }

    private void printTitle(StringBuilder output) {
        output.append(PRINTING_ORDERS_TITLE);
    }

    private void printCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void printProductsInfo(StringBuilder output) {
        double totalSalesTax = 0d;
        double totalAmount = 0d;

        for (Product product : order.getProducts()) {
            printProductBasicInfo(output, product);

            double salesTax = product.totalAmount() * TAX_Rate;
            totalSalesTax += salesTax;
            totalAmount += product.totalAmount() + salesTax;
        }
        output.append(SALES_TAX).append('\t').append(totalSalesTax);
        output.append(TOTAL_AMOUNT).append('\t').append(totalAmount);
    }

    private void printProductBasicInfo(StringBuilder output, Product product) {
        output.append(product.getDescription()).append('\t');
        output.append(product.getPrice()).append('\t');
        output.append(product.getQuantity()).append('\t');
        output.append(product.totalAmount()).append('\n');
    }
}