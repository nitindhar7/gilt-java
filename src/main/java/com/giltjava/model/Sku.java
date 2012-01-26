package com.giltjava.model;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class Sku {
    
    private double msrpPrice;
    private double salePrice;
    private double shippingSurcharge;
    private List<Map<String,String>> attributes;

    @JsonSerialize
    public double getMsrpPrice() {
        return msrpPrice;
    }
    public void setMsrpPrice(double msrpPrice) {
        this.msrpPrice = msrpPrice;
    }
    public double getSalePrice() {
        return salePrice;
    }
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
    public double getShippingSurcharge() {
        return shippingSurcharge;
    }
    public void setShippingSurcharge(double shippingSurcharge) {
        this.shippingSurcharge = shippingSurcharge;
    }
    public List<Map<String, String>> getAttributes() {
        return attributes;
    }
    public void setAttributes(List<Map<String, String>> attributes) {
        this.attributes = attributes;
    }
    
}
