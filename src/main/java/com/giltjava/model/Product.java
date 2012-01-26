package com.giltjava.model;

import java.util.List;


public class Product {
    
    private String name;
    private String brand;
    private List<ProductContent> content;
    private List<Sku> skus;
    private String url;
    private List<String> imageUrls;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public List<ProductContent> getContent() {
        return content;
    }
    
    public void setContent(List<ProductContent> content) {
        this.content = content;
    }
    
    public List<Sku> getSkus() {
        return skus;
    }
    
    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public List<String> getImageUrls() {
        return imageUrls;
    }
    
    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

}
