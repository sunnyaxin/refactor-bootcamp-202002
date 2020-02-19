package cc.xpbootcamp.warmup.cashier;

class OrderReceipt {
    public static final String PRINTING_ORDERS_TITLE = "====== 老王超市，值得信赖 ======\n";
    public static final String DIVIDER = "--------------------------\n";
    public static final String CHINESE_WEEKDAY_NUMBER = "一二三四五六日";
    public static final String SALES_TAX = "税额";
    public static final String TOTAL_AMOUNT = "总价";
    public static final String DISCOUNT = "折扣";
    public static final double TAX_Rate = .10;
    public static final int DISCOUNT_WEEK_DAY = 3;
    public static final double DISCOUNT_RATE = 0.02;

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
        output.append(SALES_TAX).append('：').append(totalTax).append('\n');
        if (discount != 0)
            output.append(DISCOUNT).append('：').append(discount).append('\n');
        output.append(TOTAL_AMOUNT).append('：').append(totalAmount - discount).append('\n');
    }

    private void printTitle(StringBuilder output) {
        output.append(PRINTING_ORDERS_TITLE).append('\n');
    }

    private void printDate(StringBuilder output) {
        OrderDate date = order.getOrderDate();
        output.append(date.getYear()).append('年');
        output.append(date.getMonth().getValue()).append('月');
        output.append(date.getDay()).append('日').append('，');
        output.append("星期").append(CHINESE_WEEKDAY_NUMBER.charAt(date.getWeekDay().getValue() - 1)).append("\n\n");
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
}