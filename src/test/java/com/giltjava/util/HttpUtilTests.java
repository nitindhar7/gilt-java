package com.giltjava.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.giltjava.model.Product;
import com.giltjava.model.ProductContent;
import com.giltjava.model.Sale;

public class HttpUtilTests {
    
    @Test (groups={"ready"})
    public void testGet() {
        URL url = getClass().getClassLoader().getResource("sales_without_options.json");
        String json = HttpUtil.get(url.toString());
        TestCase.assertNotNull(json);
        TestCase.assertEquals(861, json.length());
    }
    
    @Test (groups={"ready"})
    public void testTest() throws JsonProcessingException, IOException {
        URL url = getClass().getClassLoader().getResource("sales_with_options.json");
        String json = HttpUtil.get(url.toString());
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);

        List<Sale> sales = new ArrayList<Sale>();

        for (JsonNode saleNode : root) {
            // Add sale data
            Sale sale = new Sale();
            sale.setName(saleNode.get("name").getTextValue());
            sale.setSaleUrl(saleNode.get("sale_url").getTextValue());
            List<String> imageUrls = new ArrayList<String>();
            for(JsonNode imageUrl : saleNode.get("image_urls")) {
                imageUrls.add(imageUrl.getTextValue());
            }
            sale.setImageUrls(imageUrls);
            sale.setBegins(saleNode.get("begins").getTextValue());
            if(saleNode.has("ends"))
                sale.setEnds(saleNode.get("ends").getTextValue());
            if(saleNode.has("description"))
                sale.setDescription(saleNode.get("description").getTextValue());
            
            // Add product data
            if(saleNode.has("products")) {
                List<Product> products = new ArrayList<Product>();
                for(JsonNode productNode : saleNode.get("products")) {
                    Product product = new Product();
                    product.setName(productNode.get("name").getTextValue());
                    product.setBrand(productNode.get("brand").getTextValue());
                    if(productNode.has("url"))
                        product.setUrl(productNode.get("url").getTextValue());
                    if(productNode.has("image_urls")) {
                        List<String> productImageUrls = new ArrayList<String>();
                        for(JsonNode imageUrl : productNode.get("image_urls")) {
                            productImageUrls.add(imageUrl.getTextValue());
                        }
                        product.setImageUrls(productImageUrls);
                    }
                    
                    // Add product content data
                    List<ProductContent> productContents = new ArrayList<ProductContent>();
                    if(productNode.get("content").isArray()) {
                        for(JsonNode productContentNode : productNode.get("content")) {
                            ProductContent productContent = new ProductContent();
                            productContent.setDescription(productContentNode.get("description").getTextValue());
                            productContent.setFitNotes(productContentNode.get("fit_notes").getTextValue());
                            productContent.setMaterial(productContentNode.get("material").getTextValue());
                            productContent.setCareInstructions(productContentNode.get("care_instructions").getTextValue());
                            productContent.setOrigin(productContentNode.get("origin").getTextValue());
                            productContents.add(productContent);
                        }
                    } else {
                        ProductContent productContent = new ProductContent();
                        JsonNode productContentNode = productNode.get("content");
                        productContent.setDescription(productContentNode.get("description").getTextValue());
                        productContent.setFitNotes(productContentNode.get("fit_notes").getTextValue());
                        productContent.setMaterial(productContentNode.get("material").getTextValue());
                        productContent.setCareInstructions(productContentNode.get("care_instructions").getTextValue());
                        productContent.setOrigin(productContentNode.get("origin").getTextValue());
                        productContents.add(productContent);
                    }
                    product.setContent(productContents);
                    products.add(product);
                }
                sale.setProducts(products);
            }
            sales.add(sale);
        }

    }

}
