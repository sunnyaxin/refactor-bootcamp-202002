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

        double totalTax = order.calculateTax();
        double totalAmount = order.calculateAmount() + totalTax;
        double discount = order.calculateDiscount(totalAmount);
        printPrice(totalTax, discount, totalAmount, output);
        return output.toString();
    }

    private void printPrice(double totalTax, double discount, double totalAmount, StringBuilder output) {
        output.append(String.format(SALES_TAX + ":%.2f", totalTax)).append('\n');
        if (discount != 0)
            output.append(String.format(DISCOUNT + ":%.2f", discount)).append('\n');
        output.append(String.format(TOTAL_AMOUNT + ":%.2f", totalAmount - discount)).append('\n');
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
            output.append(product.getDescription()).append(',');
            output.append(String.format("%.2fx%d,%.2f", product.getPrice(), product.getQuantity(), product.totalAmount())).append('\n');
        }
    }

    private void printDivider(StringBuilder output) {
        output.append(DIVIDER);
    }
}