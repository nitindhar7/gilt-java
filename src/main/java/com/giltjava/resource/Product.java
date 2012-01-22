package com.giltjava.resource;

public class Product {
    
    private String name;
    private String brand;
    private ProductContent[] content;
    private Sku[] skus;
    private String url;
    private String[] imageUrls;
    
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
    
    public ProductContent[] getContent() {
        return content;
    }
    
    public void setContent(ProductContent[] content) {
        this.content = content;
    }
    
    public Sku[] getSkus() {
        return skus;
    }
    
    public void setSkus(Sku[] skus) {
        this.skus = skus;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public String[] getImageUrls() {
        return imageUrls;
    }
    
    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

}
