package cc.xpbootcamp.warmup.cashier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

class OrderReceipt {
    public static final String PRINTING_ORDERS_TITLE = "====== 老王超市,值得信赖 ======\n";
    public static final String DIVIDER = "--------------------------\n";
    public static final String SALES_TAX = "税额";
    public static final String TOTAL_AMOUNT = "总价";
    public static final String DISCOUNT = "折扣";

    private Order order;

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        StringBuilder output = new StringBuilder();
        printTitle(output);
        printDate(output);
        printProductsInfo(output);
        printDivider(output);
        printPrice(output);
        return output.toString();
    }

    private void printPrice(StringBuilder output) {
        output.append(String.format(SALES_TAX + ":%.2f", order.calculateTax())).append('\n');
        if (order.hasDiscount())
            output.append(String.format(DISCOUNT + ":%.2f", order.calculateDiscount())).append('\n');
        output.append(String.format(TOTAL_AMOUNT + ":%.2f", order.calculateTotalAmount())).append('\n');
    }

    private void printTitle(StringBuilder output) {
        output.append(PRINTING_ORDERS_TITLE).append('\n');
    }

    private void printDate(StringBuilder output) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y年M月d日,E", Locale.CHINA);
        String date = order.getOrderDate().format(formatter);
        output.append(date).append("\n\n");
    }

    private void printProductsInfo(StringBuilder output) {
        for (Product product : order.getProducts()) {
            output.append(String.format("%s,%.2fx%d,%.2f", product.getDescription(), product.getPrice(), product.getQuantity(), product.totalAmount())).append('\n');
        }
    }

    private void printDivider(StringBuilder output) {
        output.append(DIVIDER);
    }
}