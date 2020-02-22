package cc.xpbootcamp.warmup.cashier;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

class OrderReceipt {
    private static final String PRINTING_ORDERS_TITLE = "====== 老王超市,值得信赖 ======\n\n";
    private static final String DIVIDER = "--------------------------\n";
    private static final String SALES_TAX = "税额";
    private static final String TOTAL_AMOUNT = "总价";
    private static final String DISCOUNT = "折扣";

    private Order order;

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        return printTitle() +
                printDate() +
                printProductsInfo() +
                printDivider() +
                printPrice();
    }

    private String printTitle() {
        return PRINTING_ORDERS_TITLE;
    }

    private String printDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y年M月d日,E\n\n", Locale.CHINA);
        return order.getOrderDate().format(formatter);
    }

    private String printProductsInfo() {
        return order.getProducts().stream().map(product ->
                String.format("%s,%.2fx%d,%.2f\n",
                        product.getDescription(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.totalAmount()))
                .collect(Collectors.joining());
    }

    private String printDivider() {
        return DIVIDER;
    }

    private String printPrice() {
        return String.format(SALES_TAX + ":%.2f\n", order.calculateTax()) +
                (order.hasDiscount() ? String.format(DISCOUNT + ":%.2f\n", order.calculateDiscount()) : null) +
                String.format(TOTAL_AMOUNT + ":%.2f\n", order.calculateTotalAmount());
    }
}