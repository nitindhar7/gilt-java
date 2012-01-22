package com.giltjava.model;

public class Sale {
    
    public static final String ACTIVE = "active";
    public static final String UPCOMING = "upcoming";
    
    private String name;
    private String sale_url;
    private String[] image_urls;
    private String begins;
    private String ends;
    private String description;
    private Product[] products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSale_url() {
        return sale_url;
    }
    
    public void setSale_url(String sale_url) {
        this.sale_url = sale_url;
    }
    
    public String[] getImage_urls() {
        return image_urls;
    }
    
    public void setImage_urls(String[] image_urls) {
        this.image_urls = image_urls;
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
    
    public Product[] getProducts() {
        return products;
    }
    
    public void setProducts(Product[] products) {
        this.products = products;
    }

}
