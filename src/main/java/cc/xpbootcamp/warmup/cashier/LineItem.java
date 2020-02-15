package cc.xpbootcamp.warmup.cashier;

class LineItem {
    private String description;
    private double price;
    private int quality;

    LineItem(String description, double price, int quality) {
        this.description = description;
        this.price = price;
        this.quality = quality;
    }

    String getDescription() {
        return description;
    }

    double getPrice() {
        return price;
    }

    int getQuantity() {
        return quality;
    }

    double totalAmount() {
        return price * quality;
    }
}