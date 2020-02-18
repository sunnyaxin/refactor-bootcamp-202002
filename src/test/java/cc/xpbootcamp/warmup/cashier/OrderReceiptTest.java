package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

class OrderReceiptTest {
    @Test
    public void shouldPrintDateProductsAndSalesTaxInformation() {
        List<Product> products = new ArrayList<Product>() {{
            add(new Product("milk", 10.0, 2));
            add(new Product("biscuits", 5.0, 5));
            add(new Product("chocolate", 20.0, 1));
        }};
        OrderDate orderDate = new OrderDate(2020, Month.FEBRUARY, 17, DayOfWeek.MONDAY);
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, orderDate, products));

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月17日，星期一\n\n"));
        assertThat(output, containsString("milk，10.0x2，20.0\n"));
        assertThat(output, containsString("biscuits，5.0x5，25.0\n"));
        assertThat(output, containsString("chocolate，20.0x1，20.0\n"));
        assertThat(output, containsString("税额：6.5\n"));
        assertThat(output, containsString("总价：71.5\n"));
    }

    @Test
    void shouldPrintDiscountWhenWeekdayIsWednesday() {
        List<Product> products = new ArrayList<Product>() {{
            add(new Product("巧克力", 21.5, 2));
            add(new Product("小白菜", 10.0, 1));
        }};
        OrderDate orderDate = new OrderDate(2020, Month.FEBRUARY, 19, DayOfWeek.WEDNESDAY);
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, orderDate, products));

        String output = receipt.printReceipt();
        String expectedOutput = "====== 老王超市，值得信赖 ======\n\n" +
                "2020年2月19日，星期三\n\n" +
                "巧克力，21.5x2，43.0\n" +
                "小白菜，10.0x1，10.0\n" +
                "--------------------------\n" +
                "税额：5.3\n" +
                "折扣：1.166\n" +
                "总价：57.134\n";

        assertThat(output, is(expectedOutput));
    }
}