package com.giltjava.model;

import java.util.List;


public class Sale {
    
    public static final String ACTIVE = "active";
    public static final String UPCOMING = "upcoming";
    
    private String name;
    private String saleUrl;
    private List<String> imageUrls;
    private String begins;
    private String ends;
    private String description;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSaleUrl() {
        return saleUrl;
    }
    
    public void setSaleUrl(String saleUrl) {
        this.saleUrl = saleUrl;
    }
    
    public List<String> getImageUrls() {
        return imageUrls;
    }
    
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
    
    public String getBegins() {
        return begins;
    }
    
    public void setBegins(String begins) {
        this.begins = begins;
    }
    
    public String getEnds() {
        return ends;
    }
    
    public void setEnds(String ends) {
        this.ends = ends;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
