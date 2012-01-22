package com.giltjava.model;

import java.util.Map;

public class Sku {
    
    private int msrpPrice;
    private int salePrice;
    private int shippingSurcharge;
    private Map<String,String>[] attributes;

    public int getMsrpPrice() {
        return msrpPrice;
    }
    public void setMsrpPrice(int msrpPrice) {
        this.msrpPrice = msrpPrice;
    }
    public int getSalePrice() {
        return salePrice;
    }
    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }
    public int getShippingSurcharge() {
        return shippingSurcharge;
    }
    public void setShippingSurcharge(int shippingSurcharge) {
        this.shippingSurcharge = shippingSurcharge;
    }
    public Map<String, String>[] getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, String>[] attributes) {
        this.attributes = attributes;
    }
    
}
