package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<Product> products = new ArrayList<Product>() {{
            add(new Product("milk", 10.0, 2));
            add(new Product("biscuits", 5.0, 5));
            add(new Product("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, products));

        String output = receipt.printReceipt();

        System.out.println(output);
        assertThat(output, containsString("milk，10.0x2，20.0\n"));
        assertThat(output, containsString("biscuits，5.0x5，25.0\n"));
        assertThat(output, containsString("chocolate，20.0x1，20.0\n"));
        assertThat(output, containsString("税额：6.5\n"));
        assertThat(output, containsString("总价：71.5\n"));
    }

}