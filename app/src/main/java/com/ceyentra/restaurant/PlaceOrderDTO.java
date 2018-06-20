package com.ceyentra.restaurant;

public class PlaceOrderDTO {

    private String itemname;
    private String qty;
    private String price;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(String itemname, String qty, String price) {
        this.itemname = itemname;
        this.qty = qty;
        this.price = price;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
