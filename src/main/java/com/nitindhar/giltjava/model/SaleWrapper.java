package com.nitindhar.giltjava.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("serial")
@JsonIgnoreProperties(ignoreUnknown=true)
public class SaleWrapper extends AbstractData {

    @JsonProperty("sales")
    @NotNull
    private final List<Sale> sales;

    @JsonCreator
    public SaleWrapper(@JsonProperty("sales") @NotNull List<Sale> sales) {
        this.sales = sales;
    }

    public List<Sale> getSales() {
        return sales;
    }

}