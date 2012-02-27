package com.nitindhar.giltjava.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Sale implements Serializable {

    private static final long serialVersionUID = 5142716569349543687L;

    @JsonProperty("name")
    @NotNull
    private final String name;
    
    @JsonProperty("sale")
    @NotNull
    private final String sale;
    
    @JsonProperty("sale_key")
    @NotNull
    private final String saleKey;
    
    @JsonProperty("store")
    @NotNull
    private final String storeKey;
    
    @JsonProperty("description")
    private final String description;
    
    @JsonProperty("sale_url")
    @NotNull
    private final String saleUrl;
    
    @JsonProperty("begins")
    @NotNull
    private final String begins;
    
    @JsonProperty("ends")
    private final String ends;
    
    @JsonProperty("image_urls")
    @NotNull
    private final Map<String,List<ImageUrl>> imageUrls;
    
    @JsonProperty("products")
    private final List<String> products;
    
    @JsonCreator
    public Sale(@JsonProperty("name") @NotNull String name,
                @JsonProperty("sale") @NotNull String sale,
                @JsonProperty("sale_key") @NotNull String saleKey,
                @JsonProperty("store") @NotNull String storeKey,
                @JsonProperty("description") String description,
                @JsonProperty("sale_url") @NotNull String saleUrl,
                @JsonProperty("begins") @NotNull String begins,
                @JsonProperty("ends") String ends,
                @JsonProperty("image_urls") @NotNull Map<String,List<ImageUrl>> imageUrls,
                @JsonProperty("products") @NotNull List<String> products) {
        this.name = name;
        this.sale = sale;
        this.saleKey = saleKey;
        this.storeKey = storeKey;
        this.description = description;
        this.saleUrl = saleUrl;
        this.begins = begins;
        this.ends = ends;
        this.imageUrls = imageUrls;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public String getSale() {
        return sale;
    }

    public String getSaleKey() {
        return saleKey;
    }

    public String getStoreKey() {
        return storeKey;
    }

    public String getDescription() {
        return description;
    }

    public String getSaleUrl() {
        return saleUrl;
    }

    public String getBegins() {
        return begins;
    }

    public String getEnds() {
        return ends;
    }

    public Map<String, List<ImageUrl>> getImageUrls() {
        return imageUrls;
    }

    public List<String> getProducts() {
        return products;
    }

}
