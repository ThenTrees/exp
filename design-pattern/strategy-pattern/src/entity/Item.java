package entity;

public class Item {
    private String upCode;
    private int price;

    public Item(String upCode, int price) {
        this.upCode = upCode;
        this.price = price;
    }

    public String getUpCode() {
        return upCode;
    }

    public void setUpCode(String upCode) {
        this.upCode = upCode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
