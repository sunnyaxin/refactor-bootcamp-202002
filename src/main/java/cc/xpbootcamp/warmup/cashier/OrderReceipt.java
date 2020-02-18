package cc.xpbootcamp.warmup.cashier;

class OrderReceipt {
    public static final String PRINTING_ORDERS_TITLE = "====== 老王超市，值得信赖 ======\n";
    public static final String SALES_TAX = "税额";
    public static final String TOTAL_AMOUNT = "总价";
    public static final double TAX_Rate = .10;

    private Order order;

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        StringBuilder output = new StringBuilder();
        printTitle(output);
        printProductsInfo(output);
        return output.toString();
    }

    private void printTitle(StringBuilder output) {
        output.append(PRINTING_ORDERS_TITLE).append('\n');
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
        output.append(SALES_TAX).append('：').append(totalSalesTax).append('\n');
        output.append(TOTAL_AMOUNT).append('：').append(totalAmount).append('\n');
    }

    private void printProductBasicInfo(StringBuilder output, Product product) {
        output.append(product.getDescription()).append('，');
        output.append(product.getPrice()).append('x');
        output.append(product.getQuantity()).append('，');
        output.append(product.totalAmount()).append('\n');
    }
}