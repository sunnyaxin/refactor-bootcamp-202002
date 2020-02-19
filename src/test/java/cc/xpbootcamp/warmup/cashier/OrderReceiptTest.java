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

        assertThat(output, containsString("2020年2月17日,星期一\n\n"));
        assertThat(output, containsString("milk,10.00x2,20.00\n"));
        assertThat(output, containsString("biscuits,5.00x5,25.00\n"));
        assertThat(output, containsString("chocolate,20.00x1,20.00\n"));
        assertThat(output, containsString("税额:6.50\n"));
        assertThat(output, containsString("总价:71.50\n"));
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
        String expectedOutput = "====== 老王超市,值得信赖 ======\n\n" +
                "2020年2月19日,星期三\n\n" +
                "巧克力,21.50x2,43.00\n" +
                "小白菜,10.00x1,10.00\n" +
                "--------------------------\n" +
                "税额:5.30\n" +
                "折扣:1.17\n" +
                "总价:57.13\n";

        assertThat(output, is(expectedOutput));
    }
}