package cc.xpbootcamp.warmup.cashier;

class OrderReceipt {
    public static final String PRINTING_ORDERS_TITLE = "====== 老王超市，值得信赖 ======\n";
    public static final String DIVIDER = "--------------------------\n";
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
        printDivider(output);
        double totalTax = printTax(output);
        printAmount(output, totalTax);
        return output.toString();
    }

    private void printTitle(StringBuilder output) {
        output.append(PRINTING_ORDERS_TITLE).append('\n');
    }

    private void printProductsInfo(StringBuilder output) {
        for (Product product : order.getProducts()) {
            output.append(product.getDescription()).append('，');
            output.append(product.getPrice()).append('x');
            output.append(product.getQuantity()).append('，');
            output.append(product.totalAmount()).append('\n');
        }
    }

    private void printDivider(StringBuilder output) {
        output.append(DIVIDER);
    }

    private double printTax(StringBuilder output) {
        double totalSalesTax = 0d;
        for (Product product : order.getProducts()) {
            double salesTax = product.totalAmount() * TAX_Rate;
            totalSalesTax += salesTax;
        }
        output.append(SALES_TAX).append('：').append(totalSalesTax).append('\n');
        return totalSalesTax;
    }

    private void printAmount(StringBuilder output, double totalTax) {
        double totalAmount = 0d;
        for (Product product : order.getProducts()) {
            totalAmount += product.totalAmount();
        }
        output.append(TOTAL_AMOUNT).append('：').append(totalAmount + totalTax).append('\n');
    }
}