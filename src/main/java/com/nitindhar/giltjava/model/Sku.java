package com.nitindhar.giltjava.model;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Sku extends AbstractData {

    @JsonProperty("id")
    @NotNull
    private final int id;

    @JsonProperty("msrp_price")
    @NotNull
    private final double msrpPrice;

    @JsonProperty("sale_price")
    @NotNull
    private final double salePrice;

    @JsonProperty("shipping_surcharge")
    private final double shippingSurcharge;

    @JsonProperty("attributes")
    private final List<Map<String,String>> attributes;

    @JsonCreator
    public Sku(@JsonProperty("id") @NotNull int id,
               @JsonProperty("msrp_price") @NotNull double msrpPrice,
               @JsonProperty("sale_price") @NotNull double salePrice,
               @JsonProperty("shipping_surcharge") double shippingSurcharge,
               @JsonProperty("attributes") List<Map<String,String>> attributes) {
        this.id = id;
        this.msrpPrice = msrpPrice;
        this.salePrice = salePrice;
        this.shippingSurcharge = shippingSurcharge;
        this.attributes = attributes;
    }

    public int getId() {
        return id;
    }

    public double getMsrpPrice() {
        return msrpPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public double getShippingSurcharge() {
        return shippingSurcharge;
    }

    public List<Map<String, String>> getAttributes() {
        return attributes;
    }

}